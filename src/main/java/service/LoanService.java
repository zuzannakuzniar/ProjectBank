package service;

import config.HibernateFactory;
import datamodel.Loan;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.enterprise.context.Dependent;

import static config.HibernateFactory.getSession;

@Dependent
public class LoanService {

    public LoanService() {
    }

    Session session = getSession();

    /**
     * method for creating loan in database
     * @param loan loan that will be created
     * @return created loan
     */
    public Loan createLoan(Loan loan) {
        session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(loan);
        transaction.commit();
        session.close();
        return loan;
    }

    /**
     * method for updating loan from database
     * @param loan loan to update
     * @return updated loan
     */
    public Loan updateLoan(Loan loan) {
        Transaction transaction = session.beginTransaction();
        session.save(loan);
        transaction.commit();
        session.close();
        return loan;
    }

    /**
     * method for reading loan from database
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
