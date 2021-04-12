package com.xu.springbootweb.bean;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author xuhongda on 2021/3/17
 * com.iov.api.entity
 * iov-vs-api
 */
@Data
@ToString
public class YearCheckChangeAppointPojo {
    @NotEmpty(message = "订单号必须要填")
    private String      number;
    private Integer  stationId;
    private String appointDate;
}
