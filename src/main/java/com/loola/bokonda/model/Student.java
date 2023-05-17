package com.loola.bokonda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = AUTO)

    private Long id;

    private String fistName;

    private String lastName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLAZZ_ID")
    private Clazz clazz;

}
