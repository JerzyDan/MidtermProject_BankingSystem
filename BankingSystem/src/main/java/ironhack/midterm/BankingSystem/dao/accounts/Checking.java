package ironhack.midterm.BankingSystem.dao.accounts;

import ironhack.midterm.BankingSystem.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Checking extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //TODO Should I use Id, if I extends Account class which have Id
    private Integer id;

    private String secretKey;
    private static final BigDecimal minimumBalance = new BigDecimal("250");
    private static final BigDecimal monthlyMaintenanceFee = new BigDecimal("12");
    private LocalDate creationDate;
    private AccountStatus status;
    private boolean deductFlag = true; //the penalty can be deducted from the amount


    public Checking(Money balance, String primaryOwner, String secretKey, AccountStatus status) {

        super(balance, primaryOwner);
        this.secretKey = secretKey;
        //this.minimumBalance = minimumBalance;
        //this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.creationDate = LocalDate.now();
        this.status = status;
    }

    public Checking(Money balance, String primaryOwner, String secondaryOwner, String secretKey, AccountStatus status) {

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

    public boolean isDeductFlag() {
        return deductFlag;
    }

    public void setDeductFlag(boolean deductFlag) {
        this.deductFlag = deductFlag;
    }

/*    private void deductFromAccount(Checking account){

        if (account.getBalance().getAmount().compareTo(account.getMinimumBalance())<0)
            account.setBalance(new Money(account.getBalance().getAmount().subtract(account.getPenaltyFee()),account.getBalance().getCurrency()));
    }*/

    public Money getBalance(Checking account) {

        if (account.getBalance().getAmount().compareTo(account.getMinimumBalance()) < 0) {

            if (isDeductFlag()) {
                account.setBalance(new Money(account.getBalance().getAmount().subtract(account.getPenaltyFee()), account.getBalance().getCurrency()));
                setDeductFlag(false);
            }
        }
        else{
            setDeductFlag(true);
        }
        return getBalance();
    }
}
