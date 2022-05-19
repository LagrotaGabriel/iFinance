package br.com.ifinance.services;

import br.com.ifinance.models.entities.Inflow;
import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.Mean;
import br.com.ifinance.models.enums.StatusInflow;
import br.com.ifinance.models.enums.StatusLiability;
import br.com.ifinance.utils.Dates;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class BalanceService {

    @Autowired
    InflowService inflowService;

    @Autowired
    LiabilityService liabilityService;

    Dates dates = new Dates();

    public Double biggerInflowOrLiability(User user, Integer year, Integer month, String type){

        Double biggerValue = 0.0;
        String userMonth = "";
        String userYear = "";

        if(type.equals("inflow")){
            if(!user.getInflows().isEmpty()) {
                for (Inflow inflowUser: user.getInflows()) {
                    if(inflowUser.getStatusInflow() == StatusInflow.RECEBIDO) {
                        userMonth = inflowUser.getDate().split("-")[1];
                        userYear = inflowUser.getDate().split("-")[0];
                    }
                    if(!userMonth.equals("10")){
                        userMonth = userMonth.replace("0", "");
                    }
                    if(inflowUser.getValue() > biggerValue
                            && inflowUser.getStatusInflow() == StatusInflow.RECEBIDO
                            && userYear.equals(year.toString())
                            && userMonth.equals(month.toString())){
                        biggerValue = inflowUser.getValue();

                    }
                }
            }
        }
        else if(type.equals("liability")){
            if(!user.getLiabilities().isEmpty()) {
                for (Liability liabilityUser: user.getLiabilities()) {
                    if(liabilityUser.getStatusLiability() == StatusLiability.PAGO) {
                        userMonth = liabilityUser.getDate().split("-")[1];
                        userYear = liabilityUser.getDate().split("-")[0];
                    }
                    if(!userMonth.equals("10")){
                        userMonth = userMonth.replace("0", "");
                    }
                    if(liabilityUser.getValue() > biggerValue
                            && liabilityUser.getStatusLiability() == StatusLiability.PAGO
                            && userYear.equals(year.toString())
                            && userMonth.equals(month.toString())){
                        biggerValue = liabilityUser.getValue();
                    }
                }
            }
        }
        else{
            return 0.0;
        }

        return biggerValue;
    }

    public Double smallerInflowOrLiability(User user, Integer year, Integer month, String type){

        Double smallerValue = 10000000.0;
        String userMonth = "";
        String userYear = "";

        if(type.equals("inflow")){
            if(!user.getInflows().isEmpty()) {
                for(Inflow inflowUser: user.getInflows()){
                    if(inflowUser.getStatusInflow() == StatusInflow.RECEBIDO) {
                        userMonth = inflowUser.getDate().split("-")[1];
                        userYear = inflowUser.getDate().split("-")[0];
                    }
                    if(!userMonth.equals("10")){
                        userMonth = userMonth.replace("0", "");
                    }
                    if(inflowUser.getValue() < smallerValue
                            && inflowUser.getStatusInflow() == StatusInflow.RECEBIDO
                            && userYear.equals(year.toString())
                            && userMonth.equals(month.toString())){
                        smallerValue = inflowUser.getValue();
                    }
                }
            }
            else{
                smallerValue = 0.0;
            }
        }
        else if(type.equals("liability")){
            if(!user.getLiabilities().isEmpty()) {
                for(Liability liabilityUser: user.getLiabilities()){
                    if(liabilityUser.getStatusLiability() == StatusLiability.PAGO) {
                        userMonth = liabilityUser.getDate().split("-")[1];
                        userYear = liabilityUser.getDate().split("-")[0];
                    }
                    if(!userMonth.equals("10")){
                        userMonth = userMonth.replace("0", "");
                    }
                    if( liabilityUser.getValue() < smallerValue
                            &&  liabilityUser.getStatusLiability() == StatusLiability.PAGO
                            && userYear.equals(year.toString())
                            && userMonth.equals(month.toString())){
                        smallerValue =  liabilityUser.getValue();
                    }
                }
            }
            else{
                smallerValue = 0.0;
            }
        }
        else{
            return 0.0;
        }

        if(smallerValue == 10000000.0){
            smallerValue = 0.0;
        }
        return smallerValue;
    }

    public String mostUsedMean(User user, Integer year, Integer month, String type){

        Map<Mean, Integer> mapContagem = new HashMap<>();
        Integer maior = 0;
        String maiorDesc = "-";
        String userMonth = "";
        String userYear = "";

        if(type.equals("inflow")){

            if(!user.getInflows().isEmpty()){

                for(Inflow userInflow: user.getInflows()){
                    if(userInflow.getStatusInflow() == StatusInflow.RECEBIDO) {
                        userMonth = userInflow.getDate().split("-")[1];
                        userYear = userInflow.getDate().split("-")[0];
                    }
                    if(!userMonth.equals("10")){
                        userMonth = userMonth.replace("0", "");
                    }
                    if(userInflow.getStatusInflow() == StatusInflow.RECEBIDO
                            && userYear.equals(year.toString())
                            && userMonth.equals(month.toString())){

                        if(mapContagem.containsKey(userInflow.getMean())){
                            mapContagem.put(userInflow.getMean(), mapContagem.get(userInflow.getMean()) + 1);
                        }
                        else{
                            mapContagem.put(userInflow.getMean(), 1);
                        }
                    }
                }
            }
        }
        else if(type.equals("liability")){

            if(!user.getLiabilities().isEmpty()){

                for(Liability userLiability: user.getLiabilities()){
                    if(userLiability.getStatusLiability() == StatusLiability.PAGO) {
                        userMonth = userLiability.getDate().split("-")[1];
                        userYear = userLiability.getDate().split("-")[0];
                    }
                    if(!userMonth.equals("10")){
                        userMonth = userMonth.replace("0", "");
                    }
                    if(userLiability.getStatusLiability() == StatusLiability.PAGO
                            && userYear.equals(year.toString())
                            && userMonth.equals(month.toString())){

                        if(mapContagem.containsKey(userLiability.getMean())){
                            mapContagem.put(userLiability.getMean(), mapContagem.get(userLiability.getMean()) + 1);
                        }
                        else{
                            mapContagem.put(userLiability.getMean(), 1);
                        }
                    }
                }
            }
        }

        else{
            return "-";
        }

        for(Map.Entry<Mean, Integer> mapAtual: mapContagem.entrySet()){

            if(mapAtual.getValue() > maior){
                maior = mapAtual.getValue();
                maiorDesc = mapAtual.getKey().getDesc();
            }

        }

        return maiorDesc;
    }

    public Double totalOfInflowOfLiability(User user, Integer year, Integer month, String type){

        double total = 0.0;
        String userMonth = "";
        String userYear = "";

        if(type.equals("inflow")){
            if(!user.getInflows().isEmpty()){
                for(Inflow userInflow: user.getInflows()){
                    if(userInflow.getStatusInflow() == StatusInflow.RECEBIDO) {
                        userMonth = userInflow.getDate().split("-")[1];
                        userYear = userInflow.getDate().split("-")[0];
                    }
                    if(!userMonth.equals("10")){
                        userMonth = userMonth.replace("0", "");
                    }
                    if(userInflow.getStatusInflow() == StatusInflow.RECEBIDO
                            && userYear.equals(year.toString())
                            && userMonth.equals(month.toString())) {
                        total += userInflow.getValue();
                    }
                }
            }
        }
        else if(type.equals("liability")){
            if(!user.getLiabilities().isEmpty()){
                for(Liability userLiability: user.getLiabilities()){
                    if(userLiability.getStatusLiability() == StatusLiability.PAGO) {
                        userMonth = userLiability.getDate().split("-")[1];
                        userYear = userLiability.getDate().split("-")[0];
                    }
                    if(!userMonth.equals("10")){
                        userMonth = userMonth.replace("0", "");
                    }
                    if(userLiability.getStatusLiability() == StatusLiability.PAGO
                            && userYear.equals(year.toString())
                            && userMonth.equals(month.toString())) {
                        total += userLiability.getValue();
                    }
                }
            }
        }
        else{
            return 0.0;
        }

        return total;
    }

    public Double totalBalance(User user, Integer year, Integer month){
        return totalOfInflowOfLiability(user, year, month, "inflow") - totalOfInflowOfLiability(user, year, month, "liability");
    }

}
