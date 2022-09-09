package first;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member2")
public class Member {

    @Id
    private Long id;
    @Column(name = "name")
    private String name;

    // 기본 생성자
    public Member() {
    }

    // 생성자 overroading --> 객체 생성시 변수로 저장하게 하기 위함.
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
