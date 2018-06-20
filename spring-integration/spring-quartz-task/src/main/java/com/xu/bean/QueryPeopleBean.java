package com.xu.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2018/6/15
 * com.xu.bean
 * spring-practice
 */
@Data
public class QueryPeopleBean {
    /**
     * 姓名
     */
    private String iname;
    /**
     * 身份证号
     */
    private String cardNum;

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
