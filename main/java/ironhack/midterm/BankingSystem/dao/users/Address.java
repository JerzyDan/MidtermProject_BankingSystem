package ironhack.midterm.BankingSystem.dao.users;

import javax.persistence.Embeddable;

/*@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity*/
@Embeddable
public class Address {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;*/

    private String country;
    private String city;
    private String street;
    private String numberOfProperty;
    private String houseNumber;

    public Address(String country, String city, String street, String numberOfProperty, String houseNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.numberOfProperty = numberOfProperty;
        this.houseNumber = houseNumber;
    }

    public Address(String country, String city, String street, String numberOfProperty) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.numberOfProperty = numberOfProperty;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberOfProperty() {
        return numberOfProperty;
    }

    public void setNumberOfProperty(String numberOfProperty) {
        this.numberOfProperty = numberOfProperty;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
