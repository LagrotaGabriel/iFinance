package br.com.ifinance.models.entities.test;

import br.com.ifinance.models.entities.*;
import br.com.ifinance.models.entities.mock.UserMock;
import br.com.ifinance.models.enums.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Test
    public void shouldMakeValidationOfGettersAndSetters(){

        User user = UserMock.mockRequest();
        Assertions.assertEquals("User(id=1, username=Fulano123, password=abc123, name=Fulano da Silva, " +
                "email=fulano@email.com.br, birthDate=2011-11-11, gender=M, incomes=null, inflows=null, assets=null, " +
                "liabilities=null, roles=null)", user.toString());
    }

    @Test
    public void shouldMakeValidationOfAllArgsConstructor(){
        User user = new User(1L, "Fulano123", "abc123",
                "Fulano da Silva", "fulano@email.com.br", "2011-11-11",
                Gender.M, null, null, null, null, null);
        Assertions.assertEquals("User(id=1, username=Fulano123, password=abc123, name=Fulano da Silva, " +
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

        Assertions.assertEquals("User(id=1, username=Fulano123, password=abc123, name=Fulano da Silva, " +
                "email=fulano@email.com.br, birthDate=2011-11-11, gender=M, incomes=null, inflows=null, assets=null, " +
                "liabilities=null, roles=null)", user.toString());
    }


}
