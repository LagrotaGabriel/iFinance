package br.com.ifinance.services;

import br.com.ifinance.models.entities.Inflow;
import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.StatusInflow;
import br.com.ifinance.utils.Dates;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexService {

    Dates dates = new Dates();

    public Integer pagarHoje(User user){
        List<Liability> pagarHoje = new ArrayList<>();
        for(Liability liability: user.getLiabilities()){
            if(liability.getScheduling() != null) {
                if (liability.getScheduling().equals(dates.today().replaceAll("/", "-"))) {
                    pagarHoje.add(liability);
                }
            }
        }
        return pagarHoje.size();
    }

    public Integer emAtraso(User user){

        List<Liability> atrasados = new ArrayList<>();

        for(Liability liability: user.getLiabilities()){
            if(liability.getScheduling() != null) {
                if (liability.getScheduling().split("-")[1].equals(dates.splitedToday()[1])
                        && liability.getScheduling().split("-")[0].equals(dates.splitedToday()[0])
                        && Integer.parseInt(liability.getScheduling().split("-")[1]) > Integer.parseInt(dates.splitedToday()[1])) {

                    atrasados.add(liability);
                }
            }
        }

        return atrasados.size();
    }

    public Double aReceber(User user){
        Double cont = 0.0;
        for(Inflow inflow: user.getInflows()){
            if(inflow.getStatusInflow().equals(StatusInflow.RECEBER)
                    && inflow.getScheduling().split("-")[0].equals(dates.splitedToday()[0])
                    && inflow.getScheduling().split("-")[1].equals(dates.splitedToday()[1])){
                cont += inflow.getValue();
            }
        }
        return cont;
    }
}
