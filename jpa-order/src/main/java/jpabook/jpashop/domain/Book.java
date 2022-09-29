package jpabook.jpashop.domain;

import javax.persistence.Entity;
/************
* @info : Item 테이블(객체)의 하위 객체 - 상속관계 매핑
* @name : Book
* @date : 2022/09/29 5:06 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/

@Entity
public class Book extends Item{
    private String author;
    private String isbn;

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
