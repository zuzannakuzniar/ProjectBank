import actions.AccountOperations;
import util.Validator;

import java.util.Scanner;

public class RunApplication {

    public static void main(String[] args) {

        Validator validator = new Validator();
        Scanner scanner = new Scanner(System.in);
        validator.validateEmail(scanner.next());
        AccountOperations accountOperations = new AccountOperations();
        accountOperations.createUser();
    }
}
