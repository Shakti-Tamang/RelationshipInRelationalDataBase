package com.nextstep.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;

    private String streetAddress;
    private String zip_code;
    private String state;
    private String city;

    @OneToOne
    @JsonBackReference
    MemberModel memberModel;
}
