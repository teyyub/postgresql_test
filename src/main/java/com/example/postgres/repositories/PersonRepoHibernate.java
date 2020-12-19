package com.example.postgres.repositories;

import com.example.postgres.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonRepoHibernate extends JpaRepository<PersonEntity, Long>  ,JpaSpecificationExecutor<PersonEntity> {
}
