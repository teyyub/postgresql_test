package com.example.postgres.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "grp_personal_information",schema = "grp")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String father;
}
