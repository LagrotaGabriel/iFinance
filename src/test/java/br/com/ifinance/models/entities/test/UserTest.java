package br.com.ifinance.models.entities.test;

import br.com.ifinance.models.entities.*;
import br.com.ifinance.models.entities.mock.UserMock;
import br.com.ifinance.models.enums.Gender;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class UserTest {

    @Test
    public void shouldMakeValidationOfGettersAndSetters(){

        User user = UserMock.mockRequest();
        Assert.assertEquals("User(id=1, username=Fulano123, password=abc123, name=Fulano da Silva, " +
                "email=fulano@email.com.br, birthDate=2011-11-11, gender=M, incomes=null, inflows=null, assets=null, " +
                "liabilities=null, roles=null)", user.toString());
    }

    @Test
    public void shouldMakeValidationOfAllArgsConstructor(){
        User user = new User(1L, "Fulano123", "abc123",
                "Fulano da Silva", "fulano@email.com.br", "2011-11-11",
                Gender.M, null, null, null, null, null);
        Assert.assertEquals("User(id=1, username=Fulano123, password=abc123, name=Fulano da Silva, " +
                "email=fulano@email.com.br, birthDate=2011-11-11, gender=M, incomes=null, inflows=null, assets=null, " +
                "liabilities=null, roles=null)", user.toString());
    }

    @Test
    public void shouldMakeValidationOfClassBuilder(){

        User user = User.builder()
                .id(1L)
                .username("Fulano123")
                .password("abc123")
                .name("Fulano da Silva")
                .email("fulano@email.com.br")
                .birthDate("2011-11-11")
                .gender(Gender.M)
                .incomes(null)
                .inflows(null)
                .liabilities(null)
                .roles(null)
                .build();

        Assert.assertEquals("User(id=1, username=Fulano123, password=abc123, name=Fulano da Silva, " +
                "email=fulano@email.com.br, birthDate=2011-11-11, gender=M, incomes=null, inflows=null, assets=null, " +
                "liabilities=null, roles=null)", user.toString());
    }


}
