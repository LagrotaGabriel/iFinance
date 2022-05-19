package br.com.ifinance.controllers;

import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.BalanceService;
import br.com.ifinance.services.PdfExporterService;
import br.com.ifinance.utils.Utils;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/balanco")
public class BalancoController{

    @Autowired
    BalanceService balanceService;

    @Autowired
    UserRepository userRepository;

    Utils utils = new Utils();

    @GetMapping
    public ModelAndView balancoControllerGet(@RequestParam("year") Optional<Integer> year,
                                             @RequestParam("month") Optional<Integer> month,
                                             ModelMap modelMap, ModelAndView modelAndView,
                                             HttpServletRequest req){

        String baseUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);

        int currentYear = year.orElse(cal.get(Calendar.YEAR));
        int currentMonth = month.orElse(cal.get(Calendar.MONTH) + 1);

        modelMap.addAttribute("username", utils.loggedUser(userRepository).getUsername());

        modelMap.addAttribute("maiorEntrada", balanceService.biggerInflowOrLiability
                (utils.loggedUser(userRepository), currentYear, currentMonth, "inflow"));
        modelMap.addAttribute("maiorSaida", balanceService.biggerInflowOrLiability
                (utils.loggedUser(userRepository), currentYear, currentMonth, "liability"));

        modelMap.addAttribute("menorEntrada", balanceService.smallerInflowOrLiability
                (utils.loggedUser(userRepository), currentYear, currentMonth, "inflow"));
        modelMap.addAttribute("menorSaida", balanceService.smallerInflowOrLiability
                (utils.loggedUser(userRepository), currentYear, currentMonth, "liability"));

        modelMap.addAttribute("totalEntrada", balanceService.totalOfInflowOfLiability
                (utils.loggedUser(userRepository), currentYear, currentMonth, "inflow"));

        modelMap.addAttribute("totalSaida", balanceService.totalOfInflowOfLiability
                (utils.loggedUser(userRepository), currentYear, currentMonth, "liability"));

        modelMap.addAttribute("saldo", balanceService.totalBalance
                (utils.loggedUser(userRepository), currentYear, currentMonth));

        modelMap.addAttribute("meioEntradaMaisUsado", balanceService.mostUsedMean
                (utils.loggedUser(userRepository), currentYear, currentMonth, "inflow"));

        modelMap.addAttribute("meioSaidaMaisUsado", balanceService.mostUsedMean
                (utils.loggedUser(userRepository), currentYear, currentMonth, "liability"));

        modelMap.addAttribute("baseUrl", baseUrl);
        modelMap.addAttribute("year", currentYear);
        modelMap.addAttribute("month", currentMonth);
        modelAndView.setViewName("balanco.html");

        return modelAndView;
    }

    @GetMapping("/relatorio")
    public void relatorio(ModelAndView modelAndView,
                          @RequestParam("year") Optional<Integer> year,
                          @RequestParam("month") Optional<Integer> month,
                          HttpServletResponse res) throws DocumentException, IOException {

        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);

        int currentYear = year.orElse(cal.get(Calendar.YEAR));
        int currentMonth = month.orElse(cal.get(Calendar.MONTH) + 1);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateTime = dateFormat.format(new Date());

        res.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachement; filename=balanco_" + currentDateTime + ".pdf";
        res.setHeader(headerKey, headerValue);

        PdfExporterService pdfExporterService = new PdfExporterService();
        pdfExporterService.export(res, currentYear, currentMonth, userRepository);
    }

}
