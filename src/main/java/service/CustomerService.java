package service;

import config.HibernateFactory;
import datamodel.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class CustomerService {

    @Inject
    HibernateFactory hibernateFactory = new HibernateFactory();

    public CustomerService() {
    }

    Session session = hibernateFactory.getSessionFactory().openSession();

    /**
     * method for creating customer in database
     *
     * @param customer customer to create
     * @return created customer
     */
    public Customer createCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
        return customer;
    }

    /**
     * method for reading customer from database
     * @param id customer id
     * @return customer with given id
     */
    public Customer readCustomer(long id) {
        Transaction transaction = session.beginTransaction();
        Customer customer = session.find(Customer.class, id);
        transaction.commit();
        session.close();
        return customer;
    }

    /**
     * method for reading customer from database
     * @param login customer login
     * @return customer with given login
     */
    public Customer readCustomerByLogin(String login) {
        Transaction transaction = session.beginTransaction();
        Customer customer = session.byNaturalId(Customer.class).using("login", login).load();
        transaction.commit();
        session.close();
        return customer;
    }

    /**
     * method for updating customer in database
     * @param customer customer to update
     */
    public void updateCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    /**
     * method for deleting cutomer from database
     * @param customer customer that will be deleted
     */
    public void deleteCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        session.close();
    }

}
