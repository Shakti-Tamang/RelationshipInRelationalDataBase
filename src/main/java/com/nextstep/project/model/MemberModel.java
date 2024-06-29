package com.nextstep.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MemberModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int member_id;
     private String email;
     private String password;


//     it link two table if yauta deltebhayo arkoni delete
     @OneToOne(cascade = CascadeType.ALL)

//     manage infinite loop
      @JsonManagedReference
     Address memberAddress;


}
