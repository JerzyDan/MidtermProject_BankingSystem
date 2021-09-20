package ironhack.midterm.BankingSystem.service.interfaces;

import java.math.BigDecimal;

public interface ISavingService {

    void updateSavingBalance(Integer id, BigDecimal newBalance);
}
