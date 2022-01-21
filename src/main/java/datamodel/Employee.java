package datamodel;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Employee extends User {

    private Long employeeId;
    private String position;
    private BigDecimal salary;

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
