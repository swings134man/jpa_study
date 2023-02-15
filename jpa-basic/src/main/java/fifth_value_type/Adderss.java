package fifth_value_type;

import javax.persistence.Embeddable;

/************
 * @info : JPA Embedded 값 타입 - 주소 공통 Class
 * @name : Zipcode
 * @date : 2023/02/15 6:41 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : FiMember 의존중, Another Entity dependecy allow
 ************/
@Embeddable // 값 타입 정의 하는곳
public class Adderss {

    private String city;
    private String street;
    private String zipcode;


    // constructor
    public Adderss() {

    }

    public Adderss(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
