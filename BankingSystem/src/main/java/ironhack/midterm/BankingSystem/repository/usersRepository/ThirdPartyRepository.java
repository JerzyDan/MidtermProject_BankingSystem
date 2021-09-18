package ironhack.midterm.BankingSystem.repository.usersRepository;

import ironhack.midterm.BankingSystem.dao.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty,Integer> {
}
