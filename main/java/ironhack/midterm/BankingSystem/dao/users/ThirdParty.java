package ironhack.midterm.BankingSystem.dao.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class ThirdParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private HashMap<String,String> thirdParty;

    public ThirdParty(HashMap<String, String> thirdParty) {
        this.thirdParty = thirdParty;
    }

    public HashMap<String, String> getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(HashMap<String, String> thirdParty) {
        this.thirdParty = thirdParty;
    }
}
