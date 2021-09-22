package ironhack.midterm.BankingSystem.service.interfaces;

import java.math.BigDecimal;

public interface IStudentCheckingService {

    void updateStudentCheckingBalance(Integer id, BigDecimal newBalance);
}
