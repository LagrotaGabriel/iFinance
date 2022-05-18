package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.UserService;
import br.com.ifinance.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PerfilController {

    Utils utils = new Utils();

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("{username}")
    public ModelAndView perfilControllerGet(@PathVariable String username, User user,
                                            ModelAndView modelAndView, ModelMap modelMap){

        if(userRepository.findByUsername(username) != null) {
            modelMap.addAttribute("usuario", utils.loggedUser(userRepository));
            modelAndView.setViewName("perfil");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @PostMapping("/{username}")
    public ModelAndView perfilControllerPost(@PathVariable String username, User user, ModelAndView modelAndView){

        User usuario = utils.loggedUser(userRepository);
        usuario.setName(user.getName());
        usuario.setEmail(user.getEmail());
        usuario.setBirthDate(user.getBirthDate());
        usuario.setGender(user.getGender());
        userService.updateUser(usuario.getId(), usuario);
        modelAndView.setViewName("redirect:"+username);
        return modelAndView;
    }
}
