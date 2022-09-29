package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/************
* @info : item 객체 하위에 movie, book, album 객체 존재
* @name : Item
* @date : 2022/09/29 5:07 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
 *
 * 상속관계 매핑 이전은 main 테이블이었지만
 * 2022.09.29 일자 기준
 * 하위 3개 테이블을 단일테이블로 구성 -> SINGLE_TABLE
 * --> 즉 ITEM만 단독으로 테이블에 저장할 일이 없으므로 abstract class 가 되는것.
 * ---> 하위 3개 테이블중 하나 이상을 무조건 같이 사용함.
************/
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class Item extends BaseEntity{

    // Category 테이블과 N:M 관계

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price; // 가격
    private int stockQuantity; // 수량

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();


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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
