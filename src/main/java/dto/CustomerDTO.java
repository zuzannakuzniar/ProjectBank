package dto;

import util.UserType;

public class CustomerDTO {

    private String firstName;
    private String lastName;
    private Address address;
    private String phone;
    private String email;
    private UserType userType;


    public CustomerDTO(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
        this.userType = builder.userType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public UserType getUserType() {
        return userType;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private Address address;
        private String phone;
        private String email;
        private UserType userType;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder userType(UserType userType){
            this.userType = userType;
            return this;
        }

        public CustomerDTO build() {
            return new CustomerDTO(this);
        }
    }


}
