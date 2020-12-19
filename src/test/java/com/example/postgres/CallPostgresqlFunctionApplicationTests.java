package com.example.postgres;

import com.example.postgres.dtos.Person;
import com.example.postgres.services.PersonServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CallPostgresqlFunctionApplicationTests {

	@Autowired
	private PersonServices personServices;
	@Test
	void contextLoads() {
	}

	@Test
    void testByName(){
        List<Person> t = personServices.personByParam("azer",null,null);
	    assertEquals(t.size(),3);
    }

    @Test
    void testByName1(){
        List<Person> t = personServices.personByParam("Azar",null,null);
        assertEquals(t.size(),1);
    }

    @Test
    void testByName2(){
        List<Person> t = personServices.personByParam("nigar",null,null);
        assertEquals(t.size(),1);
    }

    @Test
    void testBySurname(){
        List<Person> t = personServices.personByParam(null,"ekberli",null);
        assertEquals(t.size(),1);
    }

    @Test
    void testByNameSurname(){
        List<Person> t = personServices.personByParam("azer","ekberli",null);
        assertEquals(t.size(),1);
    }


    @Test
    void testByNameHibernate(){
        List<Person> t = personServices.personByParamHibernate("azer",null,null);
        assertEquals(3,t.size());
    }

}
