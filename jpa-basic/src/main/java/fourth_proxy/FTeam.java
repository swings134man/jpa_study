package fourth_proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/************
* @info : Proxy Team Class
* @name : FTeam
* @date : 2022/09/30 5:37 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Entity
public class FTeam {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team")
    private List<FMember> members = new ArrayList<>();

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

    public List<FMember> getMembers() {
        return members;
    }

    public void setMembers(List<FMember> members) {
        this.members = members;
    }
}
