package ironhack.midterm.BankingSystem.dao.accounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal balance;
    private String primaryOwner;
    private String secondaryOwner;
    private static final BigDecimal penaltyFee = new BigDecimal("40");

    public Account(BigDecimal balance, String primaryOwner) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        //this.penaltyFee = penaltyFee;
    }

    public Account(BigDecimal balance, String primaryOwner, String secondaryOwner) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        //this.penaltyFee = penaltyFee;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(String primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public String getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(String secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

/*    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }*/
}
