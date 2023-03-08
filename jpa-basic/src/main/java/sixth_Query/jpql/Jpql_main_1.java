package sixth_Query.jpql;


import sixth_Query.Six_member;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
//
//            em.flush();
//            em.clear();


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

            // ----------------- 프로젝션 -----------------------------
            // 엔티티 프로젝션 -> 조회 되는 순간 영속성 컨텍스트에서 관리 된다. (10개든, 20개든)
//            List<Jp_member> resl = em.createQuery("select m from Jp_member m", Jp_member.class).getResultList();
//            Jp_member member1 = resl.get(0);
//            member1.setAge(30);

            // 엔티티 프로젝션.
            // join 쿼리 발생 member inner join team
            // 결국 team 을 조회 하는것이기 때문임.
//            List<Jp_team> resultList = em.createQuery("select m.team from Jp_member m", Jp_team.class).getResultList();
            // 이게 더 좋은 쿼리 코드임. -> 쿼리 내용을 보기 쉬움. -> 예측 가능
            // List<Jp_team> resultList = em.createQuery("select t from Jp_member m join m.Jp_team t", Jp_team.class).getResultList();


            // 임베디드 타입 프로젝션
            // order 와 연관된 임베디드 타입 address 의 값을 가져온다.
            // 어떤 엔티티에 소속되어있는지 명시해줘야 한다. -> from Jp_order
//            List<Jp_Address> resultList = em.createQuery("select o.address from Jp_order o", Jp_Address.class).getResultList();
//            System.out.println("size : " + resultList.size());


            // 스칼라 타입 프로젝션
            // 기본타입 조회 ->
            // (1번 방법 )받는 타입에 대해서 고민 -> Query 타입이나, Object 타입으로 변환 후 사용해야함.
//            List resultList = em.createQuery("select m.username, m.age from Jp_member m").getResultList();
//            Object o = resultList.get(0);
//            Object[] oRes = (Object[]) o;
//            System.out.println("username : " + oRes[0]);
//            System.out.println("age : " + oRes[1]);

            // (2번 방법) - 위의 Object 과정 생략 가능.
//            List<Object[]> resultList = em.createQuery("select m.username, m.age from Jp_member m").getResultList();
//            Object[] objects = resultList.get(0);
//            System.out.println("username :" + objects[0]);

            // (3번 방법) - new 명령어로 조회 -> 단순 값을 DTO 로 바로 조회 하는것임.
            // package 명을 적어줘야 하는것이 불편한 단점임.
            // QueryDSL 사용 할 경우 package 명 생략 하면서 쉽게 사용가능 -> Java Code로 사용하기 때문이다.
            // 순서와 타입이 일치하는 생성자가 필요하다.
//            List<Jp_memberDTO> resultList =
//                    em.createQuery("select new sixth_Query.jpql.Jp_memberDTO(m.username, m.age) from Jp_member m"
//                            , Jp_memberDTO.class)
//                            .getResultList();
//            Jp_memberDTO jp_memberDTO = resultList.get(0);
//            System.out.println("DTO : " + jp_memberDTO.getUsername());
//            System.out.println("DTO : " + jp_memberDTO.getAge());


            // Entity 직접 사용
//            Jp_member member = new Jp_member();
//            String query1 = "select m from Jp_member m where m = :member";
//            Jp_member result = em.createQuery(query1, Jp_member.class)
//                    .setParameter("member", member)
//                    .getSingleResult();
//            System.out.println(result);

            // 2. 식별자를 직접 전달 - PK
            // SQL : select m.* from Jp_member m where m.id = 19
//            String query1 = "select m from Jp_member m where m.id = :id";
//            Jp_member result = em.createQuery(query1, Jp_member.class)
//                    .setParameter("id", 19L)
//                    .getSingleResult();
//            System.out.println(result);

            // 3. 외래키 값. -> ENtity 직접 넣어도 되고, FK 값을 넣어도된다.
//            String query = "select m from Jp_member m where m.team.id = :teamId";
//            List<Jp_member> member = em.createQuery(query, Jp_member.class)
//                    .setParameter("teamId", 15L)
//                    .getResultList();
//            System.out.println(member);

            /*
                벌크 연산 - INSERT, UPDATE, DELETE 지원

                * 벌크연산 후 영속성 컨텍스트를 초기화 해줘야 한다. -> 벌크연산은 영속성컨텍스트를 무시하고 DB에 직접 쿼리하기 때문.
                -> em.clear() 후 재조회 -> 재조회 데이터로 사용해야함.
             */

            // 1. 모든 회원의 나이를 20살로 변경
            int resultCount = em.createQuery("update Jp_member m set m.age = 20 ")
                    .executeUpdate();
            System.out.println(resultCount);


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
