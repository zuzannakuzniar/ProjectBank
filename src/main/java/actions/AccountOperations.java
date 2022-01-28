package actions;

import datamodel.Account;
import datamodel.Customer;
import datamodel.Employee;
import datamodel.User;
import exception.IncorrectUserDataException;
import org.iban4j.Bic;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import service.AccountService;
import service.CustomerService;
import service.EmployeeService;
import util.UserType;
import util.Validator;

import javax.inject.Inject;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;


public class AccountOperations {

    @Inject
    AccountService accountService;
    @Inject
    CustomerService customerService;
    @Inject
    EmployeeService employeeService;
    @Inject
    Validator validator;

    public AccountOperations() {
        this.accountService = new AccountService();
        this.customerService = new CustomerService();
        this.employeeService = new EmployeeService();
        this.validator = new Validator();
    }

    Scanner scanner = new Scanner(System.in);

    /**
     * Opening account
     */
    public void openAccount() {
        Account account = new Account();
        System.out.print("Your account nr: ");
        String accNumber = generateAccountNumber();
        account.setNumber(accNumber);
        System.out.println(accNumber);

        System.out.print("Enter OwnerId: ");
        Long ownerId = scanner.nextLong();
        account.setOwnerId(ownerId);
        System.out.println(ownerId);

        account.setAccountType("Private Account");

        scanner.reset();

        System.out.print("Enter Balance: ");
        double balance = scanner.nextDouble();
        account.setBalance(balance);
        System.out.println(balance);

        accountService.createAccount(account);
    }


    public void createUser() {
        System.out.println("Enter user type: Customer | Employee");
        String userType = scanner.next();
        User user;
        switch (userType) {
            case "Employee":
                user = createEmployee();
                user.setUserType(UserType.EMPLOYEE);
                break;
            case "Customer":
                user = createCustomer();
                user.setUserType(UserType.CUSTOMER);
                user.setId(null);
                break;
        }

        System.out.println("User created");
        scanner.reset();
    }

    private User createCustomer() {
        Customer customer = new Customer();
        System.out.print("Enter login: ");
        String login = scanner.next();
        customer.setLogin(login);
        System.out.println(login);

        System.out.print("Enter password: ");
        String password = scanner.next();
        customer.setPassword(password);
        System.out.println("Password set");

        System.out.print("Enter firstName: ");
        String firstname = scanner.next();
        customer.setFirstName(firstname);
        System.out.println(firstname);

        System.out.print("Enter lastName: ");
        String lastName = scanner.next();
        customer.setFirstName(lastName);
        System.out.println(lastName);

        getAndSetEmail(customer);

        System.out.print("Enter address: ");
        String address = scanner.next();
        customer.setAddress(address);
        System.out.println(address);

        getAndSetPhoneNumber(customer);

        customerService.createCustomer(customer);
        return customer;
    }

    private void getAndSetEmail(User user) {
        System.out.print("Enter email: ");
        String email = scanner.next();
        String validatedEmail = validator.validateEmail(email);
        user.setEmail(validatedEmail);
        System.out.println(validatedEmail);
    }

    private void getAndSetPhoneNumber(Customer customer) {
        System.out.print("Enter phone: +xx xxx-xxx-xxx");
        String phone = scanner.next();
        String validatedPhone = validator.validatePhone(phone);
        customer.setPhone(validatedPhone);
        System.out.println(validatedPhone);
    }

    private User createEmployee() {
        Employee employee = new Employee();
        System.out.print("Enter login: ");
        String login = scanner.next();
        employee.setLogin(login);
        System.out.println(login);

        System.out.print("Enter password: ");
        String password = scanner.next();
        employee.setPassword(password);
        System.out.println("Password set");

        System.out.print("Enter firstName: ");
        String firstname = scanner.next();
        employee.setFirstName(firstname);
        System.out.println(firstname);

        System.out.print("Enter lastName: ");
        String lastName = scanner.next();
        employee.setFirstName(lastName);
        System.out.println(lastName);

        getAndSetEmail(employee);

        System.out.print("Enter position: ");
        String position = scanner.next();
        employee.setPosition(position);
        System.out.println(position);

        employeeService.createEmployee(employee);
        return employee;

    }

    public void showAccount() {
        System.out.println("Enter account Id: ");
        long accountId = scanner.nextLong();
        Account account = accountService.readAccount(accountId);
        System.out.println(account.toString());
    }

    public void login() {
        System.out.println("Enter login: ");
        try {
            Customer customer = validator.validateLogin(scanner.next());
            System.out.println("Enter password: ");
            validator.validatePassword(scanner.next(), customer);
        } catch (IncorrectUserDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAccountAsFile(long accountId) {
        try {
            File file = new File("Account" + accountId + ".txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            Account account = accountService.readAccount(accountId);
            bw.write(account.toString());
            System.out.println("Account imported correctly.");

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    private String generateAccountNumber() {
        Iban iban = new Iban.Builder()
                .countryCode(CountryCode.PL)
                .bankCode("199")
                .buildRandom();
        return iban.getAccountNumber();
    }

}
