package ironhack.midterm.BankingSystem.dao.users;

import ironhack.midterm.BankingSystem.dao.accounts.Checking;
import ironhack.midterm.BankingSystem.dao.accounts.CreditCard;
import ironhack.midterm.BankingSystem.dao.accounts.Money;
import ironhack.midterm.BankingSystem.dao.accounts.Savings;
import ironhack.midterm.BankingSystem.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Admin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //TODO: When creating a new Checking account, if the primaryOwner is less than 24, a StudentChecking account should be created otherwise a regular Checking Account should be created.

    private Checking createChecking(Money balance, String primaryOwner, String secretKey, AccountStatus status){
        return new Checking(balance, primaryOwner, secretKey,status);
    }

    private Checking createChecking(Money balance, String primaryOwner, String secondaryOwner, String secretKey, AccountStatus status){
        return new Checking(balance, primaryOwner, secondaryOwner, secretKey, status);
    }

    private Savings createSaving(Money balance, String primaryOwner, String secretKey, BigDecimal minimumBalance, AccountStatus status, BigDecimal interestRate){
        return new Savings(balance,primaryOwner,secretKey,minimumBalance,status,interestRate);
    }

    private Savings createSaving(Money balance, String primaryOwner, String secondaryOwner, String secretKey, BigDecimal minimumBalance, AccountStatus status, BigDecimal interestRate){
        return new Savings(balance,primaryOwner,secondaryOwner, secretKey,minimumBalance,status,interestRate);
    }

/*    private Savings createSaving(BigDecimal balance, String primaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status){
        return new Savings(balance,primaryOwner,penaltyFee,secretKey,minimumBalance,creationDate,status);
    }

    private Savings createSaving(BigDecimal balance, String primaryOwner, String secondaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status){
        return new Savings(balance,primaryOwner,secondaryOwner, penaltyFee,secretKey,minimumBalance,creationDate,status);
    }*/

    private CreditCard createCreditCard(Money balance, String primaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        return new CreditCard(balance,primaryOwner,creditLimit,interestRate);
    }

    private CreditCard createCreditCard(Money balance, String primaryOwner, String secondaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        return new CreditCard(balance,primaryOwner,secondaryOwner,creditLimit,interestRate);
    }


}
