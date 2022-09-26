package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2"); // manager factory

        EntityManager em = emf.createEntityManager(); // manager

        EntityTransaction tx = em.getTransaction(); //transaction
        tx.begin();

        // Transaction strart
        try {

            // 예시 코드 -> 기본 테이블 생성
            Order order = new Order();
            order.addOrderItem(new OrderItem());

            // 추가 공부 -> 실제 테이블에 값 넣어보기. 



            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }//main
}
