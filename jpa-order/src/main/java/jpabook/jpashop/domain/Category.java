package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    // Item 테이블과 N:M 관계

    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent; // 상위 카테고리

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    // Item Table 연관
    @ManyToMany
    // 중간 테이블 만드는 작업 코드
    @JoinTable(name = "CATEGORY_ITEM",
                joinColumns = @JoinColumn(name = "CATEGORY_ID"),    // 내가 join 하는 FK 잡는 ID 컬럼
                inverseJoinColumns = @JoinColumn(name = "ITEM_ID") // 반대 쪽이 Join 하는 컬럼
    )
    private List<Item> items = new ArrayList<>();


}
