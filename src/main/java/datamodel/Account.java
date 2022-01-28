package datamodel;


import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    private String number;
    private Long ownerId;
    private double balance;
    private String accountType;

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Your account: " +
                "\n id=" + id +
                "\n number='" + number +
                "\n ownerId=" + ownerId +
                "\n balance=" + balance +
                "\n accountType='" + accountType;
    }
}
