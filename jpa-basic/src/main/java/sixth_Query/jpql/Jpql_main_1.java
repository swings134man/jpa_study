package sixth_Query.jpql;


import sixth_Query.Six_member;

import javax.persistence.*;
import java.util.List;

/************
 * @info : JPQL - Basic MAIN 1
 * @name : Jpql_main_1
 * @date : 2023/02/19 7:11 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : JPQL 연계 테스트 main - 기본적인 파라미터 바인딩, 결과 Return
 *
 * - 겁색결과
 * - 결과가 하나 이상일떄 : .getResultList()
 * - 결과가 정확히 하나일때 : getSingleResult() -> 결과가없으면(NoResultException), 둘이상 결과면(NonUniqueResultException)
 *
 * - 파라미터 바인딩.
 *
 *
 ************/
public class Jpql_main_1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Logic
        try {

//            Jp_member member = new Jp_member();
//            member.setUsername("member2");
//            member.setAge(10);
//            em.persist(member);


            // 파라미터 바인딩.
            // :파라미터명 , setParameter 사용하여 파라미터명, 파라미터 값 세팅.
            // 파라미터 바인딩시 위치 기준도 존재함 setParamter(1, "~") -> 장애 발생의 요소, 사용하면 좋지않음.
//            Jp_member singleResult = em.createQuery("select m from Jp_member m where m.username = :username", Jp_member.class)
//                    .setParameter("username", "member1")
//                    .getSingleResult();
//            System.out.println("singleResult : " + singleResult.getUsername());


            // 결과 받기
//            TypedQuery<Six_member> query = em.createQuery("select m from Six_member m where id=1", Six_member.class);
            // Spring Data JPA -> 결과가 없을 경우 (null), 혹은 Optional 반환.
            // singelResult의경우 try/catch 사용. Exception 발생 경우가 많아짐.
//            Six_member singleResult = query.getSingleResult(); //결과가 1개인 값.

//            // 타입정보가 확실할 때 사용함.
//            TypedQuery<Six_member> tpQuery1 = em.createQuery("select m from Six_member m", Six_member.class);
//            // 타입정보가 명확하지 않을경우.
//            Query query = em.createQuery("select m.username, m.age from Six_member m");
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }
}
