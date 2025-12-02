package com.example.windows.hibernate.save;


import com.example.windows.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeDao {

    @Autowired
    @Lazy
    private final SessionFactory sessionFactory;

    public  EmployeDao( SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    // save

   //create session Instace object
    private Session getSession(){
   return sessionFactory.getCurrentSession();
    }

    // Save using Hibernate save()
    public void  saveStudent(Employee student) {
        getSession().persist(student);
    }



}
