package com.example.postgres.repositories;

import com.example.postgres.dtos.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    @Autowired
    private JdbcTemplate template;
    List<Person> persons = new ArrayList<>();
    public List<Person> personByParam(String name, String surname, String father) throws SQLException{

        System.out.println("called");
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs = null;
       try{
           conn = template.getDataSource().getConnection();
           cs = conn.prepareCall("{? = call grp.getpersons(?,?,?)}");
           cs.registerOutParameter(1, Types.OTHER);
           cs.setString(2,name);
           cs.setString(3,surname);
           cs.setString(4,father);
           cs.execute();
           rs = (ResultSet) cs.getObject(1);
           System.out.println("burdayam");
           while (rs.next())
           {
               System.out.println("var data");
                Person p = new Person();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setSurname(rs.getString("surname"));
                p.setFather(rs.getString("father_name"));
                persons.add(p);
           }
       } catch (SQLException e){
            throw   e;
       } finally {
           new CloseWith(cs, rs, conn).invoke();
       }
        return persons;
    }
    private class CloseWith {
        private CallableStatement cs;
        private ResultSet rs;
        private Connection con;

        public CloseWith(CallableStatement cs, ResultSet rs, Connection con) {
            this.cs = cs;
            this.rs = rs;
            this.con = con;
        }

        public void invoke() throws SQLException {
            if(rs!=null){
                rs.close();
            }
            if(cs!=null){
                cs.close();
            }
            if(con!=null){
                con.close();
            }
        }
    }
}
