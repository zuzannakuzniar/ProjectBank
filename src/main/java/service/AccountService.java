package service;

import config.HibernateFactory;
import datamodel.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class AccountService {

    @Inject
    HibernateFactory hibernateFactory = new HibernateFactory();

    public AccountService() {
    }

    private Session session = hibernateFactory.getSessionFactory().openSession();

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
