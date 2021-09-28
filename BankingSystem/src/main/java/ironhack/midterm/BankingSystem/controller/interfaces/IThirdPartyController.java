package ironhack.midterm.BankingSystem.controller.interfaces;

import java.math.BigDecimal;

public interface IThirdPartyController {

    void sendMoneyToChecking(String hashedKey, BigDecimal amount, Integer accountId, String secretKey);
    void sendMoneyToSaving(String hashedKey, BigDecimal amount, Integer accountId, String secretKey);
    void sendMoneyToStudent(String hashedKey, BigDecimal amount, Integer accountId, String secretKey);
}
