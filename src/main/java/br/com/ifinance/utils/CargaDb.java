package br.com.ifinance.utils;

import br.com.ifinance.models.entities.Role;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.Gender;
import br.com.ifinance.repositories.RoleRepository;
import br.com.ifinance.services.UserService;

import java.util.ArrayList;
import java.util.Collection;

public class CargaDb {

    public static Boolean cargaAdmin(RoleRepository roleRepository, UserService userService){

            Role adminRole = roleRepository.findByRole("ADMIN");
            Collection<Role> roles = new ArrayList<>();
            roles.add(adminRole);

            User user = User.builder()
                    .id(0L)
                    .assets(null)
                    .birthDate("2011-11-11")
                    .email("abc@abc.com.br")
                    .gender(Gender.M)
                    .incomes(null)
                    .inflows(null)
                    .liabilities(null)
                    .name("Administrador")
                    .password("762")
                    .roles(roles)
                    .username("admin")
                    .build();
            userService.create(user);
            return true;
    }
}
