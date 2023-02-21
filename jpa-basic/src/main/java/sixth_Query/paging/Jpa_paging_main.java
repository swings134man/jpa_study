package sixth_Query.paging;

import sixth_Query.jpql.Jp_member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/************
 * @info : JPA Paging main Class
 * @name : Jpa_paging_main
 * @date : 2023/02/22 1:49 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 각 DB에 따른 페이징 쿼리를 JPA가 만들어서 처리해줌.
 *
 *  - MySQL 같은 경우 -> ORDER BY m.name DESC LIMIT ?, ?
 *  - Oracle -> 3뎁스, Oracle 페이징 기본 표준 쿼리임.
 *   SELECT * FROM
 *          ( SELECT ROW_.*, ROWNUM ROWNUM_
 *            FROM
 *            ( SELECT
 *                  m.id as ID,
 *                  m.age as AGE,
 *                  m.TEAD_ID as TEAM_ID,
 *                  m.name as NAME
 *             FROM member m
 *             ORDER BY m.name
 *            )
 *            ROW_ WHERE ROWNUM <= ?)
 *            WHERE ROWNUM_ > ?
 ************/
public class Jpa_paging_main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            // Jp_member 사용
//            for (int i = 3; i < 50; i++) {
//                Jp_member member = new Jp_member();
//                member.setUsername("member" + i);
//                member.setAge(i);
//                em.persist(member);
//            }
//
//            em.flush();
//            em.clear();

            List<Jp_member> resultList = em.createQuery("select m from Jp_member m order by m.age desc"
                            , Jp_member.class)
                    .setFirstResult(30) // 조회 시작 위치
                    .setMaxResults(10) // 조회할 데이터 수
                    .getResultList();

            System.out.println("result size = " + resultList.size());
            for (Jp_member members: resultList) {
                System.out.println("member1= " + members);
            }



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
