package first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/************
* @info : JPA(Hibernate) 기본 사용 템플릿
* @name : JpaBasic
* @date : 2022/09/07 11:41 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
public class JpaBasic {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");

        EntityManager em = emf.createEntityManager();

        // JPA에서는 Transaction안에서 모든것이 이루어져야함. -> Spring이 대부분의 것을 해줌.
        EntityTransaction tx = em.getTransaction(); // DB 커넥션에서 트랜잭션가져옴.
        tx.begin(); // 트랜잭션 시작

        try{
            // code - 실제 동작하는 코드가 들어가는 부분
            // save() , -> persist(); 필수
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("spring2");

            // Member Find
            Member findMember = em.find(Member.class, 1L);

            // JPQL
            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList(); // List 모든 결과값 get

            // Member Update
            // Find로 조회해온값에 다시 set 해주고 commit 만 해주면 끝.
            // -> Java Collection을 다루듯 객체의 속성만 변경. 즉 update & delete 는 persist() 가 필요하지 않음.
            //findMember.setName("HelloJPA");


            // Member Delete
            // delete 또한 검색해온 값을 그대로 remove 안에 넣어주면 삭제됨.
            //em.remove(findMember);

           //em.persist(member);

            tx.commit(); //트랜잭션의 상태를 commit
        }catch (Exception e){
            tx.rollback(); // 트랜잭션에 문제가 발생했을때 RollBack 수행.
        }finally {
            em.close(); // 커넥션 close
        }
        emf.close();
    } //main
}//class
