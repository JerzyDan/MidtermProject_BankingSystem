package ironhack.midterm.BankingSystem.repository.accountsRepository;

import ironhack.midterm.BankingSystem.dao.accounts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Integer> {
}
