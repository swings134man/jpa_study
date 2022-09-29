package third_inheritance;


import javax.persistence.*;

/************
* @info : 상속관계 매핑 - item entity class
* @name : Item
* @date : 2022/09/28 5:57 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // 이부분만 변경시 join, 단일, 각테이블 전략으로 변경 가능.
@DiscriminatorColumn
public class Item extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
