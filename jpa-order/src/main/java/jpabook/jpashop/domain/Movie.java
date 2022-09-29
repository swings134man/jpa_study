package jpabook.jpashop.domain;

import javax.persistence.Entity;

/************
* @info : Item 테이블(객체)의 하위 객체 - 상속관계 매핑
* @name : Movie
* @date : 2022/09/29 5:07 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Entity
public class Movie extends Item{

    private String director;
    private String actor;

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
