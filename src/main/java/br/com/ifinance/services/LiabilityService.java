package br.com.ifinance.services;

import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.repositories.LiabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiabilityService {

    @Autowired
    LiabilityRepository liabilityRepository;

    // Create a new Liability in the database
    public Liability create(Liability liability){
        return liabilityRepository.save(liability);
    }

    // Read all liabilities in the data base
    public List<Liability> readAll(){
        return liabilityRepository.findAll();
    }

    // Read a liability in the data base for the ID passed in the parameter
    public Optional<Liability> findById(Long id){
        return liabilityRepository.findById(id);
    }

    // Update a liability in the data base for the ID passed in the parameter
    public Liability updateLiability(Long id, Liability liability){

        Optional<Liability> updated = findById(id);
        if(updated.isPresent()){
            updated.get().setDate(liability.getDate());
            updated.get().setStatusLiability(liability.getStatusLiability());
            updated.get().setScheduling(liability.getScheduling());
            updated.get().setDescription(liability.getDescription());
            updated.get().setValue(liability.getValue());
            updated.get().setUser(liability.getUser());
            return create(updated.get());
        }
        else{
            return null;
        }
    }

    // Delete a liability saved in the data base for the ID passed in the parameter
    public Boolean deleteLiability(Long id){
        if(findById(id).isPresent()){
            liabilityRepository.deleteById(id);
            return true;
        }
        else{
            return true;
        }
    }

}
