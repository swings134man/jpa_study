package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    // 예제이기때문에 사용함 -> 비지니스 적으로는 사용할 필요가 없는 코드 .
    @OneToMany(mappedBy = "member") // 양방향 member객체에게 권한 위임.
    private List<Order> orders = new ArrayList<>();

    // 임베디드 타입
    // 기간 Period
    // @Embedded 어노테이션은 @Embeddable를 써놨으면 없어도 된다.
    @Embedded
    private Period workPeriod;

    // 주소
    @Embedded
    private Address homeAddress;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
