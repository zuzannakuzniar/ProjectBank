package actions;

import datamodel.Loan;
import service.LoanService;

import javax.inject.Inject;
import java.util.Scanner;

public class LoanOperations {

    @Inject
    LoanService loanService;

    public LoanOperations() {
        this.loanService = new LoanService();
    }

    private Scanner scanner = new Scanner(System.in);


    public void getALoan() {
        Loan loan = new Loan();
        System.out.print("Enter OwnerId: ");
        Long ownerId = scanner.nextLong();
        loan.setOwnerId(ownerId);
        System.out.println(ownerId);

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        loan.setAmount(amount);
        System.out.println(amount);
        int months = scanner.nextInt();

        System.out.println("How many months? 12, 24, 30");
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


        System.out.println("Percent for " + loan.getAmount() + " is " + loan.getPercent());
        System.out.println("Your monthly payment equals :" + loan.getAmount() / loan.getMonths());

        loanService.createLoan(loan);
    }

    public void showloan() {
        System.out.println("Enter loan Id: ");
        long loanId = scanner.nextLong();
        Loan loan = loanService.readLoan(loanId);
        System.out.println(loan.toString());
    }
}
