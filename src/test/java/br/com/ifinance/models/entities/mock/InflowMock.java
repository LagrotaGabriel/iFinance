package br.com.ifinance.models.entities.mock;

import br.com.ifinance.models.entities.Inflow;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.Mean;
import br.com.ifinance.models.enums.StatusInflow;

public class InflowMock {

    public static Inflow mockRequest() {

        Inflow inflow = new Inflow();

        Long id = 1L;
        inflow.getId();

        String description = "Venda e-commerce";
        inflow.getDescription();

        Double value = 60.0;
        inflow.getValue();

        String date = "2011-11-11";
        inflow.getDate();

        String scheduling = "2011-11-11";
        inflow.getScheduling();

        String created = "2011-11-11";
        inflow.getCreated();

        StatusInflow statusInflow = StatusInflow.RECEBIDO;
        inflow.getStatusInflow();

        Mean mean = Mean.PIX;
        inflow.getMean();

        User user = null;
        inflow.getUser();

        inflow.setId(id);
        inflow.setDescription(description);
        inflow.setValue(value);
        inflow.setDate(date);
        inflow.setScheduling(scheduling);
        inflow.setCreated(created);
        inflow.setStatusInflow(statusInflow);
        inflow.setMean(mean);
        inflow.setUser(user);

        return inflow;
    }
}
