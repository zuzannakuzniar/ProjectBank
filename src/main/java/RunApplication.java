import actions.AccountOperations;

public class RunApplication {

    public static void main(String[] args) {

        AccountOperations accountOperations = new AccountOperations();
//        accountOperations.createUser();
        accountOperations.login();
    }
}
