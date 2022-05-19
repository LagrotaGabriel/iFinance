package br.com.ifinance.utils.test;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.utils.PatrimonyUtils;
import br.com.ifinance.utils.mock.MockedUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PatrimonyUtilsTest {

    PatrimonyUtils patrimonyUtils = new PatrimonyUtils();
    User user = MockedUser.userMockRequest();

    @Test
    public void shouldValidatePatrimonyTypeFilter(){

        Assertions.assertEquals(patrimonyUtils.patrimonyTypeFilter
                (user, "imoveis").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.patrimonyTypeFilter
                (user, "banco").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.patrimonyTypeFilter
                (user, "investimentos").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.patrimonyTypeFilter
                (user, "eletronicos").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.patrimonyTypeFilter
                (user, "intangiveis").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.patrimonyTypeFilter
                (user, "joias").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.patrimonyTypeFilter
                (user, "liquidez").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.patrimonyTypeFilter
                (user, "outros").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.patrimonyTypeFilter
                (user, "all").get(0).getDescription(), "Fox");

        Assertions.assertEquals(patrimonyUtils.patrimonyTypeFilter
                (user, "veiculos").get(0).getDescription(), "Fox");

    }

    @Test
    public void shouldValidatePatrimonySum(){
        Assertions.assertEquals(patrimonyUtils.patrimonySum(user).toString(),
                "{0=15000.0, 1=0.0, 2=0.0, 3=0.0, 4=0.0, 5=0.0, 6=0.0, 7=0.0, 8=0.0}");
    }

    @Test
    public void shouldValidatePatrimonyAllSum(){
        Assertions.assertEquals(patrimonyUtils.patrimonyAllSum(user).toString(), "15000.0");
    }

    @Test
    public void shouldValidatePageFilterInCurrentType(){

        Assertions.assertEquals(patrimonyUtils.pageFilterInCurrentType
                (user, "imoveis").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.pageFilterInCurrentType
                (user, "banco").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.pageFilterInCurrentType
                (user, "investimentos").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.pageFilterInCurrentType
                (user, "eletronicos").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.pageFilterInCurrentType
                (user, "intangiveis").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.pageFilterInCurrentType
                (user, "joias").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.pageFilterInCurrentType
                (user, "liquidez").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.pageFilterInCurrentType
                (user, "outros").toString(), "[]");

        Assertions.assertEquals(patrimonyUtils.pageFilterInCurrentType
                (user, "all").get(0).getDescription(), "Fox");

        Assertions.assertEquals(patrimonyUtils.pageFilterInCurrentType
                (user, "veiculos").get(0).getDescription(), "Fox");

    }

    @Test
    public void shouldMakeValidationOfTotalPages(){
        Assertions.assertEquals(patrimonyUtils.totalPages
                (user, "veiculos", 5).toString(), "1");
    }

    @Test
    public void shouldMakeValidationOfPageNumberList(){
        Assertions.assertEquals(patrimonyUtils.pageNumberList(2).toString(), "[1, 2]");
    }

    @Test
    public void shouldMakeValidationOfPatrimonyPagination(){
        Assertions.assertEquals(patrimonyUtils.patrimonyPagination
                (user, "imoveis", 5).toString(), "{1=[]}");
    }

}
