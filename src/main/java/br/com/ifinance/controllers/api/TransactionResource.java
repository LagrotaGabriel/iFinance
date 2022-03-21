package br.com.ifinance.controllers.api;

import br.com.ifinance.models.entities.Transaction;
import br.com.ifinance.services.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@PreAuthorize("hasAnyRole('ADMIN')")
@Api(value = "iFinance API - Transaction Resource")
@RestController
@RequestMapping("api/transaction")
public class TransactionResource {

    @Autowired
    TransactionService transactionService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @Produces({MediaType.APPLICATION_JSON, "application/json"})
    @ApiOperation(value = "Returns all transactions saved in database")
    public ResponseEntity<List<Transaction>> allTransactions(){
        if(transactionService.readAll().size() > 0) return ResponseEntity.ok().body(transactionService.readAll());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "id={id}", method = RequestMethod.GET)
    @Produces({MediaType.APPLICATION_JSON, "application/json"})
    @ApiOperation(value = "Returns a transaction saved in the database based in the id passed in the endpoint")
    public ResponseEntity<Transaction> transactionById(@PathVariable Long id){
        if(transactionService.findById(id).isPresent()) return ResponseEntity.ok().body(transactionService.findById(id).get());
        return ResponseEntity.notFound().build();
    }

}
