package ironhack.midterm.BankingSystem.service.interfaces;

import java.math.BigDecimal;

public interface ICheckingService {

    void updateCheckingBalance(Integer id, BigDecimal newBalance);
}
