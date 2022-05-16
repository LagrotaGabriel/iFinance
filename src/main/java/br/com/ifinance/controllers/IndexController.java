package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.BalanceService;
import br.com.ifinance.services.IndexService;
import br.com.ifinance.services.InflowService;
import br.com.ifinance.services.LiabilityService;
import br.com.ifinance.utils.Dates;
import br.com.ifinance.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    InflowService inflowService;

    @Autowired
    LiabilityService liabilityService;

    @Autowired
    BalanceService balanceService;

    @Autowired
    IndexService indexService;

    @Autowired
    UserRepository userRepository;

    Utils utils = new Utils();
    Dates dates = new Dates();

    @GetMapping
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ModelAndView indexControllerGet(ModelAndView modelAndView,
                                           ModelMap modelMap){

        modelMap.addAttribute("username", utils.loggedUser(userRepository).getUsername());

        modelMap.addAttribute("pagarHoje", indexService.pagarHoje(utils.loggedUser(userRepository)));

        modelMap.addAttribute("atrasados", indexService.emAtraso(utils.loggedUser(userRepository)));

        modelMap.addAttribute("totalDespesas",
                balanceService.totalOfInflowOfLiability(utils.loggedUser(userRepository),
                Integer.parseInt(dates.splitedToday()[0]), Integer.parseInt(dates.splitedToday()[1]), "liability"));

        modelMap.addAttribute("receber", indexService.aReceber(utils.loggedUser(userRepository)));

        modelMap.addAttribute("recebido", balanceService.totalOfInflowOfLiability(utils.loggedUser(userRepository),
                Integer.parseInt(dates.splitedToday()[0]), Integer.parseInt(dates.splitedToday()[1]), "inflow"));

        modelMap.addAttribute("saldo", balanceService.totalBalance(utils.loggedUser(userRepository),
                Integer.parseInt(dates.splitedToday()[0]), Integer.parseInt(dates.splitedToday()[1])));

        modelAndView.setViewName("index");
        return modelAndView;
    }

}
