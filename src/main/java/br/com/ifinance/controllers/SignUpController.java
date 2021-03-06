package br.com.ifinance.controllers;

import br.com.ifinance.models.entities.Role;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.Gender;
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

import java.util.ArrayList;
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
            if(!userService.findByEmail(user.getEmail()).isPresent()) {
                if(!userService.findByUsernm(user.getUsername()).isPresent()){
                    if(user.getUsername().equals("admin")){
                        redirAttrs.addFlashAttribute("ErroCadastro",
                                "N??o ?? poss??vel se cadastrar utilizando o nome de usu??rio admin");
                        modelAndView.setViewName("redirect:/signup");
                    }
                    else {
                        String[] nascimento = user.getBirthDate().split("-");
                        if (Integer.parseInt(nascimento[0]) <= 1900) {
                            redirAttrs.addFlashAttribute("ErroCadastro",
                                    "Ops! O ano de nascimento n??o pode ser menor ou igual do que 1900");
                            modelAndView.setViewName("redirect:/signup");
                        } else if (Integer.parseInt(nascimento[0]) >= 2022) {
                            redirAttrs.addFlashAttribute("ErroCadastro",
                                    "Ops! O ano de nascimento n??o pode ser maior ou igual do que 2022");
                            modelAndView.setViewName("redirect:/signup");
                        } else {

                            Role adminRole = roleRepository.findByRole("USER");
                            Collection<Role> roles = new ArrayList<>();
                            roles.add(adminRole);

                            user.setGender(Gender.M);
                            user.setPassword(passwordEncoder.encode(user.getPassword()));
                            user.setRoles(roles);
                            userRepository.save(user);

                            redirAttrs.addFlashAttribute("SucessoCadastro",
                                    "O cadastro foi realizado com sucesso!");
                            user = new User();
                            modelAndView.setViewName("redirect:/login");
                        }
                    }
                }
                else{
                    redirAttrs.addFlashAttribute("ErroCadastro",
                                "O usu??rio inserido j?? existe em nossa base de dados");
                    modelAndView.setViewName("redirect:/signup");
                }
            }
            else{
                redirAttrs.addFlashAttribute("ErroCadastro",
                        "O e-mail inserido j?? existe em nossa base de dados");
                modelAndView.setViewName("redirect:/signup");
            }
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
        globalUser = user;
        return modelAndView;
    }

}
