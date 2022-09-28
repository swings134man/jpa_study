package third_inheritance;

import javax.persistence.Entity;

/************
* @info : 상속관계 매핑 - Item 클래스 extends 한 Album class
* @name : Album
* @date : 2022/09/28 5:58 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Entity
public class Album extends Item{

    private String artist;

    //get set

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
