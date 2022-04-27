package br.com.ifinance.utils;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Utils {

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
        if(username.equals("admin")){
            user = new User();
        }
        else{
            user = userRepository.findByUsername(username);
        }
        return user;
    }

}
