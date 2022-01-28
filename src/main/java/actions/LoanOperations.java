package actions;

import datamodel.Loan;
import datamodel.Customer;
import datamodel.Employee;
import datamodel.User;
import exception.IncorrectUserDataException;
import service.LoanService;
import service.CustomerService;
import service.EmployeeService;
import util.UserType;
import util.Validator;

import javax.inject.Inject;
import java.util.Scanner;


public class LoanOperations {

    @Inject
    LoanService loanService;
    @Inject
    CustomerService customerService;
    @Inject
    EmployeeService employeeService;
    @Inject
    Validator validator;

    public LoanOperations() {
        this.loanService = new LoanService();
        this.customerService = new CustomerService();
        this.employeeService = new EmployeeService();
        this.validator = new Validator();
    }

    Scanner scanner = new Scanner(System.in);

    public void openloan() {
        Loan loan = new Loan();
        System.out.print("Enter loan Nr: ");
        String accNumber = scanner.next();
        Loan.setNumber(accNumber);
        System.out.println(accNumber);

        System.out.print("Enter OwnerId: ");
        Long ownerId = scanner.nextLong();
        loan.setOwnerId(ownerId);
        System.out.println(ownerId);

        System.out.print("Enter loan type - Private loan or Credit loan: ");
        String accType = scanner.next();
        loan.setLoanType(accType);
        System.out.println(accType);

        System.out.print("Enter Balance: ");
        double balance = scanner.nextDouble();
        loan.setBalance(balance);
        System.out.println(balance);

        loanService.createLoan(loan);
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

    public void showloan() {
        System.out.println("Enter loan Id: ");
        long loanId = scanner.nextLong();
        Loan loan = loanService.readLoan(loanId);
        System.out.println(loan.toString());
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

}