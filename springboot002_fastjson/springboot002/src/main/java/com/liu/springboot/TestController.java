package com.liu.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;

@RequestMapping("/test")
@RestController
public class TestController {

	@RequestMapping("/test")
	public void test(){
		Goods goods = new Goods();
		goods.setGoods_id(UUID.randomUUID().toString());
		goods.setGoods_name("kitty");
		goods.setGoods_num(12);
		
		String jsonString = JSON.toJSONString(goods);
		System.out.println(jsonString);
	}
	
	@RequestMapping("/test2")
	public void test2(){
		Goods goods = new Goods();
		goods.setGoods_id(UUID.randomUUID().toString());
		goods.setGoods_name("kitty");
		goods.setGoods_num(12);
		
		Goods goods2 = new Goods();
		goods2.setGoods_id(UUID.randomUUID().toString());
		goods2.setGoods_name("杰伦");
		goods2.setGoods_num(30);
		
		Person person = new Person();
		person.setPerson_id(UUID.randomUUID().toString());
		person.setPerson_name("tomcat");
		
/*		List<Goods> list = new ArrayList<Goods>();
		list.add(goods);
		list.add(goods2);
		person.setList(list);
		
		System.out.println(JSON.toJSONString(person));*/
		/**
		 * {"list":[{"goods_id":"821036e9-ba60-4034-9a18-598a27251d98","goods_name":"kitty","goods_num":12},
		 * {"goods_id":"4551a63e-af59-4da7-98f6-d1a226ea7d59","goods_name":"杰伦","goods_num":30}],
		 * "person_id":"38aca6ce-9c8c-44e8-9b79-f778436e77bc","person_name":"tomcat"}
		 */
		
		goods.setPerson(person);
		System.out.println(JSON.toJSONString(goods));
		/**
		 * {"goods_id":"b0f5f1c1-425c-4d5b-a1a3-58882a9a0d14","goods_name":"kitty","goods_num":12,
		 * "person":{"person_id":"fa05d11a-8d33-4af5-aad1-786acf7d105e","person_name":"tomcat"}}
		 */
	}
	
	@RequestMapping("/test3")
	public void test3(){
		Goods goods = new Goods();
		goods.setGoods_id(UUID.randomUUID().toString());
		goods.setGoods_name("kitty");
		goods.setGoods_num(12);
		
		String jsonString = JSON.toJSONString(goods);
		System.out.println(jsonString);
		//---------------
		Role role = new Role();
		role.setRole1("aaaaaa");
		role.setRole2("bbb");
		role.setRole3("ccccc");
		role.setRole4("ddddd");
		role.setRole5("eeee");
		role.setRole6("fffff");
		role.setRole7("ggggg");
		role.setRole8("hhhhh");
		role.setRole9("iiiiiii");
		
		String jsonString2 = JSON.toJSONString(role);
		System.out.println(jsonString2);
		/**
		 * @JSONField是取消当前顺序性的json序列,@JSONType是包含要转化的属性
		 * 注意:@JSONField是添加到当前的属性上,@JSONType是要添加到当前的类上,注意位置
		 * 
		 */
	}

	/**
	 * 从jsp或者html页面传递过来一个json串
	 */
	@RequestMapping("/test4")
	public void test4(){
		Dept dept = new Dept();
		dept.setDept_add("天安门");
		dept.setDept_id(UUID.randomUUID().toString());
		dept.setDept_name("国安局");
		
		String deptString = JSON.toJSONString(dept);//从页面传递过来的json串
		JSONObject jsonObject = JSONObject.parseObject(deptString);
		System.out.println(jsonObject.getString("dept_add"));
		
		Dept dept2 = JSON.toJavaObject(jsonObject, Dept.class);
		System.out.println(dept2.getDept_name());
		
	}
	
}
