package users;

import accounts.Checking;
import accounts.CreditCard;
import accounts.Savings;
import enums.AccountStatus;

import java.math.BigDecimal;

public class Admin {

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

    private Checking createChecking(BigDecimal balance, String primaryOwner, String secretKey, String creationDate, AccountStatus status){
        return new Checking(balance, primaryOwner, secretKey, creationDate,status);
    }

    private Checking createChecking(BigDecimal balance, String primaryOwner, String secondaryOwner, String secretKey, String creationDate, AccountStatus status){
        return new Checking(balance, primaryOwner, secondaryOwner, secretKey, creationDate,status);
    }

    private Savings createSaving(BigDecimal balance, String primaryOwner, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status, BigDecimal interestRate){
        return new Savings(balance,primaryOwner,secretKey,minimumBalance,creationDate,status,interestRate);
    }

    private Savings createSaving(BigDecimal balance, String primaryOwner, String secondaryOwner, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status, BigDecimal interestRate){
        return new Savings(balance,primaryOwner,secondaryOwner, secretKey,minimumBalance,creationDate,status,interestRate);
    }

/*    private Savings createSaving(BigDecimal balance, String primaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status){
        return new Savings(balance,primaryOwner,penaltyFee,secretKey,minimumBalance,creationDate,status);
    }

    private Savings createSaving(BigDecimal balance, String primaryOwner, String secondaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status){
        return new Savings(balance,primaryOwner,secondaryOwner, penaltyFee,secretKey,minimumBalance,creationDate,status);
    }*/

    private CreditCard createCreditCard(BigDecimal balance, String primaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        return new CreditCard(balance,primaryOwner,creditLimit,interestRate);
    }

    private CreditCard createCreditCard(BigDecimal balance, String primaryOwner, String secondaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        return new CreditCard(balance,primaryOwner,secondaryOwner,creditLimit,interestRate);
    }


}
