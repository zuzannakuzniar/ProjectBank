package actions;

import datamodel.Loan;
import service.CustomerService;
import service.LoanService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class LoanOperations implements CreateOperations {

    LoanService loanService;

    CustomerService customerService;

    public LoanOperations() {
        this.loanService = new LoanService();
        this.customerService = new CustomerService();
    }

    private Scanner scanner = new Scanner(System.in);


    /**
     * method for creating a loan
     */
    public void create() {
        Loan loan = new Loan();
        System.out.print("Enter OwnerId: ");
        Long ownerId = scanner.nextLong();
        loan.setOwner(customerService.readCustomer(ownerId));
        System.out.println(ownerId);

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        loan.setAmount(amount);
        System.out.println(amount);

        System.out.println("How many months? 12, 24, 30");
        int months = scanner.nextInt();
        loan.setMonths(months);
        switch (months) {
            case 12:
                loan.setPercent(2.0f);
                break;
            case 24:
                loan.setPercent(4.0f);
                break;
            case 30:
                loan.setPercent(5.0f);
                break;
            default:
                loan.setPercent(4.0f);
        }


        System.out.println("Percent for " + loan.getAmount() + " is " + loan.getPercent() + "%.");
        double monthlyPayment = round(loan.getAmount() / loan.getMonths(), 2);
        loan.setMonthlyPayment(monthlyPayment);
        System.out.println("Your monthly payment equals :" + monthlyPayment);

        loanService.createLoan(loan);
    }

    /**
     * method for returning loan details
     */
    public void showLoan() {
        System.out.println("Enter loan Id: ");
        long loanId = scanner.nextLong();
        Loan loan = loanService.readLoan(loanId);
        System.out.println(loan.toString());
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
