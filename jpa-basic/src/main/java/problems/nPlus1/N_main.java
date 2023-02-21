package problems.nPlus1;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

/************
 * @info : N+1 문제 main class
 * @name : N_main
 * @date : 2023/02/20 6:33 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : N+1 문제에 대한 Test 및 해결방법 main class
 ************/
public class N_main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            /*
                객체 생성
             */
            // member
//            N_member member1 = new N_member();
//            member1.setUserName("쿠팡");
//            em.persist(member1);
////
//            // order
//            N_orders order1 = new N_orders();
//            order1.setMember(member1);
//            em.persist(order1);
//
//            N_orders order2 = new N_orders();
//            order2.setMember(member1);
//            em.persist(order2);
//
//            N_orders order3 = new N_orders();
//            order3.setMember(member1);
//            em.persist(order3);

            /*
                조회 - EAGER
             */
//            N_member memberRes = em.find(N_member.class, 1L);
//            System.out.println("member: " + memberRes);

            /*
                조회 JPQL
             */
//            List<N_member> resultList =
//                    em.createQuery("select m from N_member m", N_member.class)
//                            .getResultList();
////            System.out.println("member: " + resultList);
//            resultList.stream().forEach(System.out::println);
// --------------------------- JPQL 사용시 N+1 발생 ---------------------------

        /*
            페치
         */
            // Fetch.Type = LAZY 지연로딩
            // N+1 문제 발생 하지 않음.
//            List<N_member> resultList =
//                    em.createQuery("select m from N_member m"
//                            , N_member.class)
//                            .getResultList();
//            // 하지만 비지니스 로직에서 사용시 SELECT * FROM ORDERS WHERE MEMBER_ID = ? 쿼리 발생
//            N_member firstMember = resultList.get(0);
//            firstMember.getOrders().size();
//
//
//            // 즉 Member의 수가 n개가 된다면 쿼리가 N+1 개 발생
//            // Memebr의 수만큼 SELECT * FROM ORDERS WHERE MEMBER_ID = ? 쿼리 발생.
//            for (N_member member: resultList) {
//                System.out.println("member: " + member.getOrders().size());
//            }
// --------------------------- 여기까진 N+1 발생함---------------------------

            // fetch join - member
//            List<N_member> resultList =
//                    em.createQuery("select DISTINCT m from N_member m join fetch m.orders"
//                            , N_member.class)
//                            .getResultList();
//
////            for (N_member member: resultList) {
////                System.out.println("member : " + member.getId());
////            }
//            System.out.println("member result size: " + resultList.size()); // member 및 member에 연관된 orders
//
//            for (N_member members: resultList) {
//                System.out.println("member : " + members.getOrders());
//            }


//            // orders 검색 - 9 개 검색 후 출력
//            List<N_orders> resultList2 =
//                    em.createQuery("select DISTINCT o from N_orders o join fetch o.member"
//                            , N_orders.class)
//                            .getResultList();
//            System.out.println("result2 size : " + resultList2.size());


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
