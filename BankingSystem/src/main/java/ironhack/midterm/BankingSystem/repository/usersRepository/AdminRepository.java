package ironhack.midterm.BankingSystem.repository.usersRepository;

import ironhack.midterm.BankingSystem.dao.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
