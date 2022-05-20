package br.com.ifinance.utils.comparators.Inflow;

import br.com.ifinance.models.entities.Inflow;

import java.util.Comparator;

public class InflowDateComparator implements Comparator<Inflow> {


    @Override
    public int compare(Inflow inflow1, Inflow inflow2) {

        if(inflow1.getDate() == null){
            inflow1.setDate("Agendado");
        }
        if(inflow2.getDate() == null){
            inflow2.setDate("Agendado");
        }

        if(inflow1.getDate().compareTo(inflow2.getDate()) > 0){
            return 1;
        }
        return -1;

    }

}
