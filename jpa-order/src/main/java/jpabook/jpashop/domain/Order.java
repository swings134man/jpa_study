package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS") //DB에서는 order가 예약어일 경우가 있음.
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId; // 누가 주문했는지 확인해야하기 떄문.

    private LocalDateTime orderDate; // 주문시각

    @Enumerated(EnumType.STRING) // String 필수조건
    private OrderStatus status; // 주문 상태

}
