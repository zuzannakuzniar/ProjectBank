package service;

import config.HibernateFactory;
import datamodel.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class EmployeeService {

    @Inject
    HibernateFactory hibernateFactory = new HibernateFactory();

    public EmployeeService() {
        this.hibernateFactory = new HibernateFactory();
    }

    Session session = hibernateFactory.getSessionFactory().openSession();

    public Employee createEmployee(Employee employee) {
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
        return employee;
    }

    public Employee readEmployee(long id) {
        Transaction transaction = session.beginTransaction();
        Employee customer = session.find(Employee.class, id);
        transaction.commit();
        session.close();
        return customer;
    }

    public void deleteEmployee(Employee employee) {
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();
    }

}
