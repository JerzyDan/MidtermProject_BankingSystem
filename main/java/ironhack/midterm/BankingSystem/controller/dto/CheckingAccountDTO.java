package ironhack.midterm.BankingSystem.controller.dto;

import ironhack.midterm.BankingSystem.dao.accounts.Account;
import ironhack.midterm.BankingSystem.dao.accounts.Money;
import ironhack.midterm.BankingSystem.dao.users.AccountHolder;
import ironhack.midterm.BankingSystem.enums.AccountStatus;
import org.joda.time.LocalDate;
import org.joda.time.Period;

public class CheckingAccountDTO extends Account {

    private String secretKey;
    private LocalDate creationDate;
    private AccountStatus status;

    public CheckingAccountDTO(Money balance, AccountHolder primaryOwner, String secretKey, AccountStatus status) {
        super(balance, primaryOwner);
        this.secretKey = secretKey;
        this.status = status;
    }

    public CheckingAccountDTO(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey, AccountStatus status) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.status = status;
    }

    public int getOwnerAge(AccountHolder accountHolder){
        Period age = new Period(LocalDate.now(),accountHolder.getDateOfBirth());
        return age.getYears();
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
