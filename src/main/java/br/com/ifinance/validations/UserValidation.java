package br.com.ifinance.validations;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserValidation {

    public Boolean usernameValidation(User user){
        return user.getUsername().length() <= 60 && user.getUsername().length() >= 3;
    }

    public Boolean passwordValidation(User user){
        return user.getPassword().length() <= 20 && user.getPassword().length() >= 3;
    }

    public Boolean nameValidation(User user){

        if(user.getName().length() <= 60 && user.getName().length() >= 3){
            try{
                Integer userTry = Integer.parseInt(user.getName());
                return false;
            }
            catch (Exception e){
                return true;
            }
        }
        else{
            return false;
        }

    }

    public Boolean emailValidation(User user){
        return user.getEmail().length() <= 45 && user.getEmail().length() >= 3;
    }

    public Boolean birthDateValidation(User user){
        return user.getBirthDate().matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public Boolean userValidation(User user){

        System.err.println("VALIDAÇÕES DE CADASTRO\n================================================================");
        System.err.println("Username validation: " + usernameValidation(user));
        System.err.println("Password validation: " + passwordValidation(user));
        System.err.println("Name validation: " + nameValidation(user));
        System.err.println("Email validation: " + emailValidation(user));
        System.err.println("Birth Date validation: " + birthDateValidation(user));

        return
                usernameValidation(user) &&
                passwordValidation(user) &&
                nameValidation(user) &&
                emailValidation(user) &&
                birthDateValidation(user);

    }
}
