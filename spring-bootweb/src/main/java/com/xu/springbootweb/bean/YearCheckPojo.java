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
public class YearCheckPojo {

    @NotEmpty(message = "订单号不不能为空")
    private String number;
    @NotEmpty(message = "车主姓名不能为空")
    private String username;
    @NotEmpty
    private String mobile;
    @NotEmpty
    private String carNo;
    private String carModel;
    private String carRegDate;
    private String serviceChargeType;
    private String remark;
    @NotEmpty
    private String validateType;
    /*private       以下字段仅在上线验车，validateType为2时传递*/
    private String appointDate;
    private String stationId;
    private String validateChargeType;
    private Boolean isTakeCar;
    /* private       以下字段仅在取送车，isTakeCar为2时传递*/
    private String isAgentTax;
    private String provinceCode;
    private String province;
    private String cityCode;
    private String city;
    private String countyCode;
    private String county;
    private String locationX;
    private String locationY;
    private String address;

}
