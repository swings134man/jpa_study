package first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/************
* @info : JPA 영속성 상태 설명 Class
* @name : Jpa_Context
* @date : 2022/09/10 12:41 AM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
public class Jpa_Context {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2"); // Entity Factory

        EntityManager em = emf.createEntityManager(); // EntityManager

        EntityTransaction tx = em.getTransaction(); //Trasaction Get
        tx.begin(); // Transaction start

        try {

            // 비영속 상태
            Member member = new Member();
            member.setId(100L);
            member.setName("Context_Test");

            // 영속
            /*
            1. 영속성 컨텍스트에 의해 관리가 되는 시점.
            2. DB에 저장이 되는 상태가 아님.
            3. 실행시 before, after 사이에 Query가 발생하지 않음
               -> 영속되었다고 해서 DB에 날라가지 않음
               -> 즉 commit(); 시에 DB에 쿼리가 날라가게됨.
             */
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");

            // 1차 캐시 확인
            // 조회시 Select 쿼리 x
            // 이유는 ---> 위에서 persist() 당시 1차 캐시에 캐싱됬기 때문에 DB조회할 필요가 없음.
            // 두번째 조회는 캐싱되어있지 않기 때문에 DB에서 조회함- ---> Select query 발생.
            Member member1 = em.find(Member.class, 100L);
            //Member member2 = em.find(Member.class, 101L);
            System.out.println("find id : " + member1.getId());
            System.out.println("find name : " + member1.getName());

            // flush
            // 플러쉬를 호출하게 되면
            // commit 되기전에 DB 에 쿼리를 보내게 됨.
//            Member memberF = new Member(300L, "Flush-test");
//            em.persist(memberF);
//            em.flush(); // 즉시 쿼리 실행. 


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }//main
}//class
