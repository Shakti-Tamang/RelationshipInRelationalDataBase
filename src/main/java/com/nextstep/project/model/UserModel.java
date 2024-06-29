package com.nextstep.project.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Role is mandatory")
    @NotNull(message = "Role should not be blank")
    private String role;

    @NotBlank(message = "Name is mandatory")
    @NotNull(message = "Name should not be blank")
    private String name;

    
//    In model ue use username always
    @NotBlank(message = "Name is mandatory")
    @NotNull(message = "Name should not be blank")
    private String username;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "password is mandatory")
    @NotNull(message = "password should not be blank")
   private String password;

    @NotBlank(message = "password is mandatory")
    @NotNull(message = "confirmPassword should not be blank")
   private String ConfirmPassword;

    @Min(value = 100000000L, message = "Contact should contain a minimum of 10 numbers")
    private long contact;


}
