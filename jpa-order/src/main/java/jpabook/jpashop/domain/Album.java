package jpabook.jpashop.domain;

import javax.persistence.Entity;

/************
* @info : Item 테이블(객체)의 하위 객체 - 상속관계 매핑
* @name : Album
* @date : 2022/09/29 5:04 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Entity
public class Album extends Item{

    private String artist;
    private String etc;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
