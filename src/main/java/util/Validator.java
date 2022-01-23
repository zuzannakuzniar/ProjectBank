package util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    public String validateEmail(String email) {
        Scanner scanner = new Scanner(System.in);
        String correctEmail = email;
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        boolean matches = matcher.find();
        if (matches) {
            System.out.println("Email correct: ");
        } else {
            System.out.println("Email incorrect! Try again");
            correctEmail = scanner.next();
        }

        return correctEmail;
    }
}
