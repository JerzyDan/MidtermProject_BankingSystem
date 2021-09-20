package ironhack.midterm.BankingSystem.dao.accounts;

import ironhack.midterm.BankingSystem.enums.AccountStatus;
import ironhack.midterm.BankingSystem.repository.accountsRepository.CheckingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class AccountTest {

    @Autowired
    CheckingRepository checkingRepository;
    Checking checking = new Checking(new Money(new BigDecimal(500),"USD"), "John Smith", "String secretKey", AccountStatus.ACTIVE);


    @BeforeEach
    void setUp() {


    }

    @Test
    void getBalance() {
        checkingRepository.save(checking);

    }
}