package fifth_value_type;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/************
 * @info : JPA Embedded 값 타입 - 기간 공통 Class
 * @name : Period
 * @date : 2023/02/15 6:39 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : FiMember 의존중, Another Entity dependecy allow
 ************/
@Embeddable // 값 타입 정의 하는곳
public class Period {

    // 기간 Period
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // Constructor
//    public Period() {
//
//    }
//
//    public Period(LocalDateTime startDate, LocalDateTime endDate) {
//        this.startDate = startDate;
//        this.endDate = endDate;
//    }

    // Getter Setter
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
