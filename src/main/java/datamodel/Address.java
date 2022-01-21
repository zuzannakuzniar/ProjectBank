package datamodel;

import javax.persistence.Entity;

@Entity
public class Address {

    private Long id;
    private String city;
    private String street;
    private String postcode;


    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostcode() {
        return postcode;
    }

}
