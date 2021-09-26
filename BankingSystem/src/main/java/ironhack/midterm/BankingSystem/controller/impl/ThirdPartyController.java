package ironhack.midterm.BankingSystem.controller.impl;

import ironhack.midterm.BankingSystem.controller.interfaces.IThirdPartyController;
import ironhack.midterm.BankingSystem.dao.accounts.*;
import ironhack.midterm.BankingSystem.repository.accountsRepository.AccountRepository;
import ironhack.midterm.BankingSystem.repository.accountsRepository.CheckingRepository;
import ironhack.midterm.BankingSystem.repository.accountsRepository.SavingsRepository;
import ironhack.midterm.BankingSystem.repository.accountsRepository.StudentCheckingRepository;
import ironhack.midterm.BankingSystem.repository.usersRepository.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class ThirdPartyController implements IThirdPartyController {

    @Autowired
    ThirdPartyRepository thirdPartyRepository;
    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    @GetMapping("/sendMoneyToChecking")
    @ResponseStatus(HttpStatus.OK)
    public void sendMoneyToChecking(@RequestHeader(name = "hashedKey") String hashedKey, @RequestParam BigDecimal amount, @RequestParam Integer accountId, @RequestParam String secretKey){

        Optional<Checking> storedAccount = checkingRepository.findById(accountId);
        if (storedAccount.isPresent() && Objects.equals(storedAccount.get().getSecretKey(), secretKey)){
            storedAccount.get().setBalance(new Money(storedAccount.get().getBalance().getAmount().add(amount), storedAccount.get().getBalance().getCurrency()));
            System.out.println("Money sent.");
        }
        else System.out.println("Account does not exist");
    }

    @GetMapping("/sendMoneyToSavings")
    @ResponseStatus(HttpStatus.OK)
    public void sendMoneyToSaving(@RequestHeader(name = "hashedKey") String hashedKey, @RequestParam BigDecimal amount, @RequestParam Integer accountId, @RequestParam String secretKey){

        Optional<Savings> storedAccount = savingsRepository.findById(accountId);
        if (storedAccount.isPresent() && Objects.equals(storedAccount.get().getSecretKey(), secretKey)){
            storedAccount.get().setBalance(new Money(storedAccount.get().getBalance().getAmount().add(amount), storedAccount.get().getBalance().getCurrency()));
            System.out.println("Money sent.");
        }
        else System.out.println("Account does not found");
    }

    @GetMapping("/sendMoneyToStudent")
    @ResponseStatus(HttpStatus.OK)
    public void sendMoneyToStudent(@RequestHeader(name = "hashedKey") String hashedKey, @RequestParam BigDecimal amount, @RequestParam Integer accountId, @RequestParam String secretKey){

        Optional<StudentChecking> storedAccount = studentCheckingRepository.findById(accountId);
        if (storedAccount.isPresent() && Objects.equals(storedAccount.get().getSecretKey(), secretKey)){
            storedAccount.get().setBalance(new Money(storedAccount.get().getBalance().getAmount().add(amount), storedAccount.get().getBalance().getCurrency()));
            System.out.println("Money sent.");
        }
        else System.out.println("Account does not found");
    }
}
