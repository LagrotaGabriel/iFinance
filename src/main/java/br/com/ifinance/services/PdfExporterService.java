package br.com.ifinance.services;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.utils.Dates;
import br.com.ifinance.utils.Utils;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PdfExporterService {

    BalanceService balanceService = new BalanceService();
    Dates dates = new Dates();
    Utils utils = new Utils();

    public void export(HttpServletResponse response, Integer year, Integer month, UserRepository userRepository)
            throws DocumentException, IOException{

        Document document = new Document(PageSize.A4, 100,100,10,10);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Paragraph paragraph = new Paragraph();

        Font font = FontFactory.getFont(FontFactory.TIMES, 24, Font.BOLD);
        paragraph = new Paragraph("Balanço iFinance", font);
        paragraph.setAlignment(ElementTags.ALIGN_CENTER);
        document.add(paragraph);

        font = FontFactory.getFont(FontFactory.TIMES, 16, Font.ITALIC);
        paragraph = new Paragraph(utils.loggedUser(userRepository).getName(), font);
        paragraph.setAlignment(ElementTags.ALIGN_CENTER);
        document.add(paragraph);

        font = FontFactory.getFont(FontFactory.TIMES, 16, Font.ITALIC);
        paragraph = new Paragraph(dates.monthNumberToMonthString(month) + " de " + year, font);
        paragraph.setAlignment(ElementTags.ALIGN_CENTER);
        document.add(paragraph);

        paragraph = new Paragraph("_________________________________________________", font);
        paragraph.setAlignment(ElementTags.ALIGN_CENTER);
        paragraph.setSpacingAfter(10);
        document.add(paragraph);

        font = FontFactory.getFont(FontFactory.TIMES, 24, Font.BOLD);
        paragraph = new Paragraph("Entradas", font);
        paragraph.setAlignment(ElementTags.ALIGN_JUSTIFIED);
        document.add(paragraph);

        font = FontFactory.getFont(FontFactory.TIMES, 16, Font.NORMAL);
        paragraph = new Paragraph("Maior entrada: R$ " + balanceService.biggerInflowOrLiability
                (utils.loggedUser(userRepository), year, month, "inflow"), font);
        paragraph.setAlignment(ElementTags.ALIGN_JUSTIFIED);
        document.add(paragraph);

        font = FontFactory.getFont(FontFactory.TIMES, 16, Font.NORMAL);
        paragraph = new Paragraph("Menor entrada: R$ " + balanceService.smallerInflowOrLiability
                (utils.loggedUser(userRepository), year, month, "inflow"), font);
        paragraph.setAlignment(ElementTags.ALIGN_JUSTIFIED);
        document.add(paragraph);

        font = FontFactory.getFont(FontFactory.TIMES, 16, Font.NORMAL);
        paragraph = new Paragraph("Meio mais usado: " + balanceService.mostUsedMean
                (utils.loggedUser(userRepository), year, month, "inflow"), font);
        paragraph.setAlignment(ElementTags.ALIGN_JUSTIFIED);
        document.add(paragraph);

        font = FontFactory.getFont(FontFactory.TIMES, 16, Font.NORMAL);
        paragraph = new Paragraph("Valor total: R$  " + balanceService.totalOfInflowOfLiability
                (utils.loggedUser(userRepository), year, month, "inflow"), font);
        paragraph.setAlignment(ElementTags.ALIGN_JUSTIFIED);
        document.add(paragraph);

        font = FontFactory.getFont(FontFactory.TIMES, 24, Font.BOLD);
        paragraph = new Paragraph("Saídas", font);
        paragraph.setAlignment(ElementTags.ALIGN_JUSTIFIED);
        document.add(paragraph);

        font = FontFactory.getFont(FontFactory.TIMES, 16, Font.NORMAL);
        paragraph = new Paragraph("Maior saída: R$ " + balanceService.biggerInflowOrLiability
                (utils.loggedUser(userRepository), year, month, "liability"), font);
        paragraph.setAlignment(ElementTags.ALIGN_JUSTIFIED);
        document.add(paragraph);

        font = FontFactory.getFont(FontFactory.TIMES, 16, Font.NORMAL);
        paragraph = new Paragraph("Menor saída: R$ " + balanceService.smallerInflowOrLiability
                (utils.loggedUser(userRepository), year, month, "liability"), font);
        paragraph.setAlignment(ElementTags.ALIGN_JUSTIFIED);
        document.add(paragraph);

        font = FontFactory.getFont(FontFactory.TIMES, 16, Font.NORMAL);
        paragraph = new Paragraph("Meio mais usado: " + balanceService.mostUsedMean
                (utils.loggedUser(userRepository), year, month, "liability"), font);
        paragraph.setAlignment(ElementTags.ALIGN_JUSTIFIED);
        document.add(paragraph);

        font = FontFactory.getFont(FontFactory.TIMES, 16, Font.NORMAL);
        paragraph = new Paragraph("Valor total: R$  " + balanceService.totalOfInflowOfLiability
                (utils.loggedUser(userRepository), year, month, "liability"), font);
        paragraph.setAlignment(ElementTags.ALIGN_JUSTIFIED);
        document.add(paragraph);

        paragraph = new Paragraph("_________________________________________________", font);
        paragraph.setAlignment(ElementTags.ALIGN_CENTER);
        paragraph.setSpacingAfter(10);
        document.add(paragraph);

        font = FontFactory.getFont(FontFactory.TIMES, 24, Font.BOLD);
        paragraph = new Paragraph("Total: R$ " + balanceService.totalBalance
                (utils.loggedUser(userRepository), year, month), font);
        paragraph.setAlignment(ElementTags.ALIGN_JUSTIFIED);
        document.add(paragraph);

        document.close();
    }

}
