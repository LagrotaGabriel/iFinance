package br.com.ifinance.models.entities.test;

import br.com.ifinance.models.entities.Income;
import br.com.ifinance.models.entities.mock.IncomeMock;
import br.com.ifinance.models.enums.Frequency;
import br.com.ifinance.models.enums.IncomeType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class IncomeTest {

    @Test
    public void shouldValidateGettersAndSettersMethods(){

        Income income = IncomeMock.mockRequest();
        Assert.assertEquals("Income(id=1, description=Pagamento, value=4500.0, date=11/11/2021, " +
                "frequency=MENSAL, incomeType=SALARIO, user=null)", income.toString());

    }

    @Test
    public void shouldValidateAllArgsConstructor(){
        Income income = new Income(1L, "Pagamento", 4500.0, "11/11/2021",
                Frequency.MENSAL, IncomeType.SALARIO, null);
        Assert.assertEquals("Income(id=1, description=Pagamento, value=4500.0, date=11/11/2021, " +
                "frequency=MENSAL, incomeType=SALARIO, user=null)", income.toString());

    }

    @Test
    public void shouldValidateBuilder(){

        Income income = Income.builder()
                .id(1L)
                .description("Pagamento")
                .value(4500.0)
                .date("11/11/2021")
                .frequency(Frequency.MENSAL)
                .incomeType(IncomeType.SALARIO)
                .user(null)
                .build();

        Assert.assertEquals("Income(id=1, description=Pagamento, value=4500.0, date=11/11/2021, " +
                "frequency=MENSAL, incomeType=SALARIO, user=null)", income.toString());
    }
}
