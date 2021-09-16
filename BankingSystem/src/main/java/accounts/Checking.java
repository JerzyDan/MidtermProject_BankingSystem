package accounts;

import enums.AccountStatus;
import org.joda.time.LocalDate;

import java.math.BigDecimal;

public class Checking extends Account {

    private String secretKey;
    private static final BigDecimal minimumBalance = new BigDecimal("250");
    private static final BigDecimal monthlyMaintenanceFee = new BigDecimal("12");
    private LocalDate creationDate;
    private AccountStatus status;


    public Checking(BigDecimal balance, String primaryOwner, String secretKey, AccountStatus status) {

        super(balance, primaryOwner);
        this.secretKey = secretKey;
        //this.minimumBalance = minimumBalance;
        //this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.creationDate = LocalDate.now();
        this.status = status;
    }

    public Checking(BigDecimal balance, String primaryOwner, String secondaryOwner, String secretKey, AccountStatus status) {

        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        //this.minimumBalance = minimumBalance;
        //this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.creationDate = LocalDate.now();
        this.status = status;
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

/*    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }*/

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

/*    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }*/

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

    private void deductFromAccount(Checking account){
        if (account.getBalance().compareTo(account.getMinimumBalance())<0)
            account.setBalance(account.getBalance().subtract(account.getPenaltyFee()));
    }
}
