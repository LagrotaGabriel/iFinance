package br.com.ifinance.utils;

import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LiabilityUtils {

    public List<Liability> pageFilterinCurrentMonthAndYear(User user, Integer currentMonth, Integer currentYear){
        // FILTRO DOS LIABILITIES POR DATA
        List<Liability> liabilitiesOfSelectedDate = new ArrayList<>();

        if(user.getLiabilities().size() > 0){

            for(int i = 0; i < user.getLiabilities().size(); i++){

                if(user.getLiabilities().get(i).getCreated() != null && !user.getLiabilities().get(i).getCreated().equals("")) {

                    String atual = user.getLiabilities().get(i).getCreated();
                    String[] atualSplitado = atual.split("/");

                    if (Integer.parseInt(atualSplitado[2]) == (currentYear)) {

                        if(Integer.parseInt(atualSplitado[1]) == (currentMonth)) {

                            liabilitiesOfSelectedDate.add(user.getLiabilities().get(i));
                        }
                    }
                }
            }
        }

        return liabilitiesOfSelectedDate;
    }

    public Integer totalPages(User user, Integer currentMonth, Integer currentYear, Integer itemsPerPage){
        // CLASSIFICANDO O NÚMERO DE PÁGINAS QUE A TABELA TERÁ
        return (int) Math.ceil(Double.parseDouble(String.valueOf(
                        (pageFilterinCurrentMonthAndYear(user, currentMonth, currentYear).size())))/itemsPerPage);
    }

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

    public Map<Integer, List<Liability>> liabilityPagination(User user, Integer currentMonth, Integer currentYear, Integer itemsPerPage){

        // DEFININDO A QUANTIDADE DE ITENS POR PÁGINA DA TABELA
        Map<Integer, List<Liability>> mapPages = new HashMap();
        List<Liability> paginationLiabilities = new ArrayList<>();

        int contador = 5;
        for(int i = 0; i < pageNumberList(totalPages(user, currentMonth, currentYear, itemsPerPage)).size(); i++){

            for(int x=(contador-5); x < contador; x++){
                if(pageFilterinCurrentMonthAndYear(user, currentMonth, currentYear) != null) {
                    if (x < pageFilterinCurrentMonthAndYear(user, currentMonth, currentYear).size()) {
                        paginationLiabilities.add(pageFilterinCurrentMonthAndYear(user, currentMonth, currentYear).get(x));
                    }
                }
            }
            mapPages.put(i+1, paginationLiabilities);
            paginationLiabilities = new ArrayList<>();
            contador += 5;
        }
        return mapPages;
    }

}
