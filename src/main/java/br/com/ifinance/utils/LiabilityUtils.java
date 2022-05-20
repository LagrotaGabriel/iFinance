package br.com.ifinance.utils;

import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.StatusLiability;
import br.com.ifinance.utils.comparators.Liability.LiabilityDateComparator;
import br.com.ifinance.utils.comparators.Liability.LiabilitySchedulingComparator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LiabilityUtils {

    /*** Tem como objetivo filtrar as despesas do usuário com base no mês e ano passados como parâmetros na url
     * @param user User - Usuário logado na sessão
     * @param currentMonth Integer - Mês que o usuário deseja realizar o filtro
     * @param currentYear Year - Ano que o usuário deseja realizar o filtro
     * @return List - Retorna uma lista com as despesas encontradas no mês e ano filtrados pelo usuário */
    public List<Liability> pageFilterinCurrentMonthAndYear(User user, Integer currentMonth, Integer currentYear){
        // FILTRO DOS LIABILITIES POR DATA
        List<Liability> liabilitiesOfSelectedDate = new ArrayList<>();

        if(user.getLiabilities().size() > 0){

            for(int i = 0; i < user.getLiabilities().size(); i++){

                if(user.getLiabilities().get(i).getCreated() != null && !user.getLiabilities().get(i).getCreated().equals("")) {

                    String atual = null;

                    if(user.getLiabilities().get(i).getStatusLiability().equals(StatusLiability.PAGO)){
                        atual = user.getLiabilities().get(i).getDate().replace("-", "/");
                    }
                    else if(user.getLiabilities().get(i).getStatusLiability().equals(StatusLiability.PAGAR)){
                        atual = user.getLiabilities().get(i).getScheduling().replace("-", "/");
                    }

                    String[] atualSplitado = atual.split("/");

                    if (Integer.parseInt(atualSplitado[2]) == (currentYear)) {

                        if(Integer.parseInt(atualSplitado[1]) == (currentMonth)) {

                            liabilitiesOfSelectedDate.add(user.getLiabilities().get(i));

                        }
                    }
                }
            }
        }

        Collections.sort(liabilitiesOfSelectedDate, new LiabilityDateComparator());
        Collections.sort(liabilitiesOfSelectedDate, new LiabilitySchedulingComparator());

        return liabilitiesOfSelectedDate;

    }

    /*** Tem como objetivo calcular o total de páginas que a tabela terá
     * @param user User - Usuário logado na sessão
     * @param currentMonth Integer - Mês que o usuário deseja realizar o filtro
     * @param currentYear Year - Ano que o usuário deseja realizar o filtro
     * @param itemsPerPage Integer - Quantidade de itens que deve ser exibida por página
     * @return Integer - Retorna a quantidade total de páginas da tela */
    public Integer totalPages(User user, Integer currentMonth, Integer currentYear, Integer itemsPerPage){
        // CLASSIFICANDO O NÚMERO DE PÁGINAS QUE A TABELA TERÁ
        return (int) Math.ceil(Double.parseDouble(String.valueOf(
                        (pageFilterinCurrentMonthAndYear(user, currentMonth, currentYear).size())))/itemsPerPage);
    }

    /*** Tem como objetivo transformar o total de páginas da tela em uma lista contendo os números do 1 até o número total
     * @param totalPages Integer - Total de páginas da tela
     * @return List - Retorna uma lista com os números de 1 até o número total de páginas da tela */
    public List<Integer> pageNumberList(Integer totalPages){
        // DEFININDO A LISTA DE PÁGINAS QUE A TABELA IRÁ POSSUIR
        List<Integer> pageNumbers = new ArrayList<>();
        if(totalPages > 0) {
            pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
        }
        else{
            totalPages = 1;
            pageNumbers.add(1);
        }
        return pageNumbers;
    }

    /*** Tem como objetivo atribuir a quantidade correta de itens para cada página
     * @param user User - Usuário logado na sessão
     * @param currentMonth Integer - Mês que o usuário deseja realizar o filtro
     * @param currentYear Year - Ano que o usuário deseja realizar o filtro
     * @param itemsPerPage Integer - Quantidade de itens que deve ser exibida por página
     * @return Map - Retorna um map contendo as páginas e os itens que cada página contém, respectivamente */
    public Map<Integer, List<Liability>> liabilityPagination(User user, Integer currentMonth, Integer currentYear, Integer itemsPerPage){

        // DEFININDO A QUANTIDADE DE ITENS POR PÁGINA DA TABELA
        Map<Integer, List<Liability>> mapPages = new HashMap();
        List<Liability> paginationLiabilities = new ArrayList<>();

        int contador = itemsPerPage;
        for(int i = 0; i < pageNumberList(totalPages(user, currentMonth, currentYear, itemsPerPage)).size(); i++){

            for(int x=(contador-itemsPerPage); x < contador; x++){
                if(pageFilterinCurrentMonthAndYear(user, currentMonth, currentYear) != null) {
                    if (x < pageFilterinCurrentMonthAndYear(user, currentMonth, currentYear).size()) {
                        paginationLiabilities.add(pageFilterinCurrentMonthAndYear(user, currentMonth, currentYear).get(x));
                    }
                }
            }
            mapPages.put(i+1, paginationLiabilities);
            paginationLiabilities = new ArrayList<>();
            contador += itemsPerPage;
        }
        return mapPages;
    }

}
