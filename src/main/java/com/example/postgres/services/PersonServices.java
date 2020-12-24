package com.example.postgres.services;

import com.example.postgres.dtos.Person;
import com.example.postgres.entities.PersonEntity;
import com.example.postgres.repositories.PersonRepository;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class PersonServices {

//    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    public PersonServices(EntityManager em){
        this.em = em;

    }

    public List<Person> personByParam(String name, String surname, String father){
        List<Person> persons= new ArrayList<>();
        try {
            persons =personRepository.personByParam(name, surname, father);
        }catch (Exception e){}

        return persons;
    }


    public List<Person> personByParamHibernate(String name, String surname, String father) {
        List<PersonEntity> e = test(name,surname,father);
        List<Person> persons= new ArrayList<>();

        return persons;
    }

    private List<PersonEntity> test(String name, String surname, String father){
//        @PersistenceContext
//         EntityManager em;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PersonEntity> cr = cb.createQuery(PersonEntity.class);

        Root<PersonEntity> root = cr.from(PersonEntity.class);

        Predicate authorNamePredicate = cb.equal(root.get("name"), name);
        cr.where(authorNamePredicate);
//        Predicate titlePredicate = cb.like(root.get("surname"), "%" + surname + "%");
//        cr.where(authorNamePredicate, titlePredicate);

        TypedQuery<PersonEntity> query = em.createQuery(cr);

        System.out.println("bazadan gelen deyer " +query.getResultList().size());

        List<PersonEntity> result = query.getResultList();

//        try {
//            persons =personRepository.personByParam(name, surname, father);
//        }catch (Exception e){}

//        return persons;
//        for(PersonEntity p1  : query.getResultList())   {
//            System.out.println("cap et " + p1.toString());
////             Person p = new Person();
////             p.setId(p1.getId());
////             p.setName(p1.getName());
////             p.setSurname(p1.getSurname());
////             p.setFather(p1.getFather());
////             persons.add(p);
//        }
        return query.getResultList();
//    }

}

}
