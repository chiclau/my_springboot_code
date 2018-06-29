package com.liu.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RequestMapping("/abc")
@RestController
public class HelloKitty {

	/**
	 * 这里加入的是springmvc的请求方式,提供的返回值可以在页面上显示,在浏览器的地址栏中输入 http://localhost:8080/
	 * 会直接给出显示的页面信息kkkkkkkk
	 * 默认请求
	 * @return
	 */
	@RequestMapping("/")
	public String helloKitty() {
		return "kkkkkkkk";
	}

	/**
	 * 加入指定的请求
	 * @return
	 */
	@RequestMapping("/fuck")
	public String helloFucking() {
		return "hello fucking day!";
	}
	
	/**
	 * 动态请求
	 * @param pathName
	 * @return
	 */
	@RequestMapping("/kitty/{pathName}")
	public String kitty(@PathVariable String pathName){
		return "kitty:"+pathName;
	}

	/**
	 * 返回普通的json,实体类类型
	 * @return
	 */
	@RequestMapping("/goodsJson")
	public Goods goodsJson() {
		Goods goods = new Goods();
		goods.setGoods_id("abcx123");
		goods.setGoods_name("kitty");
		goods.setGoods_num(123);
		return goods;
	}
	
	/**
	 * 返回自定义的json,Map类型
	 * @return
	 */
	@RequestMapping("/mapJson")
	public Map mapJson(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("aaa", "bbb");
		map.put("hello", 123);
		return map;
	}
	
	/**
	 * 返回自定义的json,map嵌套list类型
	 * @return
	 */
	@RequestMapping("/mapListJson")
	public Map mapListJson(){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			list.add(i);
		}
		map.put("cao", list);
		return map;
	}
	
	/**
	 * 返回list类型的json,没有key值,别瞎几把写,这是大坑
	 * @return
	 */
	@RequestMapping("/listJson")
	public List listJson(){
		List<String> list = new ArrayList<String>();
		list.add("神之无知");
		list.add("神头鬼脸");
		return list;
	}
	
	/**
	 * 这才是真正的json数组形式,嵌套实体类方式
	 * @return
	 */
	@RequestMapping("listEntityJson")
	public List listEntityJson(){
		List<Goods> list = new ArrayList<Goods>();
		for(int i=0;i<4;i++){
			Goods goods = new Goods();
			goods.setGoods_id(UUID.randomUUID().toString());
			goods.setGoods_name("kitty"+i);
			goods.setGoods_num(i);
			list.add(goods);
		}
		return list;
	}
	
	/**
	 * list嵌套map的格式,你敢信?map里的key值可以都一样的,不信你看
	 * @return
	 */
	@RequestMapping("listEntityMap")
	public List listMapJson(){
		List<Map> list = new ArrayList<Map>();
		for(int i=0;i<4;i++){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("kkk", "niubi"+i);
			map.put("jj", "jj"+i);
			list.add(map);
		}
		return list;
	}
}
