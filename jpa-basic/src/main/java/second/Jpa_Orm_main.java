package second;

import first.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Jpa_Orm_main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // table 관련 에러시 drop table team, tmember cascade; 실행
            // Team
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team); // 영속 상태가 되기때문에 PK 값이 세팅되어있음.

            // Member
            TMember member = new TMember();
            member.setName("member1");
            member.setAge(10);
            member.changeTeam(team); // Team 에서 pk 값을 꺼내서 insert 할때 FK 값으로 사용한다 -> 편의 메서드 사용 Member.changeTeam
            em.persist(member);

            // find 조회 쿼리 확인하고 싶은데
            // 영속성 컨텍스트에서 1차 캐시에서 가져오기때문에 쿼리를 못 봄
            // 강제 호출하여 flush() DB에 강제 반영하고
            // - 영속성 컨텍스트를 초기화
            // 즉 DB에서 깔끔한 값을 가져오고 싶을때 사용.
            em.flush();
            em.clear();







            //조회
//            TMember findMember = em.find(TMember.class, member.getId());

            // 2번 예제
//            Team findteam = findMember.getTeam();
//            System.out.println("find Team : "+ findteam.getName());

            //조회 - 객체관계일떄 안좋은 예
            /*
            FK 외래키에 대한 관계가 없기 떄문에
            memberId로 Team 을 조회 하려면 아래와 같은 복잡한 방식을 사용해야한다.
            - 테이블은 외래 키로 조인을 사용하여 연관된 테이블을 찾는다.
            - 객체는 참조를 사용해서 연관된 객체를 찾는다.
            - 테이블과 객체 사이에는 이러한 큰 간격이 존재함.
             */
            // 3번 예제
//            TMember findMember = em.find(TMember.class, member.getId());
//
//            Long memberId = findMember.getId();
//            Team findTeam = em.find(Team.class, memberId);

            // 4번 예제 - 일대다 관계 -> 조회 카테고리연관됨
//            List<TMember> members = findMember.getTeam().getMembers();
//
//            for (TMember m : members) {
//                System.out.println("m = " + m.getName());
//            }


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }//main
}
