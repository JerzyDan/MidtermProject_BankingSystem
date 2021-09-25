package ironhack.midterm.BankingSystem.repository.accountsRepository;

import ironhack.midterm.BankingSystem.dao.accounts.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
