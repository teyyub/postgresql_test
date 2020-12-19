package com.example.postgres.dtos;

import lombok.Data;

@Data
public class Person {
    private Long id;
    private String name;
    private String surname;
    private String father;

}
