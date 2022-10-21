package jpabook.jpashop.domain;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;
/************
* @info : 임베디드 값타입 정의 날짜 클래스
* @name : Period
* @date : 2022/10/21 6:28 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Embeddable
public class Period {

    private LocalDateTime startDate;
    private LocalDateTime endDate;


    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
