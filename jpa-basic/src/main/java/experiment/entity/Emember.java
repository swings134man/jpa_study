package experiment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/************
 * @info : Test - member
 * @name : Emember
 * @date : 2023/03/04 3:52 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
@Entity
public class Emember {

    @Id @GeneratedValue
    @Column(name = "MEMBER_NO")
    private Long id;
    private String name;


    // board
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Eboard> boards = new ArrayList<>();


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

    public List<Eboard> getBoards() {
        return boards;
    }

    public void setBoards(List<Eboard> boards) {
        this.boards = boards;
    }
}
