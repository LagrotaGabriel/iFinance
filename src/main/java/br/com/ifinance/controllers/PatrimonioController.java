package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.Patrimony;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.PatrimonyService;
import br.com.ifinance.services.UserService;
import br.com.ifinance.utils.Dates;
import br.com.ifinance.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    PatrimonyService patrimonyService;

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

        Integer currentPage = page.orElse(1);
        String currentType = type.orElse("all");

        /* CAPTURANDO O USUÁRIO ATUAL */
        Object logged = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        User user;
        if (logged instanceof UserDetails) {
            username = ((UserDetails)logged).getUsername();
        }
        else {
            username = logged.toString();
        }
        if(username.equals("admin")){
            user = new User();
        }
        else{
            user = userRepository.findByUsername(username);
        }

        // TODOS OS PATRIMÔNIOS
        if(user.getAssets().size() == 0){
            System.err.println("VAZIO");
            model.addAttribute("allAssets", "");
        }
        else {
            System.err.println("CHEIO");
            model.addAttribute("allAssets", user.getAssets());
            System.err.println(user.getAssets());
        }

        modelAndView.setViewName("patrimonio");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView patrimonioControllerPost(Patrimony patrimony,
                                                 RedirectAttributes redirAttrs,
                                                 ModelAndView modelAndView){

        /* CAPTURANDO O USUÁRIO ATUAL */
        Object logged = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        User user;
        if (logged instanceof UserDetails) {
            username = ((UserDetails)logged).getUsername();
        }
        else {
            username = logged.toString();
        }
        if(username.equals("admin")){
            user = new User();
        }
        else{
            user = userRepository.findByUsername(username);
        }

        patrimony.setUser(user);
        patrimony.setDate(dates.today());
        List<Patrimony> userAssets = user.getAssets();
        userAssets.add(patrimony);
        user.setAssets(userAssets);

        userService.updateUser(user.getId(), user);

        System.err.println(patrimony);
        System.err.println(user.getAssets());

        modelAndView.setViewName("redirect:patrimonio");
        return modelAndView;
    }


}
