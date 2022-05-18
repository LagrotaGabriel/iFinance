package br.com.ifinance.models.entities.test;

import br.com.ifinance.models.entities.Inflow;
import br.com.ifinance.models.entities.mock.InflowMock;
import br.com.ifinance.models.enums.Mean;
import br.com.ifinance.models.enums.StatusInflow;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class InflowTest {

    @Test
    public void shouldValidateGettersAndSetters(){

        Inflow inflow = InflowMock.mockRequest();

        Assert.assertEquals("Inflow(id=1, description=Venda e-commerce, value=60.0, date=2011-11-11, " +
                "scheduling=2011-11-11, created=2011-11-11, statusInflow=RECEBIDO, mean=PIX, user=null)", inflow.toString());

    }

    @Test
    public void shouldValidateAllArgsConstructor(){

        Inflow inflow = new Inflow(1L, "Venda e-commerce", 60.0, "2011-11-11",
                "2011-11-11", "2011-11-11", StatusInflow.RECEBIDO, Mean.PIX, null);

        Assert.assertEquals("Inflow(id=1, description=Venda e-commerce, value=60.0, date=2011-11-11, " +
                "scheduling=2011-11-11, created=2011-11-11, statusInflow=RECEBIDO, mean=PIX, user=null)", inflow.toString());
    }

    @Test
    public void ShouldValidateBuilders(){

        Inflow inflow = Inflow.builder()
                .id(1L)
                .description("Venda e-commerce")
                .value(60.0)
                .date("2011-11-11")
                .scheduling("2011-11-11")
                .created("2011-11-11")
                .statusInflow(StatusInflow.RECEBIDO)
                .mean(Mean.PIX)
                .user(null)
                .build();

        Assert.assertEquals("Inflow(id=1, description=Venda e-commerce, value=60.0, date=2011-11-11, " +
                "scheduling=2011-11-11, created=2011-11-11, statusInflow=RECEBIDO, mean=PIX, user=null)",
                inflow.toString());

    }

}
