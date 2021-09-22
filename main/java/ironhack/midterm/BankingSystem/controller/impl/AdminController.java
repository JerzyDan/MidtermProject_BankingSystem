package ironhack.midterm.BankingSystem.controller.impl;

import ironhack.midterm.BankingSystem.controller.dto.CheckingAccountDTO;
import ironhack.midterm.BankingSystem.controller.interfaces.IAdminController;
import ironhack.midterm.BankingSystem.dao.accounts.Checking;
import ironhack.midterm.BankingSystem.dao.accounts.CreditCard;
import ironhack.midterm.BankingSystem.dao.accounts.Savings;
import ironhack.midterm.BankingSystem.dao.accounts.StudentChecking;
import ironhack.midterm.BankingSystem.repository.accountsRepository.CheckingRepository;
import ironhack.midterm.BankingSystem.repository.accountsRepository.CreditCardRepository;
import ironhack.midterm.BankingSystem.repository.accountsRepository.SavingsRepository;
import ironhack.midterm.BankingSystem.repository.accountsRepository.StudentCheckingRepository;
import ironhack.midterm.BankingSystem.repository.usersRepository.AdminRepository;
import ironhack.midterm.BankingSystem.service.interfaces.ICheckingService;
import ironhack.midterm.BankingSystem.service.interfaces.ICreditCardService;
import ironhack.midterm.BankingSystem.service.interfaces.ISavingService;
import ironhack.midterm.BankingSystem.service.interfaces.IStudentCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class AdminController implements IAdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private ICheckingService iCheckingService;

    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private ISavingService iSavingService;

    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private ICreditCardService iCreditCardService;

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;
    @Autowired
    private IStudentCheckingService iStudentCheckingService;

    //creating accounts
    @PostMapping("/checking")
    @ResponseStatus(HttpStatus.CREATED)
    public Checking checkingStored (@RequestBody @Valid Checking checking){
        return checkingRepository.save(checking);
    }

    @PostMapping("/studentchecking")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentChecking studentCheckingStored (@RequestBody @Valid StudentChecking studentChecking){
        return studentCheckingRepository.save(studentChecking);
    }

    @PostMapping("/checkingaccount")
    @ResponseStatus(HttpStatus.CREATED)
    public void checkingStored (@RequestBody @Valid CheckingAccountDTO checkingAccountDTO){
        if (checkingAccountDTO.getOwnerAge(checkingAccountDTO.getPrimaryOwner())<24){
            studentCheckingRepository.save(checkingAccountDTO);
        }
        else checkingRepository.save(checkingAccountDTO);
    }

    @PostMapping("/savings")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings savingsSored (@RequestBody @Valid Savings savings){
        return savingsRepository.save(savings);
    }

    @PostMapping("/creditcard")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard creditCardStored(@RequestBody @Valid CreditCard creditCard){
        return creditCardRepository.save(creditCard);
    }



    @GetMapping("/checking/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Checking getCheckingById(@PathVariable(name = "id")Integer checkingId){
        Optional<Checking> optionalChecking = checkingRepository.findById(checkingId);
        return optionalChecking.isPresent() ? optionalChecking.get() : null;
    }

    @GetMapping("/savings/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Savings getSavingById(@PathVariable(name = "id") Integer savingId){
        Optional<Savings> optionalSavings = savingsRepository.findById(savingId);
        return optionalSavings.isPresent() ? optionalSavings.get() : null;
    }

    @GetMapping("/creditcard/{id}")
    public CreditCard getCreditcardById(@PathVariable(name = "id")Integer creditcardId){
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(creditcardId);
        return optionalCreditCard.orElse(null);
    }

    @GetMapping("/studentchecking/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentChecking getStudentCheckingById(@PathVariable(name = "id") Integer studentCheckingId){
        Optional<StudentChecking> optionalStudentChecking = studentCheckingRepository.findById(studentCheckingId);
        return optionalStudentChecking.orElse(null);
    }

    @PatchMapping("/checking/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCheckingBalance(@PathVariable(name = "id") Integer checkingId, @RequestBody @Valid BigDecimal newBalance){
        iCheckingService.updateCheckingBalance(checkingId,newBalance);
    }

    @PatchMapping("/savings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSavingBalance(@PathVariable(name = "id") Integer savingId, @RequestBody @Valid BigDecimal newBalance){
        iSavingService.updateSavingBalance(savingId,newBalance);
    }

    @PatchMapping("/creditcard/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCreditCardBalance(@PathVariable(name = "id") Integer creditCardId, @RequestBody @Valid BigDecimal newBalance){
        iCreditCardService.updateCreditCardBalance(creditCardId,newBalance);
    }

    @PatchMapping("/studentchecking/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudentCheckingBalance(@PathVariable(name = "id") Integer studentCheckingId, @RequestBody @Valid BigDecimal newBalance){
        iStudentCheckingService.updateStudentCheckingBalance(studentCheckingId,newBalance);
    }
}
