import actions.AccountOperations;
import actions.LoanOperations;
import actions.MoneyOperations;

public class RunApplication {

    public static void main(String[] args) {

        AccountOperations accountOperations = new AccountOperations();
//        accountOperations.create();
//       accountOperations.openAccount();
//        accountOperations.login();
//        accountOperations.showAccount();
//        accountOperations.getAccountAsFile();

        LoanOperations loanOperations = new LoanOperations();
//        loanOperations.create();
//        loanOperations.showLoan();

        MoneyOperations moneyOperations = new MoneyOperations();
//        moneyOperations.getBalance();
//        moneyOperations.depositMoney();
        moneyOperations.withdrawal();
    }
}
