package fourth_proxy;

import javax.persistence.*;

/************
* @info : Proxy FMEMBER CLASS
* @name : FMember
* @date : 2022/09/30 5:38 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Entity
public class FMember {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY) // 지연로딩 LAZY -> 아래의 team을 프록시 객체로 조회함 -> member class만 조회함
    @JoinColumn(name = "TEAM_ID")
    private FTeam team;

    //get set

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

    public FTeam getTeam() {
        return team;
    }

    public void setTeam(FTeam team) {
        this.team = team;
    }
}
