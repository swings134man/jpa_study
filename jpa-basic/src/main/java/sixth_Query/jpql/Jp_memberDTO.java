package sixth_Query.jpql;

/************
 * @info : JPQL 프로젝션 - 스칼라 타입 조회시 DTO 로 받게 하기 위한 CLASS
 * @name : Jp_memberDTO
 * @date : 2023/02/21 8:05 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 
 ************/
public class Jp_memberDTO {
    private String username;
    private int age;

    public Jp_memberDTO(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
