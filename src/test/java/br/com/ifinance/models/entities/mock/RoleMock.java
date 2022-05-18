package br.com.ifinance.models.entities.mock;

import br.com.ifinance.models.entities.Role;
import br.com.ifinance.models.entities.User;

import java.util.Collection;

public class RoleMock {

    public static Role mockRequest(){

        Role roleObject = new Role();

        Long id = 1L;
        roleObject.getId();

        String role = "ADMIN";
        roleObject.getRole();

        Collection<User> users = null;

        roleObject.setId(id);
        roleObject.setRole(role);
        roleObject.setUsers(users);

        return roleObject;
    }

}
