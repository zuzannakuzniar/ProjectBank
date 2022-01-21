package datamodel;


import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Account {

    private Long id;
    private String number;
    private Long ownerId;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
