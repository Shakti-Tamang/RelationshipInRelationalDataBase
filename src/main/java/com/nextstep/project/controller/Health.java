package com.nextstep.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health {

    @PreAuthorize("hasAuthority('User') || hasAuthority('Admin')")
    @GetMapping("/getHealth")
    public ResponseEntity<String>get(){
        return  new ResponseEntity<>("Success happen", HttpStatus.OK);
    }
}
