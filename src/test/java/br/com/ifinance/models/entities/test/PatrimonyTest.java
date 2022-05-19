package br.com.ifinance.models.entities.test;

import br.com.ifinance.models.entities.Patrimony;
import br.com.ifinance.models.entities.mock.PatrimonyMock;
import br.com.ifinance.models.enums.PatrimonyType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatrimonyTest {

    @Test
    public void shouldValidateGettersAndSettersMethods(){

        Patrimony patrimony = PatrimonyMock.mockRequest();

        Assertions.assertEquals("Patrimony(id=1, description=Fox, value=15000.0, date=2011-11-11, " +
                "patrimonyType=VEICULO, user=null)", patrimony.toString());

    }

    @Test
    public void shouldValidateAllArgsConstructor(){

        Patrimony patrimony = new Patrimony(1L, "Fox", 15000.0, "2011-11-11",
                PatrimonyType.VEICULO, null);

        Assertions.assertEquals("Patrimony(id=1, description=Fox, value=15000.0, date=2011-11-11, " +
                "patrimonyType=VEICULO, user=null)", patrimony.toString());

    }

    @Test
    public void shouldValidateBuilder(){

        Patrimony patrimony = Patrimony.builder()
                .id(1L)
                .description("Fox")
                .value(15000.0)
                .date("2011-11-11")
                .patrimonyType(PatrimonyType.VEICULO)
                .user(null)
                .build();

        Assertions.assertEquals("Patrimony(id=1, description=Fox, value=15000.0, date=2011-11-11, " +
                "patrimonyType=VEICULO, user=null)", patrimony.toString());

    }

}
