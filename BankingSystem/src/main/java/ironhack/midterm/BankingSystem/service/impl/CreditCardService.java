package ironhack.midterm.BankingSystem.service.impl;

import ironhack.midterm.BankingSystem.dao.accounts.CreditCard;
import ironhack.midterm.BankingSystem.dao.accounts.Money;
import ironhack.midterm.BankingSystem.repository.accountsRepository.CreditCardRepository;
import ironhack.midterm.BankingSystem.service.interfaces.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CreditCardService implements ICreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    public void updateCreditCardBalance(Integer id, BigDecimal newBalance){
        Optional<CreditCard> storedCreditCard = creditCardRepository.findById(id);
        if (storedCreditCard.isPresent()){
            storedCreditCard.get().setBalance(new Money(newBalance,storedCreditCard.get().getCreditCardBalance().getCurrency()));
            creditCardRepository.save(storedCreditCard.get());
        }
    }
}
