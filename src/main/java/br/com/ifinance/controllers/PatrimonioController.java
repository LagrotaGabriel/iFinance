package br.com.ifinance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/patrimonio")
public class PatrimonioController {

    @GetMapping
    public ModelAndView patrimonioControllerGet(ModelAndView modelAndView){
        modelAndView.setViewName("patrimonio");
        return modelAndView;
    }

}
