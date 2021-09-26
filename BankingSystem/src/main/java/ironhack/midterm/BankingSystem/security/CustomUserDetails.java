package ironhack.midterm.BankingSystem.security;

import ironhack.midterm.BankingSystem.dao.users.AccountHolder;
import ironhack.midterm.BankingSystem.dao.users.Admin;
import ironhack.midterm.BankingSystem.dao.users.ThirdParty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private AccountHolder accountHolder;
    private Admin admin;
    private ThirdParty thirdParty;

    public CustomUserDetails(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }

    public CustomUserDetails(Admin admin) {
        this.admin = admin;
    }

    public CustomUserDetails(ThirdParty thirdParty) {
        this.thirdParty = thirdParty;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
