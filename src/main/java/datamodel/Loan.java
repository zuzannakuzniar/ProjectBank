package datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Loan {

    @Id
    @GeneratedValue
    private long id;
    private float percent;
    private double amount;
    private int months;
    @OneToOne
    private Customer owner;
    private double monthlyPayment;

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

    public void setId(long id) {
        this.id = id;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Loan" +
                "\n id= " + id +
                "\n percent= " + percent +
                "\n amount= " + amount +
                "\n months= " + months +
                "\n owner= {" + owner.getId() +
                "}\n monthlyPayment= " + monthlyPayment;
    }
}
