package br.com.ifinance.controllers;

import br.com.ifinance.repositories.RoleRepository;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.UserService;
import br.com.ifinance.utils.CargaDb;
import br.com.ifinance.utils.CargaRoles;
import br.com.ifinance.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    Utils utils = new Utils();

    @GetMapping("login")
    public ModelAndView loginControllerGet(ModelAndView modelAndView){

        if(roleRepository.findByRole("ADMIN") == null){
            CargaRoles.cargaRequest(roleRepository);
        }
        if(userRepository.findByUsername("admin") == null){
            CargaDb.cargaAdmin(roleRepository, userService);
        }

        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("login")
    public ModelAndView loginControllerPost(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
