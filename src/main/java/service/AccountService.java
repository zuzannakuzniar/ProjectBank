package service;

import config.HibernateFactory;
import datamodel.Account;
import datamodel.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.inject.Inject;

public class AccountService {

    @Inject
    HibernateFactory hibernateFactory;

    Session session = hibernateFactory.getSessionFactory().openSession();

    public Account createAccount(Account account) {
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
        return account;
    }

    public Account readAccount(long id) {
        Transaction transaction = session.beginTransaction();
        Account account = session.find(Account.class, id);
        transaction.commit();
        session.close();
        return account;
    }

    public void updateAccount(Account account) {
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }

    public void deleteAccount(Account account) {
        Transaction transaction = session.beginTransaction();
        session.delete(account);
        transaction.commit();
        session.close();
    }

}
