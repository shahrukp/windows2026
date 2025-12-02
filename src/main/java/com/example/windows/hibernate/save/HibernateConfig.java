//package com.example.windows.hibernate.save;
//
//import com.example.windows.entity.Employee;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.context.annotation.Bean;
//
//@SpringBootConfiguration
//public class HibernateConfig {
//
//    public void messaege(){
//        System.out.println("hinernae ");
//    }
//    @Bean
//    public SessionFactory sessionFactory() {
//        return new Configuration()
//                .configure() // reads hibernate.cfg.xml (optional)
//                .addAnnotatedClass(Employee.class)
//                .buildSessionFactory();
//
//    }
//}
//
