package br.com.ifinance.services;

import br.com.ifinance.models.entities.Patrimony;
import br.com.ifinance.repositories.PatrimonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrimonyService {

    @Autowired
    PatrimonyRepository patrimonyRepository;

    // Create a new patrimony in database
    public Patrimony create(Patrimony patrimony){
        return patrimonyRepository.save(patrimony);
    }

    // Read all patrimonys saved in the data base
    public List<Patrimony> readAll(){
        return patrimonyRepository.findAll();
    }

    // Find a patrimony by id in the data base
    public Optional<Patrimony> findById(Long id){
        return patrimonyRepository.findById(id);
    }

    // Update a patrimony in the data base with base in the id passed in the parameters
    public Patrimony updatePatrimony(Long id, Patrimony patrimony){

        Optional<Patrimony> updated = findById(id);

        if(updated.isPresent()){
            updated.get().setName(patrimony.getName());
            updated.get().setDescription(patrimony.getDescription());
            updated.get().setValue(patrimony.getValue());
            updated.get().setPatrimonyType(patrimony.getPatrimonyType());
            updated.get().setUser(patrimony.getUser());
            return create(updated.get());
        }
        else{
            return null;
        }

    }

    // Delete a patrimony in the data base using the ID passed in the parameters
    public Boolean deletePatrimony(Long id){
        if(findById(id).isPresent()){
            patrimonyRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

}
