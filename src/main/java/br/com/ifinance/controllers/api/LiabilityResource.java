package br.com.ifinance.controllers.api;

import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.services.LiabilityService;
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

@RestController
public class LiabilityResource {

    @Autowired
    LiabilityService liabilityService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @Produces({MediaType.APPLICATION_JSON, "application/json"})
    @ApiOperation(value = "Returns all liabilities saved in database")
    public ResponseEntity<List<Liability>> allLiabilities(){
        if(liabilityService.readAll().size() > 0) return ResponseEntity.ok().body(liabilityService.readAll());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "id={id}", method = RequestMethod.GET)
    @Produces({MediaType.APPLICATION_JSON, "application/json"})
    @ApiOperation(value = "Returns a liability saved in the database based in the id passed in the endpoint")
    public ResponseEntity<Liability> liabilityById(@PathVariable Long id){
        if(liabilityService.findById(id).isPresent()) return ResponseEntity.ok().body(liabilityService.findById(id).get());
        return ResponseEntity.notFound().build();
    }

}
