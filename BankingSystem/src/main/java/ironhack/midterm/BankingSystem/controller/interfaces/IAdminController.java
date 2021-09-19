package ironhack.midterm.BankingSystem.controller.interfaces;

import ironhack.midterm.BankingSystem.dao.accounts.Checking;
import ironhack.midterm.BankingSystem.dao.accounts.CreditCard;
import ironhack.midterm.BankingSystem.dao.accounts.Savings;
import ironhack.midterm.BankingSystem.dao.accounts.StudentChecking;

public interface IAdminController {

    Checking getCheckingById(Integer id);
    Savings getSavingById(Integer id);
    CreditCard getCreditcardById(Integer id);
    StudentChecking getStudentCheckingById(Integer id);
}
