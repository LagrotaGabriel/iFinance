package br.com.ifinance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/renda")
public class RendaController {

    public ModelAndView rendaControllerGet(ModelAndView modelAndView){

        modelAndView.setViewName("renda");
        return modelAndView;
    }

}
