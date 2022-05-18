package br.com.ifinance.utils.test;

import br.com.ifinance.models.entities.Inflow;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.utils.InflowUtils;
import br.com.ifinance.utils.mock.MockedUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InflowUtilsTest {

    User user = MockedUser.userMockRequest();
    InflowUtils inflowUtils = new InflowUtils();

    @Test
    public void shouldTestPageFilterinCurrentMonthAndYear(){
        List<Inflow> inflowReturn = inflowUtils.pageFilterinCurrentMonthAndYear(user, 11, 11);
        Assertions.assertEquals(inflowReturn.get(0).getDescription(), "Venda e-commerce");
    }

    @Test
    public void shouldTestTotalPages(){
        Assertions.assertEquals(inflowUtils.totalPages(user, 11, 2011, 5), 0);
    }

    @Test
    public void shouldTestPageNumberList(){
        Assertions.assertEquals(inflowUtils.pageNumberList(5).toString(),
                "[1, 2, 3, 4, 5]");

    }

    @Test
    public void shouldTestInflowPagination(){
        Assertions.assertEquals(inflowUtils.inflowPagination(user, 11, 2021, 5)
                .toString(), "{1=[]}");
    }

}
