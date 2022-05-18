package br.com.ifinance.services.test;

import br.com.ifinance.models.entities.Inflow;
import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.entities.mock.InflowMock;
import br.com.ifinance.models.entities.mock.LiabilityMock;
import br.com.ifinance.models.entities.mock.UserMock;
import br.com.ifinance.services.BalanceService;
import br.com.ifinance.services.mock.BalanceServiceMock;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BalanceServiceTest {

    @Test
    public void shouldValidateBiggerInflowLiability(){

        BalanceService balanceService = new BalanceService();
        User user = BalanceServiceMock.userMockRequest();

        // Testa maior despesa
        Assert.assertEquals("20.0",
                (balanceService.biggerInflowOrLiability(user, 2011, 11, "liability")).toString());

        // Testa maior entrada
        Assert.assertEquals("60.0",
                (balanceService.biggerInflowOrLiability(user, 2011, 11, "inflow")).toString());

        // Testa exception
        Assert.assertEquals("0.0",
                (balanceService.biggerInflowOrLiability(user, 2011, 11, "")).toString());

    }

    @Test
    public void shouldValidateSmallerInflowOrLiability(){

        BalanceService balanceService = new BalanceService();
        User user = BalanceServiceMock.userMockRequest();

        // Testa menor despesa
        Assert.assertEquals("20.0",
                (balanceService.smallerInflowOrLiability(user, 2011, 11, "liability")).toString());

        // Testa menor entrada
        Assert.assertEquals("60.0",
                (balanceService.smallerInflowOrLiability(user, 2011, 11, "inflow")).toString());

        // Testa exception
        Assert.assertEquals("0.0",
                (balanceService.smallerInflowOrLiability(user, 2011, 11, "")).toString());


    }

    @Test
    public void shouldTestMostUsedMean(){

        BalanceService balanceService = new BalanceService();
        User user = BalanceServiceMock.userMockRequest();

        // Testa meio mais usado das entradas
        Assert.assertEquals("Transferência via PIX",
                (balanceService.mostUsedMean(user, 2011, 11, "inflow")).toString());

        // Testa meio mais usado das saídas
        Assert.assertEquals("Transferência via PIX",
                (balanceService.mostUsedMean(user, 2011, 11, "liability")).toString());

        // Testa erro do meio mais usado
        Assert.assertEquals("-",
                (balanceService.mostUsedMean(user, 2011, 11, "")).toString());

    }

    @Test
    public void shouldValidateTotalInflowOrLiability(){

        BalanceService balanceService = new BalanceService();
        User user = BalanceServiceMock.userMockRequest();

        // Testa menor despesa
        Assert.assertEquals("20.0",
                (balanceService.totalOfInflowOfLiability(user, 2011, 11, "liability")).toString());

        // Testa menor entrada
        Assert.assertEquals("60.0",
                (balanceService.totalOfInflowOfLiability(user, 2011, 11, "inflow")).toString());

        // Testa exception
        Assert.assertEquals("0.0",
                (balanceService.totalOfInflowOfLiability(user, 2011, 11, "")).toString());


    }

    @Test
    public void shouldValidateTotalBalance(){
        BalanceService balanceService = new BalanceService();
        User user = BalanceServiceMock.userMockRequest();

        Assert.assertEquals("40.0",
                balanceService.totalBalance(user, 2011, 11).toString());
    }
}
