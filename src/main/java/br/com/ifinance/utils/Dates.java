package br.com.ifinance.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dates {

    // TODAY IN US DEFAULT
    public String today(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    public String[] splitedToday(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now).split("/");
    }

    // TODAY IN BR DEFAULT
    public String todayBr(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String[] dataSplited = dtf.format(now).split("-");
        return dataSplited[2] + '/' + dataSplited[1] + '/' + dataSplited[0];
    }
    public String[] splittedTodayBr(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String[] dataSplited = dtf.format(now).split("-");
        String brDate = dataSplited[2] + '/' + dataSplited[1] + '/' + dataSplited[0];
        return brDate.split("/");
    }

    // CONVERT A US DATE TO A BR DATE
    public String usToBr(String date){
        String[] usSplit = date.split("-");
        return usSplit[2] + "/" + usSplit[1] + "/" + usSplit[0];
    }

    // CONVERT A BR DATE TO A US DATE
    public String brToUs(String date){
        String[] brSplit = date.split("/");
        return brSplit[2] + "-" + brSplit[1] + "-" + brSplit[0];
    }
}
