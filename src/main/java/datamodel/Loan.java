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
    private double amount;
    private int months;
    private long ownerId;
    private long monthlyPayment;

    public long getId() {
        return id;
    }

    public float getPercent() {
        return percent;
    }
    public void setPercent(float percent) {
        this.percent = percent;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(long monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
