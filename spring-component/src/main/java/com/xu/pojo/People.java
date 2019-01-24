package com.xu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xuhongda on 2018/8/7
 * com.xu.pojo
 * spring-practice
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class People implements Serializable {

    private int age;

    private String name;
}
