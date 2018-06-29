package com.liu.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/getListForMap")
	public void getListForMap(){
		List<Map<String, Object>> list = goodsService.getListForMap();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).get("goods_name"));
		}
	}
	
	@RequestMapping("/getListForCondition")
	public void getListForCondition(){
		List<Map<String, Object>> list = goodsService.getListForCondition("张学友", 42);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).get("goods_id"));
		}
	}
	
	@RequestMapping("/getListForGoods")
	public void getListForGoods(){
		List<Goods> list = goodsService.getListForGoods();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getGoods_name());
		}
	}
	
	@RequestMapping("/getListForGoodsCondition")
	public void getListForGoodsCondition(){
		List<Goods> list= goodsService.getListForGoodsCondition("张学友");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getGoods_id());
		}
	}
	
	@RequestMapping("/getGoodsByCondition")
	public void getGoodsByCondition(){
		Goods goods = goodsService.getGoodsEntity("adfaf111");
		System.out.println(goods.getGoods_name());
	}
	
	@RequestMapping("/addGoods")
	public void addGoods(){
		Goods goods = new Goods();
		goods.setGoods_id(UUID.randomUUID().toString());
		goods.setGoods_name("成龙");
		goods.setGoods_num(60);
		
		goodsService.insertGoods(goods);
	}
	
	@RequestMapping("/updGoods")
	public void updGoods(){
		Goods goods = new Goods();
		goods.setGoods_id("f91d17b8-6634-4b5d-b042-bc8e795f3c42");
		goods.setGoods_name("凯蒂猫");
		goods.setGoods_num(60);
		
		goodsService.updateGoods(goods);
	}
	
	@RequestMapping("/delGoods")
	public void delGoods(){
		goodsService.delGoods("f91d17b8-6634-4b5d-b042-bc8e795f3c42");
	}
	
}
