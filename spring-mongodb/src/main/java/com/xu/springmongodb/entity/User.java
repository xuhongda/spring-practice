package com.xu.springmongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xuhongda on 2018/8/22
 * com.xu.springmongodb.entity
 * spring-practice
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -569102280744951159L;
    private Long id;
    private String userName;
    private String passWord;
}
