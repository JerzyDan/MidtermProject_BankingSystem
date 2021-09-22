package ironhack.midterm.BankingSystem.dao.accounts;

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
import java.math.MathContext;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class CreditCard extends Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal creditLimit;
    private BigDecimal interestRate;
    private LocalDate interestDate;

    public CreditCard(Money balance, String primaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        super(balance, primaryOwner);
        setCreditLimit(creditLimit);
        setInterestRate(interestRate);
        this.interestDate = LocalDate.now();
    }

    public CreditCard(Money balance, String primaryOwner, String secondaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        setCreditLimit(creditLimit);
        setInterestRate(interestRate);
        this.interestDate = LocalDate.now();
    }

    public CreditCard(Money balance, String primaryOwner, BigDecimal interestRate) {
        super(balance, primaryOwner);
        this.creditLimit = new BigDecimal("100");
        setInterestRate(interestRate);
        this.interestDate = LocalDate.now();
    }

    public CreditCard(Money balance, String primaryOwner, String secondaryOwner, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        this.creditLimit = new BigDecimal("100");
        setInterestRate(interestRate);
        this.interestDate = LocalDate.now();
    }

//TODO default value for interestRate

    public CreditCard(Money balance, String primaryOwner) {
        super(balance, primaryOwner);
        this.creditLimit = new BigDecimal("100");
        this.interestRate = new BigDecimal("0.2");
        this.interestDate = LocalDate.now();
    }

    public CreditCard(Money balance, String primaryOwner, String secondaryOwner) {
        super(balance, primaryOwner, secondaryOwner);
        this.creditLimit = new BigDecimal("100");
        this.interestRate = new BigDecimal("0.2");
        this.interestDate = LocalDate.now();
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        if ((creditLimit.compareTo(new BigDecimal("100"))>=0) && (creditLimit.compareTo(new BigDecimal("100000"))<=0))
            this.creditLimit = creditLimit;
        else
            this.creditLimit = new BigDecimal("100");
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if ((interestRate.compareTo(new BigDecimal("0.1"))>=0) && (interestRate.compareTo(new BigDecimal("0.2"))<=0))
            this.interestRate = interestRate;
        else
            this.interestRate = new BigDecimal("0.2");
    }

    public Money getBalance(){
        BigDecimal newBalance;
        LocalDate now = LocalDate.now();
        MathContext mc = new MathContext(2);
        BigDecimal divisor = new BigDecimal("12");
        int diff = Math.abs(Days.daysBetween(now,interestDate).getDays());
        if (diff<31)
            return this.getBalance();
        else
            newBalance = getBalance().getAmount().add(getBalance().getAmount().multiply(getInterestRate().divide(divisor, mc)));
        setBalance(new Money(newBalance,getBalance().getCurrency()));
        interestDate = LocalDate.now();
        return this.getBalance();
    }


}
