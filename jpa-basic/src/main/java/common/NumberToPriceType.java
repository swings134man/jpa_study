package common;

import java.text.DecimalFormat;

/************
 * @info : 숫자를 가격형식으로 표기 (금액표기)
 * @name : NumberToPriceType
 * @date : 2023/02/26 3:39 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class NumberToPriceType {

    DecimalFormat df = new DecimalFormat("###,###.##");


    // int
    public String toPrice(Integer num){
        String format = df.format(100);
        return df.format(num);
    }

    // long
    public String toPrice(Long num) {
        return df.format(num);
    }

    // float
    public String toPrice(Float num) {
        return df.format(num);
    }

    // double
    public String toPrice(Double num) {
        return df.format(num);
    }


}
