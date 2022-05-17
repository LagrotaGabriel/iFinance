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
        if(username.equals("admin")){
            roleRepository.save(new Role("USER"));
            Role adminRole = roleRepository.findByRole("USER");
            user = User.builder()
                    .id(0L)
                    .assets(null)
                    .birthDate("11/11/2011")
                    .email("abc@abc.com.br")
                    .gender(Gender.M)
                    .incomes(null)
                    .inflows(null)
                    .liabilities(null)
                    .name("Administrador")
                    .password("762")
                    .roles((Collection<Role>) adminRole)
                    .username("admin")
                    .build();
        }
        else{
            user = userRepository.findByUsername(username);
        }
        return user;
    }

}
