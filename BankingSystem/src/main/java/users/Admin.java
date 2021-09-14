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

    private Checking createChecking(BigDecimal balance, String primaryOwner, BigDecimal penaltyFee,
                                     String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee, String creationDate,
                                     AccountStatus status){

        return new Checking(balance, primaryOwner, penaltyFee, secretKey, minimumBalance,
                monthlyMaintenanceFee, creationDate,status);
    }

    private Checking createChecking(BigDecimal balance, String primaryOwner, String secondaryOwner, BigDecimal penaltyFee,
                                    String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee,
                                    String creationDate, AccountStatus status){

        return new Checking(balance, primaryOwner, secondaryOwner, penaltyFee, secretKey, minimumBalance,
                monthlyMaintenanceFee, creationDate,status);
    }

    private Savings createSaving(BigDecimal balance, String primaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status, BigDecimal interestRate){
        return new Savings(balance,primaryOwner,penaltyFee,secretKey,minimumBalance,creationDate,status,interestRate);
    }

    private Savings createSaving(BigDecimal balance, String primaryOwner, String secondaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status, BigDecimal interestRate){
        return new Savings(balance,primaryOwner,secondaryOwner, penaltyFee,secretKey,minimumBalance,creationDate,status,interestRate);
    }

    private Savings createSaving(BigDecimal balance, String primaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status){
        return new Savings(balance,primaryOwner,penaltyFee,secretKey,minimumBalance,creationDate,status);
    }

    private Savings createSaving(BigDecimal balance, String primaryOwner, String secondaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, String creationDate, AccountStatus status){
        return new Savings(balance,primaryOwner,secondaryOwner, penaltyFee,secretKey,minimumBalance,creationDate,status);
    }

    private CreditCard createCreditCard(BigDecimal balance, String primaryOwner, BigDecimal penaltyFee, BigDecimal creditLimit, BigDecimal interestRate) {
        return new CreditCard(balance,primaryOwner,penaltyFee,creditLimit,interestRate);
    }

    private CreditCard createCreditCard(BigDecimal balance, String primaryOwner, String secondaryOwner, BigDecimal penaltyFee, BigDecimal creditLimit, BigDecimal interestRate) {
        return new CreditCard(balance,primaryOwner,secondaryOwner,penaltyFee,creditLimit,interestRate);
    }


}
