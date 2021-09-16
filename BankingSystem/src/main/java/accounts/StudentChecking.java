package accounts;

import enums.AccountStatus;

import java.math.BigDecimal;

public class StudentChecking extends Account{

    private String secretKey;
    private String creationDate;
    private AccountStatus status;

    public StudentChecking(BigDecimal balance, String primaryOwner, String secretKey, String creationDate, AccountStatus status) {
        super(balance, primaryOwner);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = status;
    }

    public StudentChecking(BigDecimal balance, String primaryOwner, String secondaryOwner, String secretKey, String creationDate, AccountStatus status) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = status;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
