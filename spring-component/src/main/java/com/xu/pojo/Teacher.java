package com.xu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xuhongda on 2020/12/3
 * com.xu.pojo
 * spring-practice
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private long id;

    private String name;

    private int age;
}
