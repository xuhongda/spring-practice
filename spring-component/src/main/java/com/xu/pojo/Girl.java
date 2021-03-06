package com.xu.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xuhongda on 2018/6/20
 * com.xu.springcloudproducerhello.componment.pojo
 * spring-practice
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("Girl")
public class Girl {

    private String lookLike;

    private String name;

    private String age;
}
