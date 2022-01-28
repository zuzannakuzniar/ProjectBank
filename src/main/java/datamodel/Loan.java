package datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Loan {

    @Id
    @GeneratedValue
    private long id;
    private float percent;
    private Long accountId;
    private Long amount;
    private int months;

    public static void setNumber(String accNumber) {
    }

    public long getId() {
        return id;
    }

    public float getPercent() {
        return percent;
    }
    public void setPercent(float percent) {
        this.percent = percent;
    }

    public long getAccountId() {
        return accountId;
    }
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getAmount() { return amount; }
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }


    public void setOwnerId(Long ownerId) {
    }

    public void setLoanType(String accType) {
    }

    public void setBalance(double balance) {
    }
}
