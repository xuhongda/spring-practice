package com.xu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xuhongda on 2020/11/24
 * com.xu.pojo
 * spring-practice
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String brand;

    private String color;

    private String price;
}
