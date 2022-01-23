package service;

import config.HibernateFactory;
import datamodel.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.inject.Inject;


public class CustomerService {

    @Inject
    HibernateFactory hibernateFactory;

    Session session = hibernateFactory.getSessionFactory().openSession();


    public Customer createCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
        return customer;
    }

    public Customer readCustomer(long id) {
        Transaction transaction = session.beginTransaction();
        Customer customer = session.find(Customer.class, id);
        transaction.commit();
        session.close();
        return customer;
    }

    public void updateCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    public void deleteCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        session.close();
    }

}
