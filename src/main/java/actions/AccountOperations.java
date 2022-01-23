package actions;
import javax.enterprise.inject.New;
import java.util.Scanner;

public class AccountOperations {

    private String AccNumber;
    private String name;
    private String acc_type; // kredyt czy zwykle konto
    private long balance;

    Scanner scanner = new Scanner(System.in);

    public void openAccount() {
        System.out.print("Enter Account Nr: ");
        AccNumber = scanner.next();
        System.out.println(AccNumber);

        System.out.print("Enter Name: ");
        name = scanner.next();
        System.out.println(name);

        System.out.print("Enter Account type - Private Account or Credit Account: ");
        acc_type = scanner.next();
        System.out.println(acc_type);

        System.out.print("Enter Balance: ");
        balance = scanner.next();
        System.out.println(balance);
    }

    public void showAccount() {
        System.out.println("Type Account" + acc_type);
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + AccNumber);
        System.out.println("Balance: " + balance);
    }

    public void deposit() {
        long NewMoney;
        System.out.println("Enter the amount you want to deposit: ");
        NewMoney = scanner.nextLong();
        balance = balance + NewMoney;
    }

    public void withdrawal() {
        long SubtractMoney;
        System.out.println("Enter the amount you want to withdraw: ");
        SubtractMoney = scanner.nextLong();
        if (balance >= SubtractMoney) {
            balance = balance - SubtractMoney;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + SubtractMoney + "\tTransaction failed...!!" );
        }
    }
}
