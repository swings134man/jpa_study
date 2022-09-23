package second;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/************
* @info : 연관관계 매핑을 위한 Team Entity Class
* @name : Team
* @date : 2022/09/22 6:11 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team") // 1:N 관계에서 어떤것이랑 연결이 되어있는지 -> TMember의 객체 변수명인 "team"
    private List<TMember> members = new ArrayList<>(); // 어레이리스트로 초기화 하면 add 할때 npe가 발생하지 않음.


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

    public List<TMember> getMembers() {
        return members;
    }

    public void setMembers(List<TMember> members) {
        this.members = members;
    }
}
