package third_inheritance;

import javax.persistence.Entity;

/************
* @info : 상속관계 매핑 - Item 클래스 extends 한 Book class
* @name : Book
* @date : 2022/09/28 6:00 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Entity
public class Book extends Item{

    private String author;
    private String isbn; //번호

    //get set

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
