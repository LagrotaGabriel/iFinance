package br.com.ifinance.models.entities.mock;

import br.com.ifinance.models.entities.Income;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.Frequency;
import br.com.ifinance.models.enums.IncomeType;

public class IncomeMock {

    public static Income mockRequest(){

        Income income = new Income();

        Long id = 1L;
        income.getId();

        String description = "Pagamento";
        income.getDescription();

        Double value = 4500.0;
        income.getValue();

        String date = "11/11/2021";
        income.getDate();

        Frequency frequency = Frequency.MENSAL;
        income.getFrequency();

        IncomeType incomeType = IncomeType.SALARIO;
        income.getIncomeType();

        User user = null;
        income.getUser();

        income.setId(id);
        income.setDescription(description);
        income.setValue(value);
        income.setDate(date);
        income.setFrequency(frequency);
        income.setIncomeType(incomeType);
        income.setUser(user);

        return income;
    }

}
