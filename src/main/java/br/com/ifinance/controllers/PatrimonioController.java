package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.Patrimony;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.PatrimonyService;
import br.com.ifinance.services.UserService;
import br.com.ifinance.utils.Dates;
import br.com.ifinance.utils.PatrimonyUtils;
import br.com.ifinance.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/patrimonio")
public class PatrimonioController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    PatrimonyService patrimonyService;

    PatrimonyUtils patrimonyUtils = new PatrimonyUtils();
    Utils utils = new Utils();
    Dates dates = new Dates();

    @GetMapping
    public ModelAndView patrimonioControllerGet(@RequestParam("type") Optional<String> type,
                                                @RequestParam("page") Optional<Integer> page,
                                                Model model,
                                                ModelMap modelMap,
                                                RedirectAttributes redirAttrs,
                                                ModelAndView modelAndView,
                                                HttpServletRequest req){

        String baseUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        Integer currentPage = page.orElse(1);
        String currentType = type.orElse("all");
        modelMap.addAttribute("baseUrl", baseUrl);

        modelMap.addAttribute("assets", patrimonyUtils.patrimonyTypeFilter(utils.loggedUser(userRepository), currentType));
        modelMap.addAttribute("page" ,currentPage);

        modelAndView.setViewName("patrimonio");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView patrimonioControllerPost(Patrimony patrimony,
                                                 RedirectAttributes redirAttrs,
                                                 ModelAndView modelAndView){

        patrimony.setUser(utils.loggedUser(userRepository));
        patrimony.setDate(dates.today());
        List<Patrimony> userAssets = utils.loggedUser(userRepository).getAssets();
        userAssets.add(patrimony);
        utils.loggedUser(userRepository).setAssets(userAssets);

        userService.updateUser(utils.loggedUser(userRepository).getId(), utils.loggedUser(userRepository));

        System.err.println(patrimony);
        System.err.println(utils.loggedUser(userRepository).getAssets());

        modelAndView.setViewName("redirect:patrimonio");
        return modelAndView;
    }


}
