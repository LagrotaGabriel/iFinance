package br.com.ifinance.utils.test;

import br.com.ifinance.repositories.RoleRepository;
import br.com.ifinance.services.UserService;
import br.com.ifinance.utils.CargaDb;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CargaDbTest {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserService userService;

    @Test
    public void shouldTestCargaAdminMethod(){
        Assertions.assertFalse(CargaDb.cargaAdmin(roleRepository, userService));
    }

}
