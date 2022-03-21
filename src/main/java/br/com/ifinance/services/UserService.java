package br.com.ifinance.services;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.repositories.UserRepository;
import br.com.ifinance.validations.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // Create a new user in the database
    public User create(User user){
        return userRepository.save(user);
    }

    // List all users of the database
    public List<User> readAll(){
        return userRepository.findAll();
    }

    // List a user by ID
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    // Update a user by ID
    public User updateUser(Long id, User user){

        Optional<User> updated = findById(id);

        if(updated.isPresent()){

            updated.get().setUsername(user.getUsername());
            updated.get().setPassword(user.getPassword());
            updated.get().setName(user.getName());
            updated.get().setFixedIncome(user.getFixedIncome());
            updated.get().setVariableIncome(user.getVariableIncome());

            if(user.getTransactions() != null) {
                updated.get().setTransactions(user.getTransactions());
            }

            if(user.getAssets() != null) {
                updated.get().setAssets(user.getAssets());
            }

            if(user.getLiabilities() != null) {
                updated.get().setLiabilities(user.getLiabilities());
            }

            return create(updated.get());

        }

        else{
            return null;
        }

    }

    // Delete a user by ID
    public Boolean deleteUser(Long id){
        if(findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

}



