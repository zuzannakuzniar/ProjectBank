package util;

import datamodel.Customer;
import exception.IncorrectUserDataException;
import service.CustomerService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Dependent
public class Validator {

    @Inject
    CustomerService customerService;

    private static final String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|" +
            "\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|" +
            "\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final String PHONE_NR_PATTERN = "\\+?|\\d+\\d\\s?\\d{0,4}\\-\\d{0,3}\\-\\d{0,3}";

    public Validator() {
        this.customerService = new CustomerService();
    }

    public String validateEmail(String email) {
        Scanner scanner = new Scanner(System.in);
        String correctEmail = email;
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        boolean matches = matcher.find();
        if (matches) {
            System.out.println("Email correct. ");
        } else {
            System.out.println("Email incorrect! Try again");
            correctEmail = scanner.next();
        }

        return correctEmail;
    }

    public String validatePhone(String phone) {
        Scanner scanner = new Scanner(System.in);
        String correctPhone = phone;
        Pattern pattern = Pattern.compile(PHONE_NR_PATTERN);
        Matcher matcher = pattern.matcher(phone);
        boolean matches = matcher.find();
        if (matches) {
            System.out.println("Phone number correct. ");
        } else {
            System.out.println("Phone number incorrect! Try again with pattern +xx xxx-xxx-xxx");
            correctPhone = scanner.next();
        }

        return correctPhone;
    }

    public Customer validateLogin(String login) throws IncorrectUserDataException {
        Optional<Customer> customer = Optional.ofNullable(customerService.readCustomerByLogin(login));
        if (!customer.isPresent()) {
            throw new IncorrectUserDataException("User with login" + login + "not found.");
        }
        return customer.get();
    }

    public void validatePassword(String password, Customer customer) throws IncorrectUserDataException {
        if (customer.getPassword().equals(password)) {
            System.out.println("You are now logged in.");
        } else {
            throw new IncorrectUserDataException("Password incorrect!");
        }
    }
}
