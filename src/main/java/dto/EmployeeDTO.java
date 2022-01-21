package dto;

import util.UserType;

import java.math.BigDecimal;

public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private String email;
    private Long employeeId;
    private String position;
    private BigDecimal salary;
    private UserType userType;

    public EmployeeDTO(Builder builder) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.employeeId = employeeId;
        this.position = position;
        this.salary = salary;
        this.userType = userType;
    }

    private Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private Long employeeId;
        private String position;
        private BigDecimal salary;
        private UserType userType;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder employeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder salary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public Builder userType(UserType userType){
            this.userType = userType;
            return this;
        }

        public EmployeeDTO build() {
            return new EmployeeDTO(this);
        }
    }
    }
