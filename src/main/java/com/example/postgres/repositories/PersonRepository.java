package com.example.postgres.repositories;

import com.example.postgres.dtos.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
    public ResponseEntity<?> personByParam(){

        return ResponseEntity.ok().body("");
    }
}
