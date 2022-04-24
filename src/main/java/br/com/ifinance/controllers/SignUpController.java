package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.Role;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.repositories.RoleRepository;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.UserService;
import br.com.ifinance.validations.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.Collection;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    UserValidation userValidation = new UserValidation();

    @Autowired
    UserService userService;

    User globalUser = new User();

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    public ModelAndView signUpGet(ModelAndView modelAndView, Model model){
        model.addAttribute("user", globalUser);
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView signUpPost(User user, RedirectAttributes redirAttrs, Model model, ModelAndView modelAndView){
        if(userValidation.userValidation(user)){
            //if(userService.findByEmail(user.getEmail()).isEmpty()) {
                //if(userService.findByUsernm(user.getUsername()).isEmpty()){
                    if(user.getUsername().equals("admin")){
                        redirAttrs.addFlashAttribute("ErroCadastro",
                                "Não é possível se cadastrar utilizando o nome de usuário admin");
                        modelAndView.setViewName("redirect:/signup");
                    }
                    else {
                        String[] nascimento = user.getBirthDate().split("-");
                        if (Integer.parseInt(nascimento[0]) <= 1900) {
                            redirAttrs.addFlashAttribute("ErroCadastro",
                                    "Ops! O ano de nascimento não pode ser menor ou igual do que 1900");
                            modelAndView.setViewName("redirect:/signup");
                        } else if (Integer.parseInt(nascimento[0]) >= 2022) {
                            redirAttrs.addFlashAttribute("ErroCadastro",
                                    "Ops! O ano de nascimento não pode ser maior ou igual do que 2022");
                            modelAndView.setViewName("redirect:/signup");
                        } else {
                            roleRepository.save(new Role("USER"));
                            Role userRole = roleRepository.findByRole("USER");
                            user.setPassword(passwordEncoder.encode(user.getPassword()));
                            user.setRoles((Collection<Role>) userRole);
                            userRepository.save(user);

                            redirAttrs.addFlashAttribute("SucessoCadastro",
                                    "O cadastro foi realizado com sucesso!");
                            user = new User();
                            modelAndView.setViewName("redirect:/login");
                        }
                    }
               // }
                //else{
                   // redirAttrs.addFlashAttribute("ErroCadastro",
                               // "O usuário inserido já existe em nossa base de dados");
                   // modelAndView.setViewName("redirect:/signup");
                //}
           // }
            //else{
                //redirAttrs.addFlashAttribute("ErroCadastro",
                       // "O e-mail inserido já existe em nossa base de dados");
               // modelAndView.setViewName("redirect:/signup");
            //}
        }
        else{
            if(!userValidation.birthDateValidation(user)){
                redirAttrs.addFlashAttribute("ErroCadastro",
                                "Ops! A data de nascimento foi preenchida de forma incorreta.");
                modelAndView.setViewName("redirect:/signup");

            }
            else{
                redirAttrs.addFlashAttribute("ErroCadastro",
                        "Ops! Algum campo foi preenchido de forma incorreta.");
                modelAndView.setViewName("redirect:/signup");
            }
        }
        System.err.println(user.toString());
        globalUser = user;
        return modelAndView;
    }

}
