package br.com.ifinance.utils.test;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.utils.LiabilityUtils;
import br.com.ifinance.utils.mock.MockedUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LiabilityUtilsTest {

    LiabilityUtils liabilityUtils = new LiabilityUtils();
    User user = MockedUser.userMockRequest();

    @Test
    public void shouldMakeValidationOfMethodPageFilterinCurrentMonthAndYear(){
        Assertions.assertEquals(liabilityUtils.pageFilterinCurrentMonthAndYear
                (user, 11, 11).get(0).getDescription(), "Gasolina");
    }

    @Test
    public void shouldMakeValidationOfTotalPages(){
        Assertions.assertEquals(liabilityUtils.totalPages
                (user, 11, 2011, 5).toString(), "0");
    }

    @Test
    public void shouldMakeValidationOfPageNumberList(){
        Assertions.assertEquals(liabilityUtils.pageNumberList(2).toString(), "[1, 2]");
    }

    @Test
    public void shouldMakeValidationOfLiabilityPagination(){
        Assertions.assertEquals(liabilityUtils.liabilityPagination
                (user, 11, 2011, 5).toString(), "{1=[]}");
    }

}
