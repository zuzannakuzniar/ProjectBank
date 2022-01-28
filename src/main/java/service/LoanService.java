package service;

import config.HibernateFactory;
import datamodel.Loan;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class LoanService {

    @Inject
    HibernateFactory hibernateFactory = new HibernateFactory();

    public LoanService() {
        this.hibernateFactory = new HibernateFactory();
    }

    Session session = hibernateFactory.getSessionFactory().openSession();

    /**
     * method from create loan in database
     * @param loan loan that will be created
     * @return created loan
     */
    public Loan createLoan(Loan loan) {
        Transaction transaction = session.beginTransaction();
        session.save(loan);
        transaction.commit();
        session.close();
        return loan;
    }

    /**
     * method from update loan from database
     * @param loan
     * @return update loan
     */
    public Loan updateLoan(Loan loan) {
        Transaction transaction = session.beginTransaction();
        session.save(loan);
        transaction.commit();
        session.close();
        return loan;
    }

    /**
     * method from reading loan from database
     * @param id loan id
     * @return loan with given id
     */
    public Loan readLoan(long id) {
        Transaction transaction = session.beginTransaction();
        Loan customer = session.find(Loan.class, id);
        transaction.commit();
        session.close();
        return customer;
    }

    /**
     * method for deleting loan from database
     * @param loan loan that wil lbe deleted
     */
    public void deleteLoan(Loan loan) {
        Transaction transaction = session.beginTransaction();
        session.delete(loan);
        transaction.commit();
        session.close();
    }
    
    }
