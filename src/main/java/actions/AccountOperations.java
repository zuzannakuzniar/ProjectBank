package actions;

import datamodel.Account;
import datamodel.Customer;
import datamodel.Employee;
import datamodel.User;
import service.AccountService;
import service.CustomerService;
import service.EmployeeService;
import util.UserType;
import util.Validator;

import javax.inject.Inject;
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

    public void openAccount() {
        Account account = new Account();
        System.out.print("Enter Account Nr: ");
        String accNumber = scanner.next();
        account.setNumber(accNumber);
        System.out.println(accNumber);

        System.out.print("Enter OwnerId: ");
        Long ownerId = scanner.nextLong();
        account.setOwnerId(ownerId);
        System.out.println(ownerId);

        System.out.print("Enter Account type - Private Account or Credit Account: ");
        String accType = scanner.next();
        account.setAccountType(accType);
        System.out.println(accType);

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

        System.out.print("Enter email: ");
        String email = scanner.next();
        String validatedEmail = validator.validateEmail(email);
        customer.setEmail(validatedEmail);
        System.out.println(validatedEmail);

        System.out.print("Enter address: ");
        String address = scanner.next();
        customer.setAddress(address);
        System.out.println(address);

        System.out.print("Enter phone: ");
        String phone = scanner.next();
        customer.setPhone(phone);
        System.out.println(phone);

        customerService.createCustomer(customer);
        return customer;
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

        System.out.print("Enter email: ");
        String email = scanner.next();
        String validatedEmail = validator.validateEmail(email);
        employee.setEmail(validatedEmail);
        System.out.println(validatedEmail);

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

}
