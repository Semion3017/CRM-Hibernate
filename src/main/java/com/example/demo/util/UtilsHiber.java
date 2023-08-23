package com.example.demo.util;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Post;
import com.example.demo.entity.Project;

public class UtilsHiber {
	public static SessionFactory buildSessionFactory() {
        try {
          
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "org.postgresql.Driver");
            properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/CRM");
            properties.put(Environment.USER, "postgres");
            properties.put(Environment.PASS, "2017546");
            properties.put(Environment.FORMAT_SQL, "true");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.FORMAT_SQL, "true");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            properties.put(Environment.POOL_SIZE, "5");
           
            return new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Project.class)
                .buildSessionFactory();
            
        } catch (Throwable ex) {
            System.err.println("build SeesionFactory failed :" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
	
	public static Session getSession() {
		SessionFactory sessionFactory = UtilsHiber.buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}
}
