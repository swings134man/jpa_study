package jpabook.jpashop.domain;

import javax.persistence.Embeddable;

/************
* @info : 임베디드 값타입 정의 주소 클래스
* @name : Address
* @date : 2022/10/21 6:29 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Embeddable
public class Address {

    private String city;
    private String street;
    private String zipcode;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
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
}
