package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS") //DB에서는 order가 예약어일 경우가 있음.
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    // 연관관계 매핑 -> order 입장에서 member 는 다대일 관계

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery; // Delivery 객체와 1:1 관계

    @Enumerated(EnumType.STRING) // String 필수조건
    private OrderStatus status; // 주문 상태

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate; // 주문시각 -> DB상에선 ORDER_DATE, order_date(DB에 기본 생성형식) 형식임.









    //    @Column(name = "MEMBER_ID")
//    private Long memberId; // 누가 주문했는지 확인해야하기 떄문.

    // 연관관계 편의 메서드
    // 양방향 연관관계에서 orderItems 목록에도 add, OrderItem 객체에도 set
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    // get,set
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
