package accounts;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CreditCard extends Account{

    private BigDecimal creditLimit;
    private BigDecimal interestRate;
    private LocalDate interestDate;

    public CreditCard(BigDecimal balance, String primaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        super(balance, primaryOwner);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.interestDate = LocalDate.now();
    }

    public CreditCard(BigDecimal balance, String primaryOwner, String secondaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
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

    public BigDecimal getBalance(){
        BigDecimal newBalance;
        LocalDate now = LocalDate.now();
        MathContext mc = new MathContext(2);
        BigDecimal divisor = new BigDecimal("12");
        int diff = Math.abs(Days.daysBetween(now,interestDate).getDays());
        if (diff<31)
            return this.getBalance();
        else
            newBalance = getBalance().add(getBalance().multiply(getInterestRate().divide(divisor, mc)));
        setBalance(newBalance);
        interestDate = LocalDate.now();
        return this.getBalance();
    }
}
