package first;

import javax.persistence.*;
import java.util.Date;

/************
* @info : 요구사항에 맞는 Entity class
* @name : Member3
* @date : 2022/09/20 5:31 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
 *
 * 요구사항
 * 1. 회원은일반회원과관리자로구분해야한다.
 * 2. 회원가입일과수정일이있어야한다.
 * 3. 회원을설명할수있는필드가있어야한다.이필드는길이제 한이 없다.
 *
 * -- RoleType - Enum Class 와 연결.
************/
@Entity
@Table(name = "member3")
public class Member3 {
    @Id
    private Long id;
    @Column(name = "name")
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description; // String 타입이면 clob으로 생성됨.

    @Transient
    private int temp; // DB와 매핑이 되지 않음.
    // 메모리 내에서만 사용하고 싶을때
    // 캐시데이터, 메모리내에 계산 결과 등

    // Const
    public Member3() {
    }

    //get,set
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


