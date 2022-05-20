package br.com.ifinance.utils;

import br.com.ifinance.models.entities.Role;
import br.com.ifinance.repositories.RoleRepository;

public class CargaRoles {
    public static void cargaRequest(RoleRepository roleRepository){
        Role roleUser = Role.builder()
                .id(1L)
                .role("USER")
                .users(null)
                .build();
        roleRepository.save(roleUser);

        Role roleAdmin = Role.builder()
                .id(2L)
                .role("ADMIN")
                .users(null)
                .build();
        roleRepository.save(roleAdmin);
    }

}
