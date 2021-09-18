package ironhack.midterm.BankingSystem.repository.accountsRepository;

import ironhack.midterm.BankingSystem.dao.accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking,Integer> {
}
