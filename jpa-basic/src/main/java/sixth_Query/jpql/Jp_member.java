package sixth_Query.jpql;

import javax.persistence.*;

/************
 * @info : JPQL - Entity - member
 * @name : Jp_member
 * @date : 2023/02/19 7:24 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Jp_team Entity 와 양방향
 ************/
@Entity
public class Jp_member {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Jp_team team;

    public void changedTeam(Jp_team team) {
        this.team = team;
        team.getMembers().add(this);
    }


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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Jp_member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
