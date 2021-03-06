package ironhack.midterm.BankingSystem.dao.accounts;

import ironhack.midterm.BankingSystem.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class StudentChecking extends Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String secretKey;
    private LocalDate creationDate = LocalDate.now();
    private AccountStatus status;
    private LocalTime lastTransactionTime = LocalTime.now();

    public StudentChecking(Money balance, String primaryOwner, String secretKey, AccountStatus status) {
        super(balance, primaryOwner);
        this.secretKey = secretKey;
        this.status = status;
    }

    public StudentChecking(Money balance, String primaryOwner, String secondaryOwner, String secretKey, AccountStatus status) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.status = status;
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

    public LocalTime getLastTransactionTime() {
        return lastTransactionTime;
    }

    public void setLastTransactionTime(LocalTime lastTransactionTime) {
        this.lastTransactionTime = lastTransactionTime;
    }
}
