package sixth_Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/************
 * @info : Native Query - 객체 지향 SQL
 * @name : Query_main_NativeQuery
 * @date : 2023/02/17 2:40 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Native Query = 생 SQL QUERY 문법
 ************/
public class Query_main_NativeQuery {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Logic
        try {

            Six_member member = new Six_member();
            member.setName("First Name");
            em.persist(member);

            // flush -> commit, Query : 플러시가 자동으로 호출되는 시점은 commit, query를 사용했을때 이다.
            /*
                  만약 DB Connection 을 얻어와서 -> db.executeQuery("select * from member");
                  한다고 가정했을 때 아래의 forEach 문에서는 결과가 나오지 않는다.
                  -> 그 이유는 위의 persist() 했을 때는 flush()가 되지 않았기 때문에, DB에는 insert 쿼리가 날라가지 않았기 때문.
                  ---> 그렇기 떄문에 강제로 flush() 후, DB Connection을 이용하여 데이터를 얻어와야 한다. (예시중 1개)
             */


            List<Six_member> resultList =
                    em.createNativeQuery("SELECT MEMBER_ID, USER_NAME FROM SIX_MEMBER", Six_member.class)
                            .getResultList();

            for (Six_member m: resultList) {
                System.out.println("memberList : " + m);
            }


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }//main

}
