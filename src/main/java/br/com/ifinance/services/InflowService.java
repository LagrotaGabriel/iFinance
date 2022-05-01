package br.com.ifinance.services;

import br.com.ifinance.models.entities.Inflow;
import br.com.ifinance.repositories.InflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InflowService {

    @Autowired
    InflowRepository inflowRepository;

    // Create a inflow in the database
    public Inflow create(Inflow inflow){return inflowRepository.save(inflow);}

    // Read all inflow saved in the database
    public List<Inflow> readAll(){return inflowRepository.findAll();}

    // Find a inflow saved in the database with base in the id passed by parameter
    public Optional<Inflow> findById(Long id){return inflowRepository.findById(id);}

    // Update a inflow in the database with base in the id passed by parameter
    public Inflow update(Long id, Inflow inflow){
        Optional<Inflow> updated = findById(id);
        if(updated.isPresent()){
            updated.get().setDescription(inflow.getDescription());
            updated.get().setValue(inflow.getValue());
            updated.get().setDate(inflow.getDate());
            updated.get().setScheduling(inflow.getScheduling());
            updated.get().setCreated(inflow.getCreated());
            updated.get().setStatusInflow(inflow.getStatusInflow());
            updated.get().setMean(inflow.getMean());
            updated.get().setUser(inflow.getUser());
            return create(updated.get());
        }
        else{
            return null;
        }
    }

    // Delete a inflow in the database with base in the id passed by parameter
    public Boolean delete(Long id){
        if(findById(id).isPresent()){
            inflowRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
}
