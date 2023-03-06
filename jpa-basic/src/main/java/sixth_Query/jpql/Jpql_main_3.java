package sixth_Query.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/************
 * @info : JPQL - Paging 관련 및 Fetch join의 한계
 * @name : Jpql_main_3
 * @date : 2023/03/06 4:13 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 *
 * - 페치 조인은 객체 그래프를 유지할 때 사용하면 효과적 (m member.team)
 *
 * - 여러 테이블을 join 해서 엔티티가 가진 모양이 아닌 전혀 다른 결과를 내야하면.
 *   -> fetch join 보다는 일반 Join을 사용, 필요한 데이터만 조회해서 DTO로 반환하는것이 효과적.
 ************/
public class Jpql_main_3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            /**
             * 페이징 관련
             * 1. fetch join 에는 별칭 사용X
             */
//            String query = "select t from Jp_team t join fetch t.members";
            // 이럴 경우 '경고' 메세지와 함께 결과를 메모리에 적재함. -> 페이징 쿼리는 생성되지 않고
            // -> 모든 데이터를 조회후 메모리에적재 -> 메모리상에서 페이징을 하려고 시도함. (위험)
//            List<Jp_team> resultList = em.createQuery(query, Jp_team.class)
//                    .setFirstResult(0)
//                    .setMaxResults(1)
//                    .getResultList();

            // 해결법 1. from 절을 뒤집는다(join 절) - 방향 전환
            // 다대일로 바뀌는 순간 페이징에는 문제가 없다. (member join team)
            String query2 = "select m from Jp_member m join fetch m.team";

            // 해결법 2. Batch size (배치사이즈 1천이하 조절.)

            // 해결법 3. DTO로 직접 조회. -> 하지만 정제 해줘야할 부분이 생김.


            tx.commit();
        }catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }
}
