package br.com.ifinance.controllers.api;

import br.com.ifinance.models.entities.Patrimony;
import br.com.ifinance.services.PatrimonyService;
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
@Api(value = "iFinance API - Patrimony Resource")
@RestController
@RequestMapping("api/patrimony")
public class PatrimonyResource {

    @Autowired
    PatrimonyService patrimonyService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @Produces({MediaType.APPLICATION_JSON, "application/json"})
    @ApiOperation(value = "Returns all assets saved in database")
    public ResponseEntity<List<Patrimony>> allAssets(){
        if(patrimonyService.readAll().size() > 0) return ResponseEntity.ok().body(patrimonyService.readAll());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "id={id}", method = RequestMethod.GET)
    @Produces({MediaType.APPLICATION_JSON, "application/json"})
    @ApiOperation(value = "Returns a patrimony saved in the database based in the id passed in the endpoint")
    public ResponseEntity<Patrimony> patrimonyById(@PathVariable Long id){
        if(patrimonyService.findById(id).isPresent()) return ResponseEntity.ok().body(patrimonyService.findById(id).get());
        return ResponseEntity.notFound().build();
    }

}
