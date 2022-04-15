package br.com.ifinance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/despesas")
public class DespesasController {

    @GetMapping
    public ModelAndView despesasControllerGet(ModelAndView modelAndView){
        modelAndView.setViewName("despesas");
        return modelAndView;
    }

}
