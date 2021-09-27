package ironhack.midterm.BankingSystem.dao.accounts;

import ironhack.midterm.BankingSystem.enums.AccountStatus;
import ironhack.midterm.BankingSystem.repository.accountsRepository.CheckingRepository;
import ironhack.midterm.BankingSystem.repository.accountsRepository.CreditCardRepository;
import ironhack.midterm.BankingSystem.repository.accountsRepository.SavingsRepository;
import ironhack.midterm.BankingSystem.repository.accountsRepository.StudentCheckingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest()
class AccountsTest {

    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    Checking checking = new Checking(new Money(new BigDecimal(500),"USD"), "John Smith", "String secretKey", AccountStatus.ACTIVE);
    Checking checking2 = new Checking(new Money(new BigDecimal(250),"GBP"), "Adam Nowak", "Anna Kowalski","qwerty1234", AccountStatus.FROZEN);

    CreditCard creditCard = new CreditCard(new Money(BigDecimal.valueOf(1000),"EUR"), "Alan Wake", new BigDecimal("100000"), new BigDecimal("0.15"));
    CreditCard creditCard2 = new CreditCard(new Money(BigDecimal.valueOf(1521.52),"PLN"), "Alexandre Dumas", "Atos",new BigDecimal("23"), new BigDecimal("0.06"));
    CreditCard creditCard3 = new CreditCard(new Money(BigDecimal.valueOf(26.13),"CHF"), "Unknown", new BigDecimal("100000"));
    CreditCard creditCard4 = new CreditCard(new Money(BigDecimal.valueOf(525654),"USD"), "Alfred","Nobel", new BigDecimal("0.21"));
    CreditCard creditCard5 = new CreditCard(new Money(BigDecimal.valueOf(43.43),"EUR"), "Peggy Sue");
    CreditCard creditCard6 = new CreditCard(new Money(BigDecimal.valueOf(951),"CHF"), "XYZ","ABC");

    Savings savings = new Savings(new Money(BigDecimal.valueOf(500000),"GBP"), "Mr X", "!@#!@$#@%$&^%$^&^%*#$", BigDecimal.valueOf(100), AccountStatus.ACTIVE, BigDecimal.valueOf(0.154));
    Savings savings2 = new Savings(new Money(BigDecimal.valueOf(400000),"GBP"), "Mr X", "Ms Y","abc", BigDecimal.valueOf(252), AccountStatus.FROZEN, BigDecimal.valueOf(0.1));
    Savings savings3 = new Savings(new Money(BigDecimal.valueOf(300000),"GBP"), "Mr X", "def", BigDecimal.valueOf(120), AccountStatus.ACTIVE);
    Savings savings4 = new Savings(new Money(BigDecimal.valueOf(200000),"GBP"), "Mr X","Lady G.", "5%^", BigDecimal.valueOf(130), AccountStatus.FROZEN);
    Savings savings5 = new Savings(new Money(BigDecimal.valueOf(100000),"GBP"), "Mr X", "!@#!@$#@%$&^%$^&^%*#$", AccountStatus.ACTIVE, BigDecimal.valueOf(0.154));
    Savings savings6 = new Savings(new Money(BigDecimal.valueOf(90000),"GBP"), "Mr X", "ASD","2lijalkjc3", AccountStatus.ACTIVE, BigDecimal.valueOf(0.154));
    Savings savings7 = new Savings(new Money(BigDecimal.valueOf(80000),"GBP"), "Mr X", "!",AccountStatus.FROZEN);
    Savings savings8 = new Savings(new Money(BigDecimal.valueOf(700000),"GBP"), "Mr X", "Hi Men","N656GB",AccountStatus.ACTIVE);

    StudentChecking studentChecking = new StudentChecking(new Money(BigDecimal.valueOf(35),"PLN"), "Jack Sparrow", "Hidden somewhere", AccountStatus.FROZEN);
    StudentChecking studentChecking2 = new StudentChecking(new Money(BigDecimal.valueOf(123456.99),"SLL"), "Barbossa", "Give me your gold", AccountStatus.ACTIVE);

    @Test
    void saveChecking() {
        checkingRepository.saveAll(List.of(checking,checking2));
    }

    @Test
    void saveCreditCard(){
        creditCardRepository.saveAll(List.of(creditCard, creditCard2, creditCard3, creditCard4, creditCard5, creditCard6));
    }

    @Test
    void saveSaving(){
        savingsRepository.saveAll(List.of(savings,savings2,savings3,savings4,savings5,savings6,savings7,savings8));
    }

    @Test
    void saveStudentChecking(){
        studentCheckingRepository.saveAll(List.of(studentChecking,studentChecking2));
    }
}