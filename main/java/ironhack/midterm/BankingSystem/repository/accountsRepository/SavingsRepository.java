package ironhack.midterm.BankingSystem.repository.accountsRepository;

import ironhack.midterm.BankingSystem.dao.accounts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings,Integer> {
}
