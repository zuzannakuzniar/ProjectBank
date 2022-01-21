package dto;

import util.UserType;

public class UserInDTO {

    private String firstName;
    private String lastName;
    private String email;
    private UserType userType;


    public UserInDTO(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.userType = builder.userType;
    }

    public Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private String email;
        private UserType userType;

        public UserInDTO.Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserInDTO.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserInDTO.Builder email(String email) {
            this.email = email;
            return this;
        }

        public UserInDTO.Builder userType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public UserInDTO build() {
            return new UserInDTO(this);
        }
    }
}
