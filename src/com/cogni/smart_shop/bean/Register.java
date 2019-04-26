package com.cogni.smart_shop.bean;

public class Register {
	
	private String f_name;
	private String l_name;
	private int age;
	private String gender;
	private Long c_number;
	private String user_id;
	private String password;
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getC_number() {
		return c_number;
	}
	public void setC_number(long c_number) {
		this.c_number = c_number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Register(String f_name, String l_name, int age, String gender, long c_number, String user_id,
			String password) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.age = age;
		this.gender = gender;
		this.c_number = c_number;
		this.user_id = user_id;
		this.password = password;
	}
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
}
