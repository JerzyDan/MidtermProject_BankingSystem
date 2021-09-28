package ironhack.midterm.BankingSystem.controller.interfaces;

import ironhack.midterm.BankingSystem.dao.accounts.Checking;
import ironhack.midterm.BankingSystem.dao.accounts.CreditCard;
import ironhack.midterm.BankingSystem.dao.accounts.Savings;
import ironhack.midterm.BankingSystem.dao.accounts.StudentChecking;
import ironhack.midterm.BankingSystem.dao.users.AccountHolder;
import ironhack.midterm.BankingSystem.dao.users.ThirdParty;

import java.math.BigDecimal;

public interface IAdminController {

    Checking getCheckingById(Integer id);
    Savings getSavingById(Integer id);
    CreditCard getCreditcardById(Integer id);
    StudentChecking getStudentCheckingById(Integer id);

    void checkingStored(Checking checking, AccountHolder accountHolder);
    void studentCheckingStored(StudentChecking studentChecking, AccountHolder accountHolder);
    Savings savingsSored (Savings savings);
    CreditCard creditCardStored(CreditCard creditCard);

    void updateCheckingBalance(Integer checkingId, BigDecimal newBalance);
    void updateSavingBalance(Integer savingId, BigDecimal newBalance);
    void updateCreditCardBalance(Integer creditCardId, BigDecimal newBalance);
    void updateStudentCheckingBalance(Integer studentCheckingId, BigDecimal newBalance);

    ThirdParty storeThirdParty(ThirdParty thirdParty);
}
