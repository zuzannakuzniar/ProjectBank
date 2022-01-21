package datamodel;

import javax.persistence.Entity;

@Entity
public class Customer extends User{

    private Long customerId;
    private Address address;
    private String phone;
    private Long accountId;

    public Long getCustomerId() {
        return customerId;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public long getAccountId() {
        return accountId;
    }
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
