package experiment;

import experiment.entity.Eboard;
import experiment.entity.Emember;
import experiment.entity.Ereply;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/************
 * @info : Test - main 1
 * @name : EMain_1
 * @date : 2023/03/04 4:01 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class EMain_1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try{

//            Emember member = new Emember();
//            member.setName("member2");
//            em.persist(member);
//
//            Eboard board = new Eboard();
//            board.setTitle("board2");
//            board.setMember(member);
//            em.persist(board);
//
//            Ereply reply = new Ereply();
//            reply.setContent("reply3");
//            reply.setBoard(board);
//            em.persist(reply);
//
//            Ereply reply2 = new Ereply();
//            reply2.setContent("reply4");
//            reply2.setBoard(board);
//            em.persist(reply2);
//
//            em.flush();
//            em.clear();

//            Eboard eboard = em.find(Eboard.class, 21L);
//            System.out.println("res= " + eboard.getTitle());

            // test - fetch -> Board, reply
            String query = "select DISTINCT b from Eboard b join fetch b.replys where b.boardId='21'";
            List<Eboard> resultList = em.createQuery(query, Eboard.class).getResultList();
            for (Eboard board: resultList) {
                System.out.println("Board Title=" + board.getTitle() + ", id=" + board.getBoardId());

                // reply
                for (Ereply reply: board.getReplys()) {
                    System.out.println("-----> Reply id=" + reply.getReplyId() + ", content=" + reply.getContent()+ ", boardId=" + reply.getBoard().getBoardId());
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
