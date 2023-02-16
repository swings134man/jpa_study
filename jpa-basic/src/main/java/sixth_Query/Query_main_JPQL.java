package sixth_Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/************
 * @info : JPQL 을 사용하는 main Class
 * @name : Query_main_JPQL
 * @date : 2023/02/16 7:20 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class Query_main_JPQL {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Logic
        try {


            // Entity 대상 Query
            List<Six_member> resultList =
                    em.createQuery("select m from Six_member m where m.userName like '%kim%'"
                                    , Six_member.class)
                            .getResultList();

            for (Six_member mem :resultList) {
                System.out.println("member = "+ mem);
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
