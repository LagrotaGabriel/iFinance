package br.com.ifinance.utils;

import br.com.ifinance.models.entities.Inflow;
import br.com.ifinance.models.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InflowUtils {

    /*** Tem como objetivo filtrar as entradas do usuário com base no mês e ano passados como parâmetros na url
     * @param user User - Usuário logado na sessão
     * @param currentMonth Integer - Mês que o usuário deseja realizar o filtro
     * @param currentYear Year - Ano que o usuário deseja realizar o filtro
     * @return List - Retorna uma lista com as entradas encontradas no mês e ano filtrados pelo usuário */
    public List<Inflow> pageFilterinCurrentMonthAndYear(User user, Integer currentMonth, Integer currentYear){
        // FILTRO DOS INFLOWS POR DATA
        List<Inflow> inflowsOfSelectedDate = new ArrayList<>();

        if(user.getInflows().size() > 0){

            for(int i = 0; i < user.getInflows().size(); i++){

                if(user.getInflows().get(i).getCreated() != null && !user.getInflows().get(i).getCreated().equals("")) {

                    String atual = user.getInflows().get(i).getCreated();
                    String[] atualSplitado = atual.split("/");

                    if (Integer.parseInt(atualSplitado[2]) == (currentYear)) {

                        if(Integer.parseInt(atualSplitado[1]) == (currentMonth)) {

                            inflowsOfSelectedDate.add(user.getInflows().get(i));
                        }
                    }
                }
            }
        }

        return inflowsOfSelectedDate;
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
    public Map<Integer, List<Inflow>> inflowPagination(User user, Integer currentMonth, Integer currentYear, Integer itemsPerPage){

        // DEFININDO A QUANTIDADE DE ITENS POR PÁGINA DA TABELA
        Map<Integer, List<Inflow>> mapPages = new HashMap();
        List<Inflow> paginationInflows = new ArrayList<>();

        int contador = itemsPerPage;
        for(int i = 0; i < pageNumberList(totalPages(user, currentMonth, currentYear, itemsPerPage)).size(); i++){

            for(int x=(contador-itemsPerPage); x < contador; x++){
                if(pageFilterinCurrentMonthAndYear(user, currentMonth, currentYear) != null) {
                    if (x < pageFilterinCurrentMonthAndYear(user, currentMonth, currentYear).size()) {
                        paginationInflows.add(pageFilterinCurrentMonthAndYear(user, currentMonth, currentYear).get(x));
                    }
                }
            }
            mapPages.put(i+1, paginationInflows);
            paginationInflows = new ArrayList<>();
            contador += itemsPerPage;
        }
        return mapPages;
    }

}
