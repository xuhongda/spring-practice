package com.xu.combootcomponnent.enums;

public enum UserSexEnum {


	/**
	 *  男
	 */
	MAN("男"),

	/**
	 *  女
	 */
	WOMAN("女");

	UserSexEnum(String sex) {
		this.sex = sex;
	}

	private String sex;

	public String getSex() {
		return sex;
	}
}
