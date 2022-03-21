package br.com.ifinance.validations;

import br.com.ifinance.models.entities.User;

public class UserValidation {

    public Boolean usernameValidation(User user){

        if(user.getUsername().matches("[a-z A-Z]*")){
            if(user.getUsername().length() <= 20 && user.getUsername().length() >= 3){
                return true;
            } else{
                return false;
            }
        } else{
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

        if(user.getName().length() <= 20 && user.getName().length() >= 3){
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

    public Boolean userValidation(User user){

        System.err.println("Username validation: " + usernameValidation(user));
        System.err.println("Password validation: " + passwordValidation(user));
        System.err.println("Name validation: " + nameValidation(user));
        System.err.println("Fixed Income validation: " + fixedIncomeValidation(user));
        System.err.println("Variable Income validation: " + variableIncomeValidation(user));
        return
                usernameValidation(user) &&
                passwordValidation(user) &&
                nameValidation(user) &&
                fixedIncomeValidation(user) &&
                variableIncomeValidation(user);

    }
}
