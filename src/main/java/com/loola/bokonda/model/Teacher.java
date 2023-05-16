package com.loola.bokonda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.*;

@Entity
//@Table(name = "TEACHER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = AUTO)

    private Long id;

    private String firstName;

    private String lastName;
}
