package accounts;

import enums.AccountStatus;

import java.math.BigDecimal;

public class Savings extends Account{

    private String secretKey;
    private BigDecimal minimumBalance;
    private String creationDate;
    private AccountStatus status;
    private BigDecimal interestRate;

    public Savings(BigDecimal balance, String primaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status, BigDecimal interestRate) {
        super(balance, primaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.creationDate = creationDate;
        this.status = status;
        setInterestRate(interestRate);
    }

    public Savings(BigDecimal balance, String primaryOwner, String secondaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.creationDate = creationDate;
        this.status = status;
        setInterestRate(interestRate);
    }

    public Savings(BigDecimal balance, String primaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status) {
        super(balance, primaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.creationDate = creationDate;
        this.status = status;
        setInterestRate(new BigDecimal("0.025"));
    }

    public Savings(BigDecimal balance, String primaryOwner, String secondaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.creationDate = creationDate;
        this.status = status;
        setInterestRate(new BigDecimal("0.025"));
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
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

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if (interestRate.compareTo(new BigDecimal("0.5")) <= 0)
            this.interestRate = interestRate;
        else
            this.interestRate = new BigDecimal("0.5");
    }
}
