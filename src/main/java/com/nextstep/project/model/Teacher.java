package com.nextstep.project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacher_id;

    private String username;

    private int age;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Contact>teacherContact;
}
