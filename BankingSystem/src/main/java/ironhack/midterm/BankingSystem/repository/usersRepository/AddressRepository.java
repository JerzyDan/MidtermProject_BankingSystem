package ironhack.midterm.BankingSystem.repository.usersRepository;

import ironhack.midterm.BankingSystem.dao.users.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
