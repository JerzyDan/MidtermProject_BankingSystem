package ironhack.midterm.BankingSystem.service.impl;

import ironhack.midterm.BankingSystem.dao.accounts.Checking;
import ironhack.midterm.BankingSystem.dao.accounts.Money;
import ironhack.midterm.BankingSystem.repository.accountsRepository.CheckingRepository;
import ironhack.midterm.BankingSystem.service.interfaces.ICheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CheckingService implements ICheckingService {

    @Autowired
    CheckingRepository checkingRepository;

    public void updateCheckingBalance(Integer id, BigDecimal newBalance){
        Optional<Checking> storedChecking = checkingRepository.findById(id);
        if (storedChecking.isPresent()){
            storedChecking.get().setBalance(new Money(newBalance,storedChecking.get().getBalance().getCurrency()));
            checkingRepository.save(storedChecking.get());
        }
    }
}
