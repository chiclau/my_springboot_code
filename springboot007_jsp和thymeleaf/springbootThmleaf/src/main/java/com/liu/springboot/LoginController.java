package com.liu.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = "/hello",method = RequestMethod.GET)
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","kitty");
        mav.setViewName("/hello");
        return mav;
    }
	
	@RequestMapping(value="/jie",method=RequestMethod.POST)
	public ModelAndView jie(String address){
		ModelAndView mav = new ModelAndView();
        System.out.println(address);
        mav.setViewName("/hello");
        return mav;
	}
	
	@RequestMapping(value="/zaijie",method=RequestMethod.POST)
	public ModelAndView zaijie(Goods goods){
		ModelAndView mav = new ModelAndView();
        System.out.println(goods.getGoods_name());
        mav.setViewName("/hello");
        return mav;
	}
	
	@RequestMapping(value="/ding",method=RequestMethod.GET)
	public ModelAndView ding(){
		ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/login/hello");
        return mav;
	}
	
	@RequestMapping(value="/kong",method=RequestMethod.GET)
	public ModelAndView kong(){
		ModelAndView mav = new ModelAndView();
		Goods goods= new Goods();
		goods.setGoods_name("火龙果");
		List<Goods> list = new ArrayList<Goods>();
		for(int i=0;i<5;i++){
			Goods goods2 = new Goods();
			goods2.setGoods_id(UUID.randomUUID().toString());
			goods2.setGoods_name("hehe"+i);
			goods2.setGoods_num(i);
			list.add(goods2);
		}
		mav.addObject("goods",goods);
		mav.addObject("list",list);
        mav.setViewName("/hello");
        return mav;
	}
}
