package config;

import datamodel.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateFactory {


    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Loan.class);
        StandardServiceRegistryBuilder registryBuilder =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(registryBuilder.build());
    }
}