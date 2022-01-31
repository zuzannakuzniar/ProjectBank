package actions;

import datamodel.Account;
import datamodel.Customer;
import datamodel.Employee;
import datamodel.User;
import exception.IncorrectUserDataException;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import service.AccountService;
import service.CustomerService;
import service.EmployeeService;
import util.UserType;
import util.Validator;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

import static java.util.Objects.nonNull;

public class AccountOperations implements CreateOperations {

    AccountService accountService;
    CustomerService customerService;
    EmployeeService employeeService;
    Validator validator;

    public AccountOperations() {
        this.accountService = new AccountService();
        this.customerService = new CustomerService();
        this.employeeService = new EmployeeService();
        this.validator = new Validator();
    }

    Scanner scanner = new Scanner(System.in);

    /**
     * method for opening account
     */
    public void create() {
        Account account = new Account();
        System.out.print("Your account nr: ");
        String accNumber = generateAccountNumber();
        account.setNumber(accNumber);
        System.out.println(accNumber);

        System.out.print("Enter OwnerId: ");
        long ownerId = scanner.nextLong();
        account.setOwner(customerService.readCustomer(ownerId));
        System.out.println(ownerId);

        account.setAccountType("Private Account");

        System.out.print("Enter Balance: ");
        double balance = scanner.nextDouble();
        account.setBalance(balance);
        System.out.println(balance);

        accountService.createAccount(account);
    }


    /**
     * method for creating user
     */
    public void createUser() {
        System.out.println("Enter user type: Customer | Employee");
        String userType = scanner.next();
        User user;
        if (userType.equalsIgnoreCase("Employee")) {
            user = createEmployee();
        }
        if (userType.equalsIgnoreCase("Customer")) {
            user = createCustomer();
        }

        System.out.println("User created");
        scanner.reset();
    }

    /**
     * method for creating customer
     * @return created customer as user
     */
    private User createCustomer() {
        Customer customer = new Customer();

        System.out.print("Enter login: ");
        String login = getLogin();
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
        customer.setLastName(lastName);
        System.out.println(lastName);

        String email = getEmail();
        customer.setEmail(email);
        System.out.println(email);

        System.out.print("Enter address: ");
        String address = scanner.next();
        customer.setAddress(address);
        System.out.println(address);

        System.out.print("Enter phone: +xx xxx-xxx-xxx");
        String phone = scanner.next();
        String validatePhone = validator.validatePhone(phone);
        customer.setPhone(validatePhone);
        System.out.println(validatePhone);

        customer.setUserType(UserType.CUSTOMER);
        customerService.createCustomer(customer);
        return customer;
    }

    /**
     * method for getting login and checking if it's taken
     *
     * @return login that can be saved into database
     */
    private String getLogin() {
        String login = scanner.next();
        boolean taken = isLoginTaken(login);
        do {
            if (taken) {
                System.out.println("Login is taken. Try again.");
                login = scanner.next();
            } else {
                taken = false;
            }
        } while (taken);
        return login;
    }

    /**
     * method for checking if login is taken
     *
     * @param login login that will be checked
     * @return true if login is taken, false if it's not
     */
    private boolean isLoginTaken(String login) {
        return nonNull(customerService.readCustomerByLogin(login));
    }

    /**
     * method for getting email
     */
    private String getEmail() {
        System.out.print("Enter email: ");
        String email = scanner.next();
        String validatedEmail = validator.validateEmail(email);
        return validatedEmail;
    }

    /**
     * method for creating employee
     *
     * @return created employee as user
     */
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
        employee.setLastName(lastName);
        System.out.println(lastName);

        String email = getEmail();
        employee.setEmail(email);
        System.out.println(email);

        System.out.print("Enter position: ");
        String position = scanner.next();
        employee.setPosition(position);
        System.out.println(position);

        Scanner reset = scanner.reset();

        System.out.print("Enter salary: ");
        double salary = reset.nextDouble();
        employee.setSalary(salary);
        System.out.println(salary);

        employee.setUserType(UserType.EMPLOYEE);

        employeeService.createEmployee(employee);
        return employee;

    }

    /**
     * method for showing account details
     */
    public void showAccount() {
        System.out.println("Enter account Id: ");
        long accountId = scanner.nextLong();
        Account account = accountService.readAccount(accountId);
        System.out.println(account.toString());
    }

    /**
     * method for loggin in
     */
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

    /**
     * method for getting account details as .txt
     */
    public void getAccountAsFile() {
        System.out.println("Enter accountId: ");
        long accountId = scanner.nextLong();
        try {
            File file = new File("Account" + accountId + "_" + LocalDateTime.now() + ".txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            Account account = accountService.readAccount(accountId);
            fw.write(account.toString());
            fw.close();
            System.out.println("Account imported correctly.");

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    /**
     * method for generating account number
     *
     * @return account number
     */
    private String generateAccountNumber() {
        Iban iban = new Iban.Builder()
                .countryCode(CountryCode.PL)
                .bankCode("199")
                .buildRandom();
        return iban.getAccountNumber();
    }

}
