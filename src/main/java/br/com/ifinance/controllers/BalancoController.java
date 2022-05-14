package br.com.ifinance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/balanco")
public class BalancoController{

    @GetMapping
    public ModelAndView balancoControllerGet(ModelAndView modelAndView){
        modelAndView.setViewName("balanco.html");
        return modelAndView;
    }

}
