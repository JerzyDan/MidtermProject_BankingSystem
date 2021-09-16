package accounts;

import enums.AccountStatus;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.math.BigDecimal;

public class Savings extends Account{

    private String secretKey;
    private BigDecimal minimumBalance;
    private LocalDate creationDate;
    private AccountStatus status;
    private BigDecimal interestRate;
    private LocalDate interestDate;

    public Savings(BigDecimal balance, String primaryOwner, String secretKey, BigDecimal minimumBalance, AccountStatus status, BigDecimal interestRate) {
        super(balance, primaryOwner);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.creationDate = LocalDate.now();
        this.status = status;
        setInterestRate(interestRate);
        this.interestDate = creationDate;
    }

    public Savings(BigDecimal balance, String primaryOwner, String secondaryOwner, String secretKey, BigDecimal minimumBalance, AccountStatus status, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.creationDate = LocalDate.now();
        this.status = status;
        setInterestRate(interestRate);
        this.interestDate = creationDate;
    }

/*    public Savings(BigDecimal balance, String primaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status) {
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
    }*/

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
        if((minimumBalance.compareTo(new BigDecimal("1000"))<=0) && (minimumBalance.compareTo(new BigDecimal("100"))>=0))
            this.minimumBalance = minimumBalance;
        else
            this.minimumBalance = new BigDecimal("1000");
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

/*    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }*/

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

    private void deductFromAccount(Savings account){
        if (account.getBalance().compareTo(account.getMinimumBalance())<0)
            account.setBalance(account.getBalance().subtract(account.getPenaltyFee()));
    }

    public BigDecimal getBalance(){
        BigDecimal newBalance;
        LocalDate now = LocalDate.now();
        int diff = Math.abs(Days.daysBetween(now,interestDate).getDays());
        if (diff<365)
            return this.getBalance();
        else
            newBalance = getBalance().add(getBalance().multiply(getInterestRate()));
            setBalance(newBalance);
            interestDate = LocalDate.now();
            return this.getBalance();

    }
}
