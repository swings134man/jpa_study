package sixth_Query.fetch_join;


import sixth_Query.jpql.Jp_member;
import sixth_Query.jpql.Jp_team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

/************
 * @info : JPQL - Fetch join
 * @name : FetchJoin_main_1
 * @date : 2023/03/03 5:46 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class FetchJoin_main_1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try {

            // Jp_member , Jp_team
//            Jp_team team1 = new Jp_team();
//            team1.setName("A");
//            em.persist(team1);
//
//            Jp_team team2 = new Jp_team();
//            team2.setName("B");
//            em.persist(team2);
//
//
//            Jp_member member1 = new Jp_member();
//            member1.setUsername("회원1");
//            member1.setAge(10);
//            member1.changedTeam(team1);
//            em.persist(member1);
//
//            Jp_member member2 = new Jp_member();
//            member2.setUsername("회원2");
//            member2.setAge(20);
//            member2.changedTeam(team1);
//            em.persist(member2);
//
//            Jp_member member3 = new Jp_member();
//            member3.setUsername("회원3");
//            member3.setAge(30);
//            member3.changedTeam(team2);
//            em.persist(member3);
//
//            em.flush();
//            em.clear();

            /**
             * ManyToOne fetch join
             */
//            String query = "select m from Jp_member m join fetch m.team";
//
//            List<Jp_member> resultList = em.createQuery(query, Jp_member.class).getResultList();
//            for (Jp_member member: resultList) {
//                System.out.println("memberName="+member.getUsername() + ", TeamName=" + member.getTeam().getName());
//            }


            /**
             * OneToMany fetch join - 팀을 기준으로 member를 join
             *
             * Collection join임 -> Team은 member를 Collection 타입으로 가지고 있기때문(List, Map)
             *
             * 1:N 조회의 경우에는 Data가 중복이된다. -> Ex) Team A 의 경우 2명의 회원이 존재 할 때,
             * 1번 조회시 -> 회원 2명 조회
             * 2번 조회 -> 회원이 2명이니까 2번조회함.
             * --> 하지만 결국 결과가 같은 결과(data)의 값이 중복되게 된다. 1:(회원1,회원2), 2:(회원1, 회원2)
             *
             * *** N:1 조회의 경우에는 데이터 중복이 발생하지 않음!!!!!
             */

            // Team A 에 속한 회원이 2명 -> 데이터가 중복 : Team A의 결과가 2개임(회원이2명이기 때문) -> 회원1, 회원2가 Team A 에 속해있기 떄문이다.
            String qu = "select t from Jp_team t join fetch t.members ";// 결과가 중복됨!, 결과가 3개가 출력됨.

            // SQL에서 distinct 는 데이터가 완전 같아야 중복 제거를 해주지만, 여기의 경우 그럴수가 없음(멤버의 이름, 아이디도 다르기 때문)
            // 그 결과 JPA 에서 같은 식별자를 가진 Team 엔티티를 제거해준다.
            // --> JPA에서 중복된 Collection 을 제거 해준다. -> 에플리케이션에서 중복 제거 시도 함.
            /*
            결과
            team=A, members=2
                ----> members= Jp_member{id=17, username='회원1', age=10}
                ----> members= Jp_member{id=18, username='회원2', age=20}
            team=B, members=1
                ----> members= Jp_member{id=19, username='회원3', age=30}
             */
            String qu2 = "select DISTINCT t from Jp_team t join fetch t.members ";

            List<Jp_team> resultList = em.createQuery(qu2, Jp_team.class).getResultList();
            for (Jp_team team: resultList) {
                System.out.println("team="+team.getName() + ", members="+team.getMembers().size());
                for (Jp_member member: team.getMembers()) {
                    System.out.println("----> members= "+ member);
                }
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
