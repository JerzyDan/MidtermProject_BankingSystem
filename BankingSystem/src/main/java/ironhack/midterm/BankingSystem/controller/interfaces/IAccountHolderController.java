package ironhack.midterm.BankingSystem.controller.interfaces;

import ironhack.midterm.BankingSystem.dao.accounts.*;

import java.math.BigDecimal;

public interface IAccountHolderController {

    Money getCheckingBalanceById(Integer id);
    Money getCreditCardBalanceById(Integer id);
    Money getSavingBalanceById(Integer id);
    Money getStudentCheckingById(Integer id);

    void transferFromChecking(Checking account, BigDecimal balance, String owner, Integer accountId);
    void transferFromCreditCard(CreditCard account, BigDecimal balance, String owner, Integer accountId);
    void transferFromSavings(Savings account, BigDecimal balance, String owner, Integer accountId);
    void transferFromStudentChecking(StudentChecking account, BigDecimal balance, String owner, Integer accountId);
}