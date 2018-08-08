package com.xu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xuhongda on 2018/8/7
 * com.xu.pojo
 * spring-practice
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class People {

    private int age;

    private String name;
}
