package br.com.ifinance.services;

import br.com.ifinance.models.entities.Income;
import br.com.ifinance.repositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository incomeRepository;

    // Create a new Income in the database
    public Income create(Income income){return incomeRepository.save(income);}

    // Read all Incomes in the database
    public List<Income> readAll(){return incomeRepository.findAll();}

    // Read a Income in the data base for the ID passed in the parameter
    public Optional<Income> findById(Long id){return incomeRepository.findById(id);}

    // Update a Income in the data base for the ID passed in the parameter
    public Income update(Long id, Income income){
        Optional<Income> updated = findById(id);
        if(updated.isPresent()){
            updated.get().setDescription(income.getDescription());
            updated.get().setValue(income.getValue());
            updated.get().setDate(income.getDate());
            updated.get().setFrequency(income.getFrequency());
            updated.get().setIncomeType(income.getIncomeType());
            updated.get().setUser(income.getUser());
            return create(updated.get());
        }
        else{
            return null;
        }
    }

    // Delete a income in the data base for the ID passed in the parameter
    public Boolean delete(Long id){
        if(findById(id).isPresent()){
            incomeRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
}
