package experiment.entity;

import javax.persistence.*;

/************
 * @info : Test - reply
 * @name : Ereply
 * @date : 2023/03/04 3:50 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
@Entity
public class Ereply {

    @Id @GeneratedValue
    @Column(name = "REPLY_ID")
    private Long replyId;
    private String content;

    // board
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Eboard board;


    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Eboard getBoard() {
        return board;
    }

    public void setBoard(Eboard board) {
        this.board = board;
    }
}
