package problems.nPlus1;

import javax.persistence.*;

/************
 * @info : N+1 문제 - order entity
 * @name : N_team
 * @date : 2023/02/20 6:30 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 여러개의 Orders는 하나의 Member와 매핑됨 ManyToOne (N:1)
 ************/
@Entity
public class N_orders {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private N_member member;


    // Getter Setter toString
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public N_member getMember() {
        return member;
    }

    public void setMember(N_member member) {
        this.member = member;
    }

    // toString 으로 인한 StackOverFlow 해결 code
    @Override
    public String toString() {
        return "N_orders{" +
                "id=" + id +
                ",memberId=" + member.getId() +
                '}';
    }

    // toString 자동 생성 code -> member= member(참조) 를 toString 하는과정에서 member를 다시 참조 -> 검색하게 됨.
    // 결과적으로 member에서 orders toString 호출 -> orders에서 member 를 다시 참조 -> member에서 toString 호출 -> 무한반복
    // -> Stack Over Flow 발생함.
//    @Override
//    public String toString() {
//        return "N_orders{" +
//                "id=" + id +
//                ", member=" + member +
//                '}';
//    }
}
