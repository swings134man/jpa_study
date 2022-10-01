package fourth_proxy_Loading;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/************
* @info : Proxy - 지연로딩 - 즉시로딩 main class
* @name : Jpa_Proxy_main
* @date : 2022/09/30 5:37 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
public class Jpa_Proxy_main {
    public static void main(String[] args) {

        // drop table item, book, album, movie, board, member, member2, member3 cascade;
        //drop table item, book, album, movie, member2, member3, team,tmember cascade;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // Proxy 객체
//            FMember member = new FMember();
//            member.setName("prprpr");
//            em.persist(member);
//
//            em.flush();
//            em.clear();

//            System.out.println("=========BEFORE=========");

            // 실제 값 조회가 이루어지기 전까진 쿼리 X
//            FMember ref = em.getReference(FMember.class, 1L); //Proxy 객체 - 초기화 전
//            System.out.println("=========AFTER=========");

//            System.out.println("userName = " + ref.getName()); // 프록시 초기화 -> 값이 없는것을 조회하니까
//            System.out.println("Proxy : " + ref.getClass()); // 프록시 객체 확인 -> Proxy : class fourth_proxy.FMember$HibernateProxy$aIH7aauQ
//            System.out.println("Proxy 객체 확인2 : " +  emf.getPersistenceUnitUtil()); // 프록시 객체 확인 2번째 방법

            // 객체 보장원칙
//            FMember findMember = em.find(FMember.class, 1L); // 실제 객체
//            System.out.println(findMember.getClass()); //
//            System.out.println("proxty == Entity : " + (ref.getClass() == findMember.getClass())); // true
            // 실제 객체 -> em.find 먼저 실행 후
            // Proxy 객체 -> em.getRefernce 실행하면 프록시 객체가 아닌 실제 Entity가 반환됨.




            tx.commit();
        }catch (Exception e){

            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }//main
}
