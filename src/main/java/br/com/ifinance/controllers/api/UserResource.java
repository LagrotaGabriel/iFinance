package br.com.ifinance.controllers.api;

import br.com.ifinance.models.entities.User;
import br.com.ifinance.services.UserService;
import br.com.ifinance.validations.UserValidation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Api(value = "iFinance API - User Resource")
@RestController
@RequestMapping("api/user")
public class UserResource {

    @Autowired
    UserService userService;

    UserValidation userValidation = new UserValidation();

    @RequestMapping("new")
    @Produces({MediaType.APPLICATION_JSON, "application/json"})
    @ApiOperation(value = "Creates a new user in data base")
    public ResponseEntity<User> createUser(@RequestBody User user){
        if(userValidation.userValidation(user)) ResponseEntity.ok().body(userService.create(user));
        return ResponseEntity.badRequest().build();
    }

}
