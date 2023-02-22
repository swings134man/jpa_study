package sixth_Query.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/************
 * @info : JOIN 관련 JPQL MAIN CLASS
 * @name : Jpql_main_2
 * @date : 2023/02/23 1:03 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class Jpql_main_2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // Jp_member
            // 생성
//                Jp_team team = new Jp_team();
//                team.setName("A");
//                em.persist(team);
//
//                Jp_member member = new Jp_member();
//                member.setUsername("A");
//                member.setAge(10);
//                member.changedTeam(team);
//                em.persist(member);
//
//                em.flush();
//                em.clear();

//            List<Jp_member> resultList =
//                    em.createQuery("select m from Jp_member m left join m.team t"
//                            , Jp_member.class)
//                            .getResultList();


            // 세타 조인 - cross 조인 -> 카테시안 곱
            // 만약 team name 과 member 의 name이 같다면 list.size = 1 이 나옴.
//            List<Jp_member> resultList =
//                    em.createQuery("select m from Jp_member m, Jp_team t where m.username=t.name"
//                    , Jp_member.class).getResultList();

            /*
                ON 절
                - 연관관계가 없는 엔티티 외부 조인 가능(하이버네이트 5.1 이상버전)
                - 조인대상 필터링 기능
             */

            // - 조인대상 필터링 : 회원과 팀을 조인하면서 팀이름이 A인 팀만 조인
            String ql = "select m from Jp_member m left join m.team t on t.name = 'A'";
//            List<Jp_member> resultList = em.createQuery(ql, Jp_member.class).getResultList();


            // 연관관계가 없는 엔티티 외부 조인
            String ql2 = "select m from Jp_member m left join Jp_team t on m.username = t.name";
//            List<Jp_member> resultList = em.createQuery(ql2, Jp_member.class).getResultList();
//            System.out.println("size: " + resultList.get(2).getUsername());
//            for(Jp_member member : resultList){
//                System.out.println(member);
//            }

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
