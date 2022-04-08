package br.com.ifinance.validations;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserValidation {

    public Boolean usernameValidation(User user){
        if (user.getUsername().matches("[a-z A-Z]*")) {
            return user.getUsername().length() <= 20 && user.getUsername().length() >= 3;
        } else {
            return false;
        }
    }

    public Boolean passwordValidation(User user){
        return user.getPassword().length() <= 20 && user.getPassword().length() >= 3;
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
        return user.getEmail().length() <= 45 && user.getEmail().length() >= 3;
    }

    public Boolean birthDateValidation(User user){
        return user.getBirthDate().matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public Boolean fixedIncomeValidation(User user){

            if (user.getFixedIncome() != null) {
                if(user.getFixedIncome() != 0) {
                    try {
                        Double fixedIncomeTry = Double.parseDouble((user.getFixedIncome()).toString());
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
                else{
                    return true;
                }
            }
            else {
                user.setFixedIncome(0.0);
                return true;
            }
    }

    public Boolean variableIncomeValidation(User user){

            if (user.getVariableIncome() != null) {
                if(user.getVariableIncome() != 0) {
                    try {
                        Double variableIncomeTry = Double.parseDouble((user.getVariableIncome()).toString());
                        return true;
                    }
                    catch (Exception e) {
                        return false;
                    }
                }
                else{
                    return true;
                }
            }
            else {
                user.setVariableIncome(0.0);
                return true;
            }
    }

    public Boolean wageValidation(User user){

        if(user.getWorks()) {
                if (user.getWage() != null) {
                    if(user.getWage() != 0) {
                        try {
                            Double wageTry = Double.parseDouble((user.getWage()).toString());
                            return true;
                        }
                        catch (Exception e) {
                            return false;
                        }
                    }
                    else{
                        return true;
                    }
                }
                else {
                    user.setWage(0.0);
                    return true;
                }
        }
        else{
            return true;
        }
    }

    public Boolean extraIncomeValidation(User user){
            if (user.getExtraIncome() != null) {
                if(user.getExtraIncome() != 0) {
                    try {
                        Double extraIncomeTry = Double.parseDouble((user.getExtraIncome()).toString());
                        return true;
                    }
                    catch (Exception e) {
                        return false;
                    }
                }
                else{
                    return true;
                }
            }
            else {
                user.setExtraIncome(0.0);
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
        System.err.println("Extra Income validation: " + extraIncomeValidation(user));
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
                extraIncomeValidation(user) &&
                wageValidation(user);

    }
}
