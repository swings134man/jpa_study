package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class jpaMain {
    public static void main(String[] args) {
        //drop table DELIVERY,ITEM,MEMBER,CATEGORY cascade constraints;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2"); // manager factory

        EntityManager em = emf.createEntityManager(); // manager

        EntityTransaction tx = em.getTransaction(); //transaction
        tx.begin();

        // Transaction strart
        try {

            // 예시 코드 -> 기본 테이블 생성
//            Order order = new Order();
//            order.addOrderItem(new OrderItem());

            // 추가 공부 -> 실제 테이블에 값 넣어보기. 


            // 상속관계 매핑 item table (하위3개 테이블)
            Book book = new Book();
            book.setName("JPA");
            book.setPrice(10000);
            book.setAuthor("김영한");

            // BaseEntity
            book.setCreatedBy("Kang");
            book.setCreatedDate(LocalDateTime.now());
            em.persist(book);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }//main
}
