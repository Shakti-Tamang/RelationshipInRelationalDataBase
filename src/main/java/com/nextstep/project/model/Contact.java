package com.nextstep.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contact_id;

    private Long contactNumber;


//    remove realtion
    @ManyToOne
    @JsonBackReference
    private Teacher teacher;
}
