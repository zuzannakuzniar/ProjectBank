package actions;

import datamodel.Account;

import service.AccountService;

import javax.inject.Inject;

import java.util.Scanner;

public class MoneyOperations {

    @Inject
    AccountService accountService;

    Scanner scanner = new Scanner(System.in);

    public MoneyOperations() {
        this.accountService = new AccountService();
    }

    public void getBalance() {
        System.out.println("Enter the account Id: ");
        long accountId = scanner.nextLong();
        Account account = accountService.readAccount(accountId);
        System.out.println("Your account balance: " + account.getBalance());
    }

    public void depositMoney() {
        System.out.println("Enter the account Id: ");
        long accountId = scanner.nextLong();
        System.out.println("Enter the amount you want to deposit: ");
        double newMoney = scanner.nextDouble();

        Account account = accountService.readAccount(accountId);
        double newBalance = account.getBalance() + newMoney;
        account.setBalance(newBalance);
        accountService.updateAccount(account);
        System.out.println(account.toString());

    }

    public void withdrawal() {
        System.out.println("Enter the account Id: ");
        long accountId = scanner.nextLong();
        System.out.println("Enter the amount you want to withdraw: ");
        double subtractMoney = scanner.nextDouble();
        Account account = accountService.readAccount(accountId);
        if (account.getBalance() >= subtractMoney) {
            double balance = account.getBalance() - subtractMoney;
            System.out.println("Balance after withdrawal: " + balance);
            account.setBalance(balance);
            accountService.updateAccount(account);
        } else {
            System.out.println("Your balance is less than " + subtractMoney + "\tTransaction failed...!!");
        }
    }

}
