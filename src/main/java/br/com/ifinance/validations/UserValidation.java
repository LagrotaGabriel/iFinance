package br.com.ifinance.validations;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserValidation {

    @Autowired
    UserService userService;

    public Boolean usernameValidation(User user){

        try {
            if (userService.findByUsername(user.getUsername()).isEmpty() && !user.getUsername().equals("admin"))
                if (user.getUsername().matches("[a-z A-Z]*")) {
                    if (user.getUsername().length() <= 20 && user.getUsername().length() >= 3) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            else {
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }

    public Boolean passwordValidation(User user){

        if(user.getPassword().length() <= 20 && user.getPassword().length() >= 3){
            return true;
        } else{
            return false;
        }

    }

    public Boolean nameValidation(User user){

        if(user.getName().length() <= 15 && user.getName().length() >= 3){
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

    public Boolean lastNameValidation(User user){

        if(user.getName().length() <= 35 && user.getLastName().length() >= 3){
            try{
                Integer userTry = Integer.parseInt(user.getLastName());
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

        try {
            if (userService.findByEmail(user.getEmail()).isEmpty())
                if (user.getEmail().matches("[a-z A-Z]*")) {
                    if (user.getEmail().length() <= 45 && user.getEmail().length() >= 3) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            else {
                return false;
            }
        }
        catch (Exception e){
            return false;
        }

    }

    public Boolean birthDateValidation(User user){

        if (user.getBirthDate() != null && !user.getBirthDate().equals("")) {
            return true;
        }
        else{
            return false;
        }

    }

    public Boolean fixedIncomeValidation(User user){

        if(user.getFixedIncome() != null){
            try{
                Double fixedIncomeTry = Double.parseDouble((user.getFixedIncome()).toString());
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
        else{
            return false;
        }

    }

    public Boolean variableIncomeValidation(User user){

        if(user.getVariableIncome() != null){
            try{
                Double variableIncomeTry = Double.parseDouble((user.getVariableIncome()).toString());
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
        else{
            return false;
        }

    }

    public Boolean wageValidation(User user){

        if(user.getWorks()) {
            if (user.getWage() != null) {
                try {
                    Double wageTry = Double.parseDouble((user.getWage()).toString());
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        }
        else{
            return true;
        }

    }

    public Boolean userValidation(User user){

        System.err.println("VALIDAÇÕES DE CADASTRO\n================================================================");
        System.err.println("Username validation: " + usernameValidation(user));
        System.err.println("Password validation: " + passwordValidation(user));
        System.err.println("Name validation: " + nameValidation(user));
        System.err.println("Last Name validation: " + lastNameValidation(user));
        System.err.println("Email validation: " + emailValidation(user));
        System.err.println("Birth Date validation: " + birthDateValidation(user));
        System.err.println("Fixed Income validation: " + fixedIncomeValidation(user));
        System.err.println("Variable Income validation: " + variableIncomeValidation(user));
        System.err.println("Wage validation: " + wageValidation(user));
        return
                usernameValidation(user) &&
                passwordValidation(user) &&
                nameValidation(user) &&
                lastNameValidation(user) &&
                emailValidation(user) &&
                birthDateValidation(user) &&
                fixedIncomeValidation(user) &&
                variableIncomeValidation(user) &&
                wageValidation(user);

    }
}
