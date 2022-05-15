package br.com.ifinance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("login")
    public ModelAndView loginControllerGet(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("login")
    public ModelAndView loginControllerPost(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
