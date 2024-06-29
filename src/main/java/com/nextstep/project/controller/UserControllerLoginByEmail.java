package com.nextstep.project.controller;

import com.nextstep.project.model.UserModel;
import com.nextstep.project.service.JwtService;
import com.nextstep.project.service.UserDetailsServiceImpl;
import com.nextstep.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@Valid
@RequestMapping("/save")
public class UserControllerLoginByEmail {

    @Autowired
    UserService userService;
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @PostMapping("/StoreUser")
    public ResponseEntity<String>saveUser(@Valid @RequestBody UserModel userModel){
        userService.saveTeacher(userModel);
        return new ResponseEntity<>("Successfully Saves User", HttpStatus.OK);
    }


    @PostMapping("/logInForUser")
    public ResponseEntity<String>logIn( @RequestBody UserModel userModel){
        try {
            // Find username by email
            String username = userDetailsService.findUsernameByEmail(userModel.getEmail());

            // Authenticate using the username
            Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(username, userModel.getPassword()));

            if (authentication.isAuthenticated()) {
                String token = jwtService.GenerateToken(username);
                return new ResponseEntity<>(token, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}
