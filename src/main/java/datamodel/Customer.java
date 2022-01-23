package datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer extends User{

    @Id
    @GeneratedValue
    private Long customerId;
    private String address;
    private String phone;
    @OneToMany
    private List<Long> accountId;

    public Long getCustomerId() {
        return customerId;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<Long> getAccountId() {
        return accountId;
    }

    public void setAccountId(List<Long> accountId) {
        this.accountId = accountId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
