package br.com.ifinance.models.entities.test;

import br.com.ifinance.models.entities.Income;
import br.com.ifinance.models.entities.mock.IncomeMock;
import br.com.ifinance.models.enums.Frequency;
import br.com.ifinance.models.enums.IncomeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IncomeTest {

    @Test
    @DisplayName("Testa os métodos getters e setters da classe")
    public void shouldValidateGettersAndSettersMethods(){

        Income income = IncomeMock.mockRequest();
        Assertions.assertEquals("Income(id=1, description=Pagamento, value=4500.0, date=2011-11-11, " +
                "frequency=MENSAL, incomeType=SALARIO, user=null)", income.toString());

    }

    @Test
    @DisplayName("Teste o método construtor com todos os argumentos da classe")
    public void shouldValidateAllArgsConstructor(){
        Income income = new Income(1L, "Pagamento", 4500.0, "11/11/2021",
                Frequency.MENSAL, IncomeType.SALARIO, null);
        Assertions.assertEquals("Income(id=1, description=Pagamento, value=4500.0, date=11/11/2021, " +
                "frequency=MENSAL, incomeType=SALARIO, user=null)", income.toString());

    }

    @Test
    @DisplayName("Testa o builder da classe")
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

        Assertions.assertEquals("Income(id=1, description=Pagamento, value=4500.0, date=11/11/2021, " +
                "frequency=MENSAL, incomeType=SALARIO, user=null)", income.toString());
    }
}
