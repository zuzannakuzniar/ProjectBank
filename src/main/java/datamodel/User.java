package datamodel;

import org.hibernate.annotations.NaturalId;
import util.UserType;

import javax.persistence.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private UserType userType;
    @OneToOne
    private Account account;
    @OneToOne
    private Loan loan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "User: " +
                "\nid= " + id +
                "\nlogin= " + login +
                "\nfirstName= " + firstName +
                "\nlastName= " + lastName +
                "\nuserType= " + userType;
    }
}
