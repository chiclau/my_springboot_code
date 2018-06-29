package com.liu.springboot;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(includes={"role1","role4","role7"})
public class Role {

	private String role1;
	private String role2;
	private String role3;
	private String role4;
	private String role5;
	private String role6;
	private String role7;
	private String role8;
	private String role9;

	public String getRole1() {
		return role1;
	}

	public void setRole1(String role1) {
		this.role1 = role1;
	}

	public String getRole2() {
		return role2;
	}

	public void setRole2(String role2) {
		this.role2 = role2;
	}

	public String getRole3() {
		return role3;
	}

	public void setRole3(String role3) {
		this.role3 = role3;
	}

	public String getRole4() {
		return role4;
	}

	public void setRole4(String role4) {
		this.role4 = role4;
	}

	public String getRole5() {
		return role5;
	}

	public void setRole5(String role5) {
		this.role5 = role5;
	}

	public String getRole6() {
		return role6;
	}

	public void setRole6(String role6) {
		this.role6 = role6;
	}

	public String getRole7() {
		return role7;
	}

	public void setRole7(String role7) {
		this.role7 = role7;
	}

	public String getRole8() {
		return role8;
	}

	public void setRole8(String role8) {
		this.role8 = role8;
	}

	public String getRole9() {
		return role9;
	}

	public void setRole9(String role9) {
		this.role9 = role9;
	}

}
