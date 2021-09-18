package ironhack.midterm.BankingSystem.dao.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class AccountHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String dateOfBirth;
    private Address address;
    private String mailingAddress;

    public AccountHolder(String name, String dateOfBirth, Address address, String mailingAddress) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.mailingAddress = mailingAddress;
    }

    public AccountHolder(String name, String dateOfBirth, Address address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
