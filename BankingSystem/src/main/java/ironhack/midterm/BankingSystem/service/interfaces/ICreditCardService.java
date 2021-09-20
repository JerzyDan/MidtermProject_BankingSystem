package ironhack.midterm.BankingSystem.service.interfaces;

import java.math.BigDecimal;

public interface ICreditCardService {

    void updateCreditCardBalance(Integer id, BigDecimal newBalance);
}
