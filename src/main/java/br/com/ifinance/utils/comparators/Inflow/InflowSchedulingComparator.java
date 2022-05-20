package br.com.ifinance.utils.comparators.Inflow;

import br.com.ifinance.models.entities.Inflow;

import java.util.Comparator;

public class InflowSchedulingComparator implements Comparator<Inflow> {

    @Override
    public int compare(Inflow inflow1, Inflow inflow2) {

        if(inflow1.getScheduling() == null){
            inflow1.setScheduling("Não possui");
        }
        if(inflow2.getScheduling() == null){
            inflow2.setScheduling("Não possui");
        }
        if (inflow1.getScheduling().compareTo(inflow2.getScheduling()) > 0) {
            return 1;
        }
        return -1;
    }
}
