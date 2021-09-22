package ironhack.midterm.BankingSystem.service.impl;

import ironhack.midterm.BankingSystem.dao.accounts.Money;
import ironhack.midterm.BankingSystem.dao.accounts.StudentChecking;
import ironhack.midterm.BankingSystem.repository.accountsRepository.StudentCheckingRepository;
import ironhack.midterm.BankingSystem.service.interfaces.IStudentCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class StudentCheckingService implements IStudentCheckingService {

    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    public void updateStudentCheckingBalance(Integer id, BigDecimal newBalance){
        Optional<StudentChecking> storedStudentChecking = studentCheckingRepository.findById(id);
        if (storedStudentChecking.isPresent()){
            storedStudentChecking.get().setBalance(new Money(newBalance,storedStudentChecking.get().getBalance().getCurrency()));
            studentCheckingRepository.save(storedStudentChecking.get());
        }
    }
}
