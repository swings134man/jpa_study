package jpabook.jpashop.domain;

/************
* @info : JPA 값 타입정보를 위한 main class
* @name : ValueMain
* @date : 2022/10/04 6:50 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
public class ValueMain {

    public static void main(String[] args) {
        int a = 10;
        int b = a;

        b = 20;

        System.out.println("a = " + a); // 10
        System.out.println("b = " + b); // 20
        // -------------------
        // 객체는 공유 가능하지만, 값을 변경할 수 없다 .
        Integer a2 = new Integer(10); // Integer.valueOf 대체가능
        Integer b2 = a; // 주소값만 넘어감 -> 참조값만 즉 공유됨.

        System.out.println("a2 = " + a2); // 10
        System.out.println("b2 = " + b2); // 10

    }
}
