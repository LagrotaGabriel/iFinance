package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/despesas")
public class DespesasController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ModelAndView despesasControllerGet(Model model, ModelAndView modelAndView, RedirectAttributes redirAttrs){
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

        redirAttrs.addFlashAttribute("liabilitiesFlash", user.getLiabilities());
        model.addAttribute("liabilities", user.getLiabilities());
        model.addAttribute("user", user);
        modelAndView.setViewName("despesas");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView despesasControllerPost(Liability liability, ModelAndView modelAndView){
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

        liability.setUser(user);
        System.err.println(liability);

        modelAndView.setViewName("despesas");
        return modelAndView;
    }

}
