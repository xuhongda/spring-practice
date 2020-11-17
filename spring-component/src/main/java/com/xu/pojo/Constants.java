package com.xu.pojo;

/**
 * @author xuhongda on 2020/11/17
 * com.xu.pojo
 * spring-practice
 */
public enum Constants {

    /**
     *  me
     */
    ME("me","xuhongda");


    Constants(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;

    private String value;


    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
