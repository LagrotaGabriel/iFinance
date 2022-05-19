package br.com.ifinance.services.test;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.services.BalanceService;
import br.com.ifinance.services.mock.BalanceServiceMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BalanceServiceTest {

    @Test
    public void shouldValidateBiggerInflowLiability(){

        BalanceService balanceService = new BalanceService();
        User user = BalanceServiceMock.userMockRequest();

        // Testa maior despesa
        Assertions.assertEquals("20.0",
                (balanceService.biggerInflowOrLiability(user, 2011, 11, "liability")).toString());

        // Testa maior entrada
        Assertions.assertEquals("60.0",
                (balanceService.biggerInflowOrLiability(user, 2011, 11, "inflow")).toString());

        // Testa exception
        Assertions.assertEquals("0.0",
                (balanceService.biggerInflowOrLiability(user, 2011, 11, "")).toString());

    }

    @Test
    public void shouldValidateSmallerInflowOrLiability(){

        BalanceService balanceService = new BalanceService();
        User user = BalanceServiceMock.userMockRequest();

        // Testa menor despesa
        Assertions.assertEquals("20.0",
                (balanceService.smallerInflowOrLiability(user, 2011, 11, "liability")).toString());

        // Testa menor entrada
        Assertions.assertEquals("60.0",
                (balanceService.smallerInflowOrLiability(user, 2011, 11, "inflow")).toString());

        // Testa exception
        Assertions.assertEquals("0.0",
                (balanceService.smallerInflowOrLiability(user, 2011, 11, "")).toString());


    }

    @Test
    public void shouldTestMostUsedMean(){

        BalanceService balanceService = new BalanceService();
        User user = BalanceServiceMock.userMockRequest();

        // Testa meio mais usado das entradas
        Assertions.assertEquals("Transferência via PIX",
                (balanceService.mostUsedMean(user, 2011, 11, "inflow")));

        // Testa meio mais usado das saídas
        Assertions.assertEquals("Transferência via PIX",
                (balanceService.mostUsedMean(user, 2011, 11, "liability")));

        // Testa erro do meio mais usado
        Assertions.assertEquals("-",
                (balanceService.mostUsedMean(user, 2011, 11, "")));

    }

    @Test
    public void shouldValidateTotalInflowOrLiability(){

        BalanceService balanceService = new BalanceService();
        User user = BalanceServiceMock.userMockRequest();

        // Testa menor despesa
        Assertions.assertEquals("20.0",
                (balanceService.totalOfInflowOfLiability(user, 2011, 11, "liability")).toString());

        // Testa menor entrada
        Assertions.assertEquals("60.0",
                (balanceService.totalOfInflowOfLiability(user, 2011, 11, "inflow")).toString());

        // Testa exception
        Assertions.assertEquals("0.0",
                (balanceService.totalOfInflowOfLiability(user, 2011, 11, "")).toString());


    }

    @Test
    public void shouldValidateTotalBalance(){
        BalanceService balanceService = new BalanceService();
        User user = BalanceServiceMock.userMockRequest();
        Assertions.assertEquals("40.0", balanceService.totalBalance(user, 2011, 11).toString());
    }
}
