package br.com.ifinance.services;

import br.com.ifinance.models.entities.Transaction;
import br.com.ifinance.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    // Create a new Transaction in the Database
    public Transaction create(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    // Read all transactions in the Database
    public List<Transaction> readAll(){
        return transactionRepository.findAll();
    }

    // Read a transaction by ID
    public Optional<Transaction> findById(Long id){
        return transactionRepository.findById(id);
    }

    // Update a transaction by ID
    public Transaction updateTransaction(Long id, Transaction transaction){

        Optional<Transaction> updated = findById(id);

        if(updated.isPresent()){
            updated.get().setName(transaction.getName());
            updated.get().setDescription(transaction.getDescription());
            updated.get().setAmount(transaction.getAmount());
            updated.get().setDate(transaction.getDate());
            updated.get().setDone(transaction.getDone());
            updated.get().setToDo(transaction.getToDo());
            updated.get().setTransactionType(transaction.getTransactionType());
            updated.get().setMean(transaction.getMean());
            updated.get().setUser(transaction.getUser());
            return create(updated.get());
        }

        else{
            return null;
        }

    }

    // Delete a transaction by ID
    public Boolean deleteTransaction(Long id){
        if(findById(id).isPresent()){
            transactionRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
}
