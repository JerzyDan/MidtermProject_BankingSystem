package ironhack.midterm.BankingSystem.repository.usersRepository;

import ironhack.midterm.BankingSystem.dao.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder,Integer> {
}
