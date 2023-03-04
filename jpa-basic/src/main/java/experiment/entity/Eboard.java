package experiment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/************
 * @info : Test - Board 클래스
 * @name : Eboard
 * @date : 2023/03/04 3:48 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
@Entity
public class Eboard {

    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long boardId;
    private String title;

    // member
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_NO")
    private Emember member;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Ereply> replys = new ArrayList<>();

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Emember getMember() {
        return member;
    }

    public void setMember(Emember member) {
        this.member = member;
    }

    public List<Ereply> getReplys() {
        return replys;
    }

    public void setReplys(List<Ereply> replys) {
        this.replys = replys;
    }
}
