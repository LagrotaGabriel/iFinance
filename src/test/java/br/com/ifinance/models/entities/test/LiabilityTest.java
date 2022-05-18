package br.com.ifinance.models.entities.test;

import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.entities.mock.LiabilityMock;
import br.com.ifinance.models.enums.Mean;
import br.com.ifinance.models.enums.StatusLiability;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class LiabilityTest {

    @Test
    public void shouldValidateGettersAndSettersMethods(){

        Liability liability = LiabilityMock.mockRequest();

        Assert.assertEquals("Liability(id=1, description=Gasolina, value=20.0, date=2011-11-11, " +
                "scheduling=2011-11-11, statusLiability=PAGO, mean=PIX, created=2011-11-11, user=null)",
                liability.toString()
        );

    }

    @Test
    public void shouldValiteAllArgsConstructor(){

        Liability liability = new Liability(1L, "Gasolina", 20.0, "2011-11-11",
                "2011-11-11", StatusLiability.PAGO, Mean.PIX, "2011-11-11", null);

        Assert.assertEquals("Liability(id=1, description=Gasolina, value=20.0, date=2011-11-11, " +
                        "scheduling=2011-11-11, statusLiability=PAGO, mean=PIX, created=2011-11-11, user=null)",
                liability.toString());

    }

    @Test
    public void shouldValidateBuilderMethod(){

        Liability liability = Liability.builder()
                .id(1L)
                .description("Gasolina")
                .value(20.0)
                .date("2011-11-11")
                .scheduling("2011-11-11")
                .statusLiability(StatusLiability.PAGO)
                .mean(Mean.PIX)
                .created("2011-11-11")
                .user(null)
                .build();

        Assert.assertEquals("Liability(id=1, description=Gasolina, value=20.0, date=2011-11-11, " +
                        "scheduling=2011-11-11, statusLiability=PAGO, mean=PIX, created=2011-11-11, user=null)",
                liability.toString());
    }

}
