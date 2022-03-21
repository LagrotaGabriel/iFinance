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

        if(user.getPassword().length() <= 20 && user.getPassword().length() >= 5){
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
                Integer fixedIncomeTry = Integer.parseInt((user.getFixedIncome()).toString());
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
                Integer variableIncomeTry = Integer.parseInt((user.getVariableIncome()).toString());
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

        return
                usernameValidation(user) &&
                passwordValidation(user) &&
                nameValidation(user) &&
                fixedIncomeValidation(user) &&
                variableIncomeValidation(user);

    }
}
