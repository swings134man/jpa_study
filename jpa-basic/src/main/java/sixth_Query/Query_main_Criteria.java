package sixth_Query;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/************
 * @info : Criteria - 객체 지향 SQL main Class
 * @name : Query_main_Criteria
 * @date : 2023/02/16 7:32 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Java Code 로 SQL Query 를 짜는것.
 *
 * 장점 : 동적 쿼리를 짜기 편하다. - Java COde로 JPQL을 작성 할 수 있다, JPQL 빌더 역할이다.
 * 단점 : 실무에서는 사용이 어려움 -> 가독성이 어려워 유지보수가 어렵다.
 *      -> JPQL 보다 어렵다.
 *      -> Criteira 대신에 QueryDSL 사용을 권장한다.
 ************/
public class Query_main_Criteria {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Logic - Criteria
        try {

            // Criteria 사용 준비
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Six_member> query = cb.createQuery(Six_member.class);

            // 쿼리를 코드로 생성함.
            Root<Six_member> m = query.from(Six_member.class);

            CriteriaQuery<Six_member> cq = query.select(m);

            // 동적 쿼리 - 조건에 따라 쿼리문 변경
            // 컴파일 시점에 Error 를 잡아준다.
            String username = "asdasd";
            if(username != null) {
                cq = cq.where(cb.equal(m.get("userName"), "kim"));
            }

            List<Six_member> resultList = em.createQuery(cq).getResultList();


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }//main
}
