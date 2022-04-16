package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ModelAndView indexControllerGet(ModelAndView modelAndView){

        modelAndView.setViewName("index");
        return modelAndView;
    }

}
