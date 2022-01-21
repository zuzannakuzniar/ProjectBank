package datamodel;

import javax.persistence.Entity;

@Entity
public class Deposit {

    private float percent;
    private Long accountId;
    private Long amount;
    private int months;

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

    public int getMonts() {return months;}
    public void setMonts(int months) {
        this.months = months;
    }


}
