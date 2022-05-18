package br.com.ifinance.models.entities.mock;

import br.com.ifinance.models.entities.*;
import br.com.ifinance.models.enums.Gender;

import java.util.Collection;
import java.util.List;

public class UserMock {

    public static User mockRequest(){

        User user = new User();

        Long id = 1L;
        user.getId();

        String username = "Fulano123";
        user.getUsername();

        String password = "abc123";
        user.getPassword();

        String name = "Fulano da Silva";
        user.getName();

        String email = "fulano@email.com.br";
        user.getEmail();

        String birthDate = "2011-11-11";
        user.getBirthDate();

        Gender gender = Gender.M;
        user.getGender();

        List<Income> incomes = null;
        user.getIncomes();

        List<Inflow> inflows = null;
        user.getInflows();

        List<Patrimony> assets = null;
        user.getAssets();

        List<Liability> liabilities = null;
        user.getLiabilities();

        Collection<Role> roles = null;
        user.getRoles();

        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setBirthDate(birthDate);
        user.setGender(gender);
        user.setIncomes(incomes);
        user.setInflows(inflows);
        user.setAssets(assets);
        user.setLiabilities(liabilities);
        user.setRoles(roles);

        return user;
    }
}
