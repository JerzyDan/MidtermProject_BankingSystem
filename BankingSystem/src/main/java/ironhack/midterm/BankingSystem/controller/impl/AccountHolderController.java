package ironhack.midterm.BankingSystem.controller.impl;

import ironhack.midterm.BankingSystem.controller.interfaces.IAccountHolderController;
import ironhack.midterm.BankingSystem.repository.accountsRepository.CheckingRepository;
import ironhack.midterm.BankingSystem.repository.usersRepository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountHolderController implements IAccountHolderController {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    CheckingRepository checkingRepository;
}
