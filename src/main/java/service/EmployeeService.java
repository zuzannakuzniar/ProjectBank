package service;

import datamodel.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static config.HibernateFactory.getSession;

public class EmployeeService {

    Session session = getSession();

    /**
     * method for creating employee in databse
     * @param employee employee that will be created
     * @return created employee
     */
    public Employee createEmployee(Employee employee) {
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
        return employee;
    }


    /**
     * method for updating employee from database
     * @param employee employee to update
     * @return update employee
     */
    public Employee updateEmployee(Employee employee) {
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
        return employee;
    }

    /**
     * method for reading employee from database
     * @param id employee id
     * @return read employe
     */
    public Employee readEmployee(long id) {
        Transaction transaction = session.beginTransaction();
        Employee customer = session.find(Employee.class, id);
        transaction.commit();
        session.close();
        return customer;
    }

    /**
     * method for deleting employee from database
     * @param employee account that will b e deleted
     */
    public void deleteEmployee(Employee employee) {
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();
    }

}
