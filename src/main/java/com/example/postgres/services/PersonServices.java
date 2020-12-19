package com.example.postgres.services;

import com.example.postgres.dtos.Person;
import com.example.postgres.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PersonServices {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> personByParam(String name, String surname, String father){
        List<Person> persons= new ArrayList<>();
        try {
            persons =personRepository.personByParam(name, surname, father);
        }catch (Exception e){}

        return persons;
    }
}
