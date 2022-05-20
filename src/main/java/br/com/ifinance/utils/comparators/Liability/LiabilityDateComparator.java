package br.com.ifinance.utils.comparators.Liability;

import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.utils.Dates;
import br.com.ifinance.utils.Utils;

import java.util.Comparator;

public class LiabilityDateComparator implements Comparator<Liability> {

    Dates dates = new Dates();

    @Override
    public int compare(Liability liability1, Liability liability2) {

        if(liability1.getDate() == null){
            liability1.setDate("Agendado");
        }
        if(liability2.getDate() == null){
            liability2.setDate("Agendado");
        }

        if(liability1.getDate().compareTo(liability2.getDate()) > 0){
            return 1;
        }
        return -1;

    }
}
