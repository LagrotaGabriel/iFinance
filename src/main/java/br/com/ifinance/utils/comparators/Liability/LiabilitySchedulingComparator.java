package br.com.ifinance.utils.comparators.Liability;

import br.com.ifinance.models.entities.Liability;

import java.util.Comparator;

public class LiabilitySchedulingComparator implements Comparator<Liability> {
    @Override
    public int compare(Liability liability1, Liability liability2) {

        if(liability1.getScheduling() == null){
            liability1.setScheduling("Não possui");
        }
        if(liability2.getScheduling() == null){
            liability2.setScheduling("Não possui");
        }

        if (liability1.getScheduling().compareTo(liability2.getScheduling()) > 0) {
            return 1;
        }

        return -1;
    }

}
