package com.liu.springboot;

import com.alibaba.fastjson.annotation.JSONField;


public class Goods {

	//@JSONField(serialize=false)作用就是将该属性取消序列化操作,转化的json串中就不包含当前属性
	@JSONField(serialize=false)
	private String goods_id;
	@JSONField(serialize=false)
	private String goods_name;
	private int goods_num;
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}

}
