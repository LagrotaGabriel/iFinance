package br.com.ifinance.models.entities.test;

import br.com.ifinance.models.entities.Inflow;
import br.com.ifinance.models.entities.mock.InflowMock;
import br.com.ifinance.models.enums.Mean;
import br.com.ifinance.models.enums.StatusInflow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InflowTest {

    @Test
    @DisplayName("Testa os métodos getters e setters da classe")
    public void shouldValidateGettersAndSetters(){

        Inflow inflow = InflowMock.mockRequest();

        Assertions.assertEquals("Inflow(id=1, description=Venda e-commerce, value=60.0, date=2011-11-11, " +
                "scheduling=2011-11-11, created=2011-11-11, statusInflow=RECEBIDO, mean=PIX, user=null)", inflow.toString());

    }

    @Test
    @DisplayName("Teste o método construtor com todos os argumentos da classe")
    public void shouldValidateAllArgsConstructor(){

        Inflow inflow = new Inflow(1L, "Venda e-commerce", 60.0, "2011-11-11",
                "2011-11-11", "2011-11-11", StatusInflow.RECEBIDO, Mean.PIX, null);

        Assertions.assertEquals("Inflow(id=1, description=Venda e-commerce, value=60.0, date=2011-11-11, " +
                "scheduling=2011-11-11, created=2011-11-11, statusInflow=RECEBIDO, mean=PIX, user=null)", inflow.toString());
    }

    @Test
    @DisplayName("Testa o builder da classe")
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

        Assertions.assertEquals("Inflow(id=1, description=Venda e-commerce, value=60.0, date=2011-11-11, " +
                "scheduling=2011-11-11, created=2011-11-11, statusInflow=RECEBIDO, mean=PIX, user=null)", inflow.toString());

    }

}
