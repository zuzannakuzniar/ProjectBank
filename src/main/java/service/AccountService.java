package service;

import config.HibernateFactory;
import datamodel.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.enterprise.context.Dependent;

import static config.HibernateFactory.getSession;

@Dependent
public class AccountService {

    public AccountService() {
    }

    private Session session = getSession();


    /**
     * method for creating account in database
     *
     * @param account account that will be created
     * @return created account
     */
    public Account createAccount(Account account) {
        this.session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
        return account;
    }

    /**
     * method for reading account from database
     *
     * @param id account id
     * @return account with given id
     */
    public Account readAccount(long id) {
        Transaction transaction = session.beginTransaction();
        Account account = session.find(Account.class, id);
        transaction.commit();
        session.close();
        return account;
    }

    /**
     * method for updating account in database
     *
     * @param account account that will be created
     */
    public void updateAccount(Account account) {
        session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }

    /**
     * method for deleting account from database
     *
     * @param account account that will be deleted
     */
    public void deleteAccount(Account account) {
        Transaction transaction = session.beginTransaction();
        session.delete(account);
        transaction.commit();
        session.close();
    }

}
