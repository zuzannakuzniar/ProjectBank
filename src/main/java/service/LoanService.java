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

    public Loan createLoan(Loan loan) {
        Transaction transaction = session.beginTransaction();
        session.save(loan);
        transaction.commit();
        session.close();
        return loan;
    }

    public Loan updateLoan(Loan loan) {
        Transaction transaction = session.beginTransaction();
        session.save(loan);
        transaction.commit();
        session.close();
        return loan;
    }

    public Loan readLoan(long id) {
        Transaction transaction = session.beginTransaction();
        Loan customer = session.find(Loan.class, id);
        transaction.commit();
        session.close();
        return customer;
    }

    public void deleteLoan(Loan loan) {
        Transaction transaction = session.beginTransaction();
        session.delete(loan);
        transaction.commit();
        session.close();
    }
    
    }
