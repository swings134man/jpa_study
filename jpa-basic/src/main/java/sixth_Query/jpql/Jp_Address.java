package sixth_Query.jpql;

import javax.persistence.Embeddable;


/************
 * @info : Embedded 값타입 -
 * @name : Jp_Address
 * @date : 2023/02/19 7:26 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 
 ************/
@Embeddable
public class Jp_Address {
    
    private String city;
    private String street;
    private String zipcode;

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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
