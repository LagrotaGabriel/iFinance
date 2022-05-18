package br.com.ifinance.models.entities.test;

import br.com.ifinance.models.entities.Patrimony;
import br.com.ifinance.models.entities.mock.PatrimonyMock;
import br.com.ifinance.models.enums.PatrimonyType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PatrimonyTest {

    @Test
    public void shouldValidateGettersAndSettersMethods(){

        Patrimony patrimony = PatrimonyMock.mockRequest();

        Assert.assertEquals("Patrimony(id=1, description=Fox, value=15000.0, date=2011-11-11, " +
                "patrimonyType=VEICULO, user=null)", patrimony.toString());

    }

    @Test
    public void shouldValidateAllArgsConstructor(){

        Patrimony patrimony = new Patrimony(1L, "Fox", 15000.0, "2011-11-11",
                PatrimonyType.VEICULO, null);

        Assert.assertEquals("Patrimony(id=1, description=Fox, value=15000.0, date=2011-11-11, " +
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

        Assert.assertEquals("Patrimony(id=1, description=Fox, value=15000.0, date=2011-11-11, " +
                "patrimonyType=VEICULO, user=null)", patrimony.toString());

    }

}
