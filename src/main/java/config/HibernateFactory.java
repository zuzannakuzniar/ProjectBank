package config;

import datamodel.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateFactory {


//    public SessionFactory getSessionFactory() {
//        Configuration configuration = new Configuration();
//        configuration.configure("hibernate.cfg.xml");
//        configuration.addAnnotatedClass(Customer.class);
//        configuration.addAnnotatedClass(Account.class);
//        configuration.addAnnotatedClass(User.class);
//        configuration.addAnnotatedClass(Employee.class);
//        configuration.addAnnotatedClass(Loan.class);
//        StandardServiceRegistryBuilder registryBuilder =
//                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//        return configuration.buildSessionFactory(registryBuilder.build());
//    }

    private static SessionFactory sessionFactory;
    private static Configuration configuration = new Configuration();


    private HibernateFactory() {
    }

    static {
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        if (sessionFactory != null) {
            return sessionFactory.getCurrentSession();
        }
        return configuration.buildSessionFactory().openSession();
    }

}