package br.com.ifinance.controllers.api;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.services.UserService;
import br.com.ifinance.validations.UserValidation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
@Api(value = "iFinance API - User Resource")
@RestController
@RequestMapping("api/user")
public class UserResource {

    @Autowired
    UserService userService;

    UserValidation userValidation = new UserValidation();

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @Produces({MediaType.APPLICATION_JSON, "application/json"})
    @ApiOperation(value = "Returns all users saved in database")
    public ResponseEntity<List<User>> allUsers(){
        System.err.println("Acesso 2");
        if(userService.readAll().size() > 0) return ResponseEntity.ok().body(userService.readAll());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "id={id}", method = RequestMethod.GET)
    @Produces({MediaType.APPLICATION_JSON, "application/json"})
    @ApiOperation(value = "Returns a user saved in the database based in the id passed in the endpoint")
    public ResponseEntity<User> userById(@PathVariable Long id){
        if(userService.findById(id).isPresent()) return ResponseEntity.ok().body(userService.findById(id).get());
        return ResponseEntity.notFound().build();
    }

}
