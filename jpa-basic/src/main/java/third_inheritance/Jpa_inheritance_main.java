package third_inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Jpa_inheritance_main {
    public static void main(String[] args) {
        // table 관련 에러시 drop table item, book, album, movie cascade; 실행
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // Movie 등록
            // 아래 코드만 실행시 -> ITEM , MOVIE 테이블에 insert 됨
            // MOVIE에 PK는 PK이자 FK
            Movie movie = new Movie();
            movie.setDirector("A");
            movie.setActor("Tony Stark");
            movie.setName("아이언맨");
            movie.setPrice(10000);
            em.persist(movie);


            tx.commit();
        }catch (Exception e){

            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }//main
}
