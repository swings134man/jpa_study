package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity{

    // order 테이블과 1:1 관계

    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    private DeleveryStatus status; //enum

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
}
