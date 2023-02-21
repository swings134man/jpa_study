package problems.nPlus1;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/************
 * @info : N+1 문제 - member entity
 * @name : N_member
 * @date : 2023/02/20 6:30 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 하나의 memebr는 여러개의 orders 를 가짐 -> OneToMany (1:N)
 ************/
@Entity
public class N_member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String userName;


    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<N_orders> orders = new ArrayList<>();



    // Getter Setter toString
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<N_orders> getOrders() {
        return orders;
    }

    public void setOrders(List<N_orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "N_member{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", orders=" + orders +
                '}';
    }
}
