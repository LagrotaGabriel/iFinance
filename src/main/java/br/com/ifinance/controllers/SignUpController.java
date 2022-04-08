package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.services.UserService;
import br.com.ifinance.validations.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    UserValidation userValidation = new UserValidation();

    @Autowired
    UserService userService;

    @GetMapping
    public ModelAndView signUpGet(ModelAndView modelAndView){
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView signUpPost(User user, RedirectAttributes redirAttrs, Model model, ModelAndView modelAndView){

        if(userValidation.userValidation(user)){
            modelAndView.setViewName("redirect:/login");

        }
        else{
            redirAttrs.addFlashAttribute("ErroCadastro",
                    "Ops! Algum campo foi preenchido de forma incorreta.");
            modelAndView.setViewName("redirect:/signup");
        }

        System.err.println(user.toString());
        return modelAndView;
    }

}
