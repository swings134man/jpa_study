package third_inheritance;

import javax.persistence.Entity;

/************
* @info : 상속관계 매핑 - Item 클래스 extends 한 Movie class
* @name : Movie
* @date : 2022/09/28 5:59 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Entity
public class Movie extends Item{
    private String director;
    private String actor;

    //get set

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
