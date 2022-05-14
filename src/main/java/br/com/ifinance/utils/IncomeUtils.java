package br.com.ifinance.utils;

import br.com.ifinance.models.entities.Income;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.IncomeType;

import java.util.ArrayList;
import java.util.List;

public class IncomeUtils {

    public Double somaRenda(User user, IncomeType incomeType){
        Double soma = 0.0;
        if (!user.getIncomes().isEmpty()) {
            for (int i = 0; i < user.getIncomes().size(); i++) {
                if(user.getIncomes().get(i).getIncomeType() == incomeType) {
                    soma += user.getIncomes().get(i).getValue();
                }
            }
        }
        return (double) Math.round(Double.parseDouble(String.valueOf(((soma*100)/100))));
    }

    public List<Income> Rendas(User user, IncomeType incomeType){
        List<Income> rendasList = new ArrayList<>();
        for(int i = 0; i < user.getIncomes().size(); i++){
            if(user.getIncomes().get(i).getIncomeType() == incomeType){
                rendasList.add(user.getIncomes().get(i));
            }
        }
        return rendasList;
    }
}
