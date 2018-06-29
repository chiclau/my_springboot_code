package com.liu.init;



/**
 * 这个是我们的实体类,没别的意思
 * 1.先来3个简单的,复杂的后面再说,id,name,number
 * @author Administrator
 * 
 */
public class Goods {

	private String goods_id;
	private String goods_name;
	private int goods_num;

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
