package ironhack.midterm.BankingSystem.dao.accounts;

import ironhack.midterm.BankingSystem.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Savings extends Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String secretKey;
    private BigDecimal minimumBalance;
    private LocalDate creationDate;
    private AccountStatus status;
    private BigDecimal interestRate;
    private LocalDate interestDate;
    private boolean deductFlag = true;

    public Savings(Money balance, String primaryOwner, String secretKey, BigDecimal minimumBalance, AccountStatus status, BigDecimal interestRate) {
        super(balance, primaryOwner);
        this.secretKey = secretKey;
        setMinimumBalance(minimumBalance);
        this.creationDate = LocalDate.now();
        this.status = status;
        setInterestRate(interestRate);
        this.interestDate = creationDate;
    }

    public Savings(Money balance, String primaryOwner, String secondaryOwner, String secretKey, BigDecimal minimumBalance, AccountStatus status, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        setMinimumBalance(minimumBalance);
        this.creationDate = LocalDate.now();
        this.status = status;
        setInterestRate(interestRate);
        this.interestDate = creationDate;
    }

    public Savings(Money balance, String primaryOwner, String secretKey, BigDecimal minimumBalance, AccountStatus status) {
        super(balance, primaryOwner);
        this.secretKey = secretKey;
        setMinimumBalance(minimumBalance);
        this.creationDate = LocalDate.now();
        this.status = status;
        this.interestRate = new BigDecimal("0.0025");
        this.interestDate = creationDate;
    }

    public Savings(Money balance, String primaryOwner, String secondaryOwner, String secretKey, BigDecimal minimumBalance, AccountStatus status) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        setMinimumBalance(minimumBalance);
        this.creationDate = LocalDate.now();
        this.status = status;
        this.interestRate = new BigDecimal("0.0025");
        this.interestDate = creationDate;
    }

    public Savings(Money balance, String primaryOwner, String secretKey, AccountStatus status, BigDecimal interestRate) {
        super(balance, primaryOwner);
        this.secretKey = secretKey;
        this.minimumBalance = new BigDecimal("1000");
        this.creationDate = LocalDate.now();
        this.status = status;
        setInterestRate(interestRate);
        this.interestDate = creationDate;
    }

    public Savings(Money balance, String primaryOwner, String secondaryOwner, String secretKey, AccountStatus status, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.minimumBalance = new BigDecimal("1000");
        this.creationDate = LocalDate.now();
        this.status = status;
        setInterestRate(interestRate);
        this.interestDate = creationDate;
    }

    public Savings(Money balance, String primaryOwner, String secretKey, AccountStatus status) {
        super(balance, primaryOwner);
        this.secretKey = secretKey;
        this.minimumBalance = new BigDecimal("1000");
        this.creationDate = LocalDate.now();
        this.status = status;
        this.interestRate = new BigDecimal("0.0025");
        this.interestDate = creationDate;
    }

    public Savings(Money balance, String primaryOwner, String secondaryOwner, String secretKey, AccountStatus status) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.minimumBalance = new BigDecimal("1000");
        this.creationDate = LocalDate.now();
        this.status = status;
        this.interestRate = new BigDecimal("0.0025");
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
        if (account.getBalance().getAmount().compareTo(account.getMinimumBalance())<0)
            account.setBalance(new Money(account.getBalance().getAmount().subtract(account.getPenaltyFee()),account.getBalance().getCurrency()));
    }

    public Money getBalance(Checking account){
        BigDecimal newBalance;
        LocalDate now = LocalDate.now();
        int diff = Math.abs(Days.daysBetween(now,interestDate).getDays());

        if (diff<365) {
            if (account.getBalance().getAmount().compareTo(account.getMinimumBalance()) < 0) {

                if (isDeductFlag()) {
                    account.setBalance(new Money(account.getBalance().getAmount().subtract(account.getPenaltyFee()), account.getBalance().getCurrency()));
                    setDeductFlag(false);
                }
                else{
                    setDeductFlag(true);
                }
            }

        else {
                newBalance = getBalance().getAmount().add(getBalance().getAmount().multiply(getInterestRate()));
                setBalance(new Money(newBalance,getBalance().getCurrency()));
                interestDate = LocalDate.now();

                if (account.getBalance().getAmount().compareTo(account.getMinimumBalance()) < 0) {

                    if (isDeductFlag()) {
                        account.setBalance(new Money(account.getBalance().getAmount().subtract(account.getPenaltyFee()), account.getBalance().getCurrency()));
                        setDeductFlag(false);
                    }
                }
                else{
                    setDeductFlag(true);
                }
            }
        }
        return getBalance();

    }


    public boolean isDeductFlag() {
        return deductFlag;
    }

    public void setDeductFlag(boolean deductFlag) {
        this.deductFlag = deductFlag;
    }
}
