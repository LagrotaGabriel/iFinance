package br.com.ifinance.utils.test;

import br.com.ifinance.utils.Dates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DatesTest {

    Dates dates = new Dates();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();
    String[] dataSplited = dtf.format(now).split("/");
    String brDate = dataSplited[2] + '/' + dataSplited[1] + '/' + dataSplited[0];

    @Test
    public void shouldTestToday(){
        Assertions.assertEquals(dates.today(), dtf.format(now));
    }

    @Test
    public void shouldTestSplittedToday(){
        Assertions.assertEquals(Arrays.toString((dates.splitedToday())),
                (Arrays.toString(dtf.format(now).split("/"))));
    }

    @Test
    public void shouldTestTodayBr(){
        Assertions.assertEquals(dates.todayBr(), dataSplited[2] + '/' + dataSplited[1] + '/' + dataSplited[0]);
    }

    @Test
    public void shouldTestSplittedTodayBr(){
        Assertions.assertEquals(Arrays.toString(dates.splittedTodayBr()),
                Arrays.toString(brDate.split("/")));
    }

    @Test
    public void shouldTestUsToBr(){
        String[] usSplit = ("11-11-2011").split("-");
        Assertions.assertEquals(dates.usToBr("11-11-2011"),
                usSplit[2] + "/" + usSplit[1] + "/" + usSplit[0]
                );
    }

    @Test
    public void shouldTestBrToBr(){
        String[] usSplit = ("11/11/2011").split("/");
        Assertions.assertEquals(dates.brToUs("11/11/2011"),
                usSplit[2] + "-" + usSplit[1] + "-" + usSplit[0]
        );
    }

}
