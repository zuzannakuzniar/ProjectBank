package datamodel;

import javax.persistence.*;

@Entity
public class Customer extends User{

    private String address;
    private String phone;
    private Long accountId;

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
