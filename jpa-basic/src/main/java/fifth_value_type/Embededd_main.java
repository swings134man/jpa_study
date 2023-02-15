package fifth_value_type;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/************
 * @info : JPA - Embedded Value Type Main Class
 * @name : Embededd_main
 * @date : 2023/02/15 6:30 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class Embededd_main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            FiMember member = new FiMember();
            member.setUsername("kim");
            member.setHomeAdderss(new Adderss("seoul", "gangnamdaero", "456"));
            member.setWorkPeriod(new Adderss("paju","tonil","123"));
            member.setWorkPeriod(new Period());

            em.persist(member);


            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }//main
}//class
