package com.liu.springboot;

import java.io.Serializable;

public class Dept implements Serializable {

	private static final long serialVersionUID = -4872657117018841946L;
	private String dept_id;
	private String dept_name;
	private String dept_add;

	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_add() {
		return dept_add;
	}

	public void setDept_add(String dept_add) {
		this.dept_add = dept_add;
	}

}
