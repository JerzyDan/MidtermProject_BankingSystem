package ironhack.midterm.BankingSystem.repository.accountsRepository;

import ironhack.midterm.BankingSystem.dao.accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking,Integer> {
}
