package jpabook.jpashop;

import jpabook.jpashop.domain.Order;

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

            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }//main
}
