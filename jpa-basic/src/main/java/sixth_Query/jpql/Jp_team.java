package sixth_Query.jpql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/************
 * @info : JPQL - Entity - Team
 * @name : Jp_team
 * @date : 2023/02/19 7:24 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Jp_member 와 양방향
 ************/
@Entity
public class Jp_team {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Jp_member> members = new ArrayList<>();

    public List<Jp_member> getMembers() {
        return members;
    }

    public void setMembers(List<Jp_member> members) {
        this.members = members;
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
