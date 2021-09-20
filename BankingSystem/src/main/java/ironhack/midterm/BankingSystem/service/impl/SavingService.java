package ironhack.midterm.BankingSystem.service.impl;

import ironhack.midterm.BankingSystem.dao.accounts.Money;
import ironhack.midterm.BankingSystem.dao.accounts.Savings;
import ironhack.midterm.BankingSystem.repository.accountsRepository.SavingsRepository;
import ironhack.midterm.BankingSystem.service.interfaces.ISavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class SavingService implements ISavingService {

    @Autowired
    SavingsRepository savingsRepository;

    public void updateSavingBalance(Integer id, BigDecimal newBalance){
        Optional<Savings> storedSaving = savingsRepository.findById(id);
        if (storedSaving.isPresent()){
            storedSaving.get().setBalance(new Money(newBalance,storedSaving.get().getBalance().getCurrency()));
            savingsRepository.save(storedSaving.get());
        }
    }
}
