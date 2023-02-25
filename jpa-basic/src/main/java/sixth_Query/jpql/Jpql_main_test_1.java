package sixth_Query.jpql;

import common.NumberToPriceType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.DecimalFormat;
import java.util.List;

/************
 * @info : JPQL TEST Class
 * @name : Jpql_main_test_1
 * @date : 2023/02/26 2:52 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : ORDER, PRODUCT  Entity CRUD
 ************/
public class Jpql_main_test_1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_h2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 숫자 표기
//        DecimalFormat df = new DecimalFormat("###,###.##");
        NumberToPriceType formattPrice = new NumberToPriceType();

        try{

            // Product (Jp_product)
//            Jp_product product = new Jp_product();
//            product.setName("iphone 12 pro max");
//            product.setPrice(10000);
//            product.setStockAmount(200);
//            em.persist(product);


//            Jp_product productEntity = em.find(Jp_product.class, 9L); // iphone 12 pro max
//
//            // Order
//            Jp_order order = new Jp_order();
//            order.setProduct(productEntity);
//            order.setOrderAmount(10);
//            order.setAddress(new Jp_Address("paju", "금바위로", "413750"));
//            productEntity.minusAmount(order.getOrderAmount()); // 주문 수량만큼 물량 --;
//            em.persist(order);

            // 특정 주문(order)의 물량과 갯수 조회
            // Cross join 쿼리 발생.
            List resultList = em.createQuery(
                            "select o.id, o.orderAmount, p.price ,o.orderAmount * p.price as totalprice " +
                                    "from Jp_order o, Jp_product p " +
                                    "where o.product = p.id")
                    .getResultList();
            System.out.println("size =" + resultList.size());

            // 프로젝션
            Object o = resultList.get(0);
            Object[] oArr = (Object[]) o;


            //df.format(oArr[2])
            //df.format(oArr[3]));
            System.out.println("Res:  {id="+oArr[0]
                    + ", orderAmount=" +oArr[1]
                    + ", price=" + formattPrice.toPrice((Integer) oArr[2])
                    + ", totalprice=" + formattPrice.toPrice((Integer) oArr[3]));


            tx.commit();
        }catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();

    }//main
}//class
