package br.com.ifinance.models.entities.mock;

import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.Mean;
import br.com.ifinance.models.enums.StatusLiability;

public class LiabilityMock {

    public static Liability mockRequest(){

        Liability liability = new Liability();

        Long id = 1L;
        liability.getId();

        String description = "Gasolina";
        liability.getDescription();

        Double value = 20.0;
        liability.getValue();

        String date = "2011-11-11";
        liability.getDate();

        String scheduling = "2011-11-11";
        liability.getScheduling();

        StatusLiability statusLiability = StatusLiability.PAGO;
        liability.getStatusLiability();

        Mean mean = Mean.PIX;
        liability.getMean();

        String created = "2011-11-11";
        liability.getCreated();

        User user = null;
        liability.getCreated();

        liability.setId(id);
        liability.setDescription(description);
        liability.setValue(value);
        liability.setDate(date);
        liability.setScheduling(scheduling);
        liability.setStatusLiability(statusLiability);
        liability.setMean(mean);
        liability.setCreated(created);
        liability.setUser(user);

        return liability;
    }

}
