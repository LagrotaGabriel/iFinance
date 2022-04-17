package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.Mean;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.LiabilityService;
import br.com.ifinance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/despesas")
public class DespesasController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    LiabilityService liabilityService;

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

        if(liability.getMean()==null){
            liability.setMean(Mean.AGENDADO);
        }

        liability.setUser(user);
        List<Liability> novaLista = user.getLiabilities();
        System.err.println("FIRST");
        System.err.println(novaLista);
        novaLista.add(liability);
        System.err.println("SECOND");
        System.err.println(novaLista);

        user.setLiabilities(novaLista);

        System.err.println("THIRD");
        System.err.println(user);
        System.err.println(user.getLiabilities());

        userService.updateUser(user.getId(), user);

        modelAndView.setViewName("redirect:despesas");
        return modelAndView;
    }

    @PostMapping("/delete-{id}")
    public ModelAndView despesasControllerDelete(@PathVariable Long id, ModelAndView modelAndView){
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

        user.getLiabilities().remove(user.getLiabilities().indexOf(liabilityService.findById(id).get()));
        System.err.println(user.getLiabilities());
        userService.updateUser(id, user);
        liabilityService.deleteLiability(id);
        modelAndView.setViewName("redirect:../despesas");
        return modelAndView;
    }

}
