package dto;


import java.math.BigDecimal;

public class AccountDTO {

    private Long id;
    private String accountNumberNumber;
    private Long ownerId;
    private BigDecimal balance;

    public AccountDTO(Builder builder) {
        this.accountNumberNumber = builder.accountNumber;
        this.ownerId = builder.ownerId;
        this.balance = builder.balance;
    }

    public Builder builder(){
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumberNumber() {
        return accountNumberNumber;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public static class Builder {
        private String accountNumber;
        private Long ownerId;
        private BigDecimal balance;

        public AccountDTO.Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public AccountDTO.Builder ownerId(Long ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public AccountDTO.Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public AccountDTO build() {
            return new AccountDTO(this);
        }
    }
}
