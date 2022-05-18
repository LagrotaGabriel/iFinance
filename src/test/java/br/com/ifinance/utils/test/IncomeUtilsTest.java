package br.com.ifinance.utils.test;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.IncomeType;
import br.com.ifinance.utils.IncomeUtils;
import br.com.ifinance.utils.mock.MockedUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IncomeUtilsTest {

    User user = MockedUser.userMockRequest();
    IncomeUtils incomeUtils = new IncomeUtils();

    @Test
    public void shouldTestSomaRenda(){
        Assertions.assertEquals("4500.0",
                incomeUtils.somaRenda(user, IncomeType.SALARIO).toString());
    }

    @Test
    public void shouldTestRendas(){

        Assertions.assertEquals
                (incomeUtils.Rendas(user, IncomeType.SALARIO).size(), 1);

    }

}
