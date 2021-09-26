package ironhack.midterm.BankingSystem.service.impl;

import ironhack.midterm.BankingSystem.dao.users.AccountHolder;
import ironhack.midterm.BankingSystem.repository.usersRepository.AccountHolderRepository;
import ironhack.midterm.BankingSystem.repository.usersRepository.AdminRepository;
import ironhack.midterm.BankingSystem.repository.usersRepository.ThirdPartyRepository;
import ironhack.midterm.BankingSystem.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{

        Optional<AccountHolder> user = accountHolderRepository.findByName(name);
        if (user.isEmpty()){
            throw new UsernameNotFoundException("User "+name+" not found.");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(user.get());
        return customUserDetails;
    }
}
