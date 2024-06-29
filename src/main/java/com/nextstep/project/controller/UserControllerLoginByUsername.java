package com.nextstep.project.controller;

import com.nextstep.project.model.UserModel;
import com.nextstep.project.service.JwtService;
import com.nextstep.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/Shakti")

public class UserControllerLoginByUsername {

    @Autowired
UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    JwtService jwtService;

    @PostMapping("/saveUser")
    public ResponseEntity<String>saveUser(@Valid @RequestBody UserModel userModel){
   userService.saveTeacher(userModel);
   return new ResponseEntity<>("Successfully Saves User", HttpStatus.OK);
    }

    @PostMapping("/logIn")
    public ResponseEntity<String>logInUser( @RequestBody UserModel userModel){
        Authentication authenticationManager1=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userModel.getUsername(),userModel.getPassword()));
if(authenticationManager1.isAuthenticated()){
String token=jwtService.GenerateToken(userModel.getUsername());
return new ResponseEntity<>(token,HttpStatus.OK);
}

else{
return new ResponseEntity<>("Invalid credential",HttpStatus.UNAUTHORIZED);
}
    }

}
