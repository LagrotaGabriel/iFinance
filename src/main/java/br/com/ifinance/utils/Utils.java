package br.com.ifinance.utils;

import br.com.ifinance.models.entities.Role;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.Gender;
import br.com.ifinance.repositories.RoleRepository;
import br.com.ifinance.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class Utils {

    @Autowired
    RoleRepository roleRepository;

    /*** Método que tem como objetivo retornar o usuário logado na sessão atual
     * @param userRepository UserRepository - Leva como parâmetro o UserRepository auto instanciado nos controllers
     * @return User - Retorna o usuário logado na sessão atual */
    public User loggedUser(UserRepository userRepository){
        Object logged = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        User user;
        if (logged instanceof UserDetails) {
            username = ((UserDetails)logged).getUsername();
        }
        else {
            username = logged.toString();
        }

        user = userRepository.findByUsername(username);

        return user;
    }

}
