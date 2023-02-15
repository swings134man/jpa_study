package fifth_value_type;

import third_inheritance.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

/************
 * @info : JPA - Embedded Value type Entity
 * @name : FiMember
 * @date : 2023/02/15 6:27 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
@Entity
public class FiMember {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    // 기간 - Period
    @Embedded // 값타입을 사용하는곳에 정의
    private Period workPeriod; // = null; 이면 해당 Column의 값은 모두 NULL로 저장된다.

    // 주소 - Adderss
    @Embedded
    private Adderss homeAdderss;

    // @AttributeOveride : 컬럼명 속성 재정의 하는것.
    // 기존의 homeAddress 의 컬럼명이 DB 에서 중복되는것을 막기위함.
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))})
    private Adderss workAdderss;





    // Getter, setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Adderss getHomeAdderss() {
        return homeAdderss;
    }

    public void setHomeAdderss(Adderss homeAdderss) {
        this.homeAdderss = homeAdderss;
    }

    public Adderss getWorkAdderss() {
        return workAdderss;
    }

    public void setWorkPeriod(Adderss workAdderss) {
        this.workAdderss = workAdderss;
    }
}
