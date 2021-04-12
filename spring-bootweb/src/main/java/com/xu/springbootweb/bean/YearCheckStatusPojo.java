package com.xu.springbootweb.bean;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.File;

/**
 *
 * @author xuhongda on 2021/3/17
 * com.iov.api.entity.receiveVo
 * iov-vs-api
 */
@Data
@ToString
public class YearCheckStatusPojo {

    @NotEmpty(message = "业务单号必须要填")
    String number;
    @NotEmpty(message = "状态 必须填写 ；状态:1内勤受理2师傅接单3完成合格4完成不合格")
    Integer status;
    String username;
    String mobile;
  //  File[] imgs;
}
