package users;

import java.util.HashMap;

public class ThirdParty {

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
