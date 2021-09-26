package ironhack.midterm.BankingSystem.controller.impl;

import ironhack.midterm.BankingSystem.controller.interfaces.IAccountHolderController;
import ironhack.midterm.BankingSystem.dao.accounts.*;
import ironhack.midterm.BankingSystem.enums.AccountStatus;
import ironhack.midterm.BankingSystem.repository.accountsRepository.*;
import ironhack.midterm.BankingSystem.repository.usersRepository.AccountHolderRepository;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@RestController
public class AccountHolderController implements IAccountHolderController {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    SavingsRepository savingsRepository;

    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    @Autowired
    AccountRepository accountRepository;

    //access their own account balance
    @GetMapping("/getCheckingBalance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getCheckingBalanceById(@PathVariable(name = "id")Integer id){
        Optional<Checking> optionalChecking = checkingRepository.findById(id);
        return optionalChecking.map(Account::getBalance).orElse(null);
    }

    @GetMapping("/getCreditCardBalance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getCreditCardBalanceById(@PathVariable(name = "id")Integer id){
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
        return optionalCreditCard.map(Account::getBalance).orElse(null);
    }

    @GetMapping("/getSavingsBalance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getSavingBalanceById(@PathVariable(name = "id")Integer id){
        Optional<Savings> optionalSavings = savingsRepository.findById(id);
        return optionalSavings.map(Account::getBalance).orElse(null);
    }

    @GetMapping("/getStudentBalance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getStudentCheckingById(@PathVariable(name = "id")Integer id){
        Optional<StudentChecking> optionalStudentChecking = studentCheckingRepository.findById(id);
        return optionalStudentChecking.map(Account::getBalance).orElse(null);
    }

    //transfer money from any of their accounts to any other account

    @GetMapping("/transferFromChecking")
    @ResponseStatus(HttpStatus.OK)
    public void transferFromChecking(@RequestParam Checking account, @RequestParam BigDecimal balance, @RequestParam String owner, @RequestParam Integer accountId){

        Optional<Account> accountToTransfer = accountRepository.findById(accountId);

        if (accountToTransfer.isPresent()&&(accountToTransfer.get().getPrimaryOwner().equals(owner) || accountToTransfer.get().getSecondaryOwner().equals(owner))){

            if (account.getBalance().getAmount().compareTo(balance)<0){
                System.out.println("Insufficient funds on account.");
            }
            else if (!Objects.equals(account.getBalance().getCurrency(), accountToTransfer.get().getBalance().getCurrency())){
                System.out.println("Accounts have different currencies.");
            }
            else if (account.getStatus() != AccountStatus.ACTIVE){
                System.out.println("Account is not active.");
            }
            else if (account.getLastTransactionTime().getSecondOfMinute() == LocalTime.now().getSecondOfMinute()){
                account.setStatus(AccountStatus.FROZEN);
                System.out.println("Illegal transaction");
            }
            else {
                account.setBalance(new Money(account.getBalance().getAmount().subtract(balance),account.getBalance().getCurrency()));
                accountToTransfer.get().setBalance(new Money(accountToTransfer.get().getBalance().getAmount().add(balance),accountToTransfer.get().getBalance().getCurrency()));
                account.setLastTransactionTime(LocalTime.now());
            }
        }
        else {
            System.out.println("Invalid input data");
        }
    }

    @GetMapping("/transferFromCreditCard")
    @ResponseStatus(HttpStatus.OK)
    public void transferFromCreditCard(@RequestParam CreditCard account, @RequestParam BigDecimal balance, @RequestParam String owner, @RequestParam Integer accountId){

        Optional<Account> accountToTransfer = accountRepository.findById(accountId);

        if (accountToTransfer.isPresent()&&(accountToTransfer.get().getPrimaryOwner().equals(owner) || accountToTransfer.get().getSecondaryOwner().equals(owner))){

            if (account.getBalance().getAmount().compareTo(balance)<0){
                System.out.println("Insufficient funds on account.");
            }
            else if (!Objects.equals(account.getBalance().getCurrency(), accountToTransfer.get().getBalance().getCurrency())){
                System.out.println("Accounts have different currencies.");
            }
            else {
                account.setBalance(new Money(account.getBalance().getAmount().subtract(balance),account.getBalance().getCurrency()));
                accountToTransfer.get().setBalance(new Money(accountToTransfer.get().getBalance().getAmount().add(balance),accountToTransfer.get().getBalance().getCurrency()));
            }
        }
        else {
            System.out.println("Invalid input data");
        }
    }

    @GetMapping("/transferFromSavings")
    @ResponseStatus(HttpStatus.OK)
    public void transferFromSavings(@RequestParam Savings account, @RequestParam BigDecimal balance, @RequestParam String owner, @RequestParam Integer accountId) {

        Optional<Account> accountToTransfer = accountRepository.findById(accountId);

        if (accountToTransfer.isPresent() && (accountToTransfer.get().getPrimaryOwner().equals(owner) || accountToTransfer.get().getSecondaryOwner().equals(owner))) {

            if (account.getBalance().getAmount().compareTo(balance) < 0) {
                System.out.println("Insufficient funds on account.");
            } else if (!Objects.equals(account.getBalance().getCurrency(), accountToTransfer.get().getBalance().getCurrency())) {
                System.out.println("Accounts have different currencies.");
            } else if (account.getStatus() != AccountStatus.ACTIVE) {
                System.out.println("Account is not active.");
            } else if (account.getLastTransactionTime().getSecondOfMinute() == LocalTime.now().getSecondOfMinute()) {
                account.setStatus(AccountStatus.FROZEN);
                System.out.println("Illegal transaction");
            } else {
                account.setBalance(new Money(account.getBalance().getAmount().subtract(balance), account.getBalance().getCurrency()));
                accountToTransfer.get().setBalance(new Money(accountToTransfer.get().getBalance().getAmount().add(balance), accountToTransfer.get().getBalance().getCurrency()));
                account.setLastTransactionTime(LocalTime.now());
            }
        } else {
            System.out.println("Invalid input data");
        }
    }

        @GetMapping("/transferFromStudentChecking")
        @ResponseStatus(HttpStatus.OK)
        public void transferFromStudentChecking(@RequestParam StudentChecking account, @RequestParam BigDecimal balance, @RequestParam String owner, @RequestParam Integer accountId){

            Optional<Account> accountToTransfer = accountRepository.findById(accountId);

            if (accountToTransfer.isPresent()&&(accountToTransfer.get().getPrimaryOwner().equals(owner) || accountToTransfer.get().getSecondaryOwner().equals(owner))){

                if (account.getBalance().getAmount().compareTo(balance)<0){
                    System.out.println("Insufficient funds on account.");
                }
                else if (!Objects.equals(account.getBalance().getCurrency(), accountToTransfer.get().getBalance().getCurrency())){
                    System.out.println("Accounts have different currencies.");
                }
                else if (account.getStatus() != AccountStatus.ACTIVE){
                    System.out.println("Account is not active.");
                }
                else if (account.getLastTransactionTime().getSecondOfMinute() == LocalTime.now().getSecondOfMinute()){
                    account.setStatus(AccountStatus.FROZEN);
                    System.out.println("Illegal transaction");
                }
                else {
                    account.setBalance(new Money(account.getBalance().getAmount().subtract(balance),account.getBalance().getCurrency()));
                    accountToTransfer.get().setBalance(new Money(accountToTransfer.get().getBalance().getAmount().add(balance),accountToTransfer.get().getBalance().getCurrency()));
                    account.setLastTransactionTime(LocalTime.now());
                }
            }
            else {
                System.out.println("Invalid input data");
            }
        }


}
