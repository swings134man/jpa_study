package second;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/************
* @info : JPA 매핑시 양방향 연관관계에 관한 class
* @name : Jpa_Mapping_main
* @date : 2022/09/23 6:43 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
public class Jpa_Mapping_main {
    /**
    * @info    : main
    * @name    : main
    * @date    : 2022/09/23 6:50 PM
    * @author  : SeokJun Kang(swings134@gmail.com)
    * @version : 1.0.0
    * @param   :
    * @return  :
     * 연관관계가 존재할때 연관관계의 주인에 대한 code와
     * 역방향에 대해서 Data setting 에 대한 method
     * -> 양방향 매핑시 연관관게의 !주인에! 값을 입력해야함.
     * ---> 순수한 객체 관계를 고려한다면 항상 양쪽에 값을 입력.
    */
    public static void main(String[] args) {



//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");
//
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try {
//            //Team
//            Team team = new Team();
//            team.setName("TeamB");
//            em.persist(team);
//
//            //TMember
//            TMember member = new TMember();
//            member.setName("member1");
//            member.setAge(11);
//            member.setTeam(team);
//            em.persist(member);
//
//            // 양방향 관계
//            // 주인과 역방향 모두 세팅 해줘야함. -> 주인은 member.setTeam(team);
//            team.getMembers().add(member); // 역방향 Data Setting
//
//            Team findTeam = em.find(Team.class, team.getId()); // 1차 캐시
//            List<TMember> members = findTeam.getMembers();
//
//
//            tx.commit();
//        }catch (Exception e){
//
//            tx.rollback();
//        }finally {
//            em.close();
//        }
//        emf.close();

    } //main
}
