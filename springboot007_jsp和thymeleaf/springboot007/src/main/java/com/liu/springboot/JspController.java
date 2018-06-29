package com.liu.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/google")
public class JspController {

	@RequestMapping("/initPage")
	public ModelAndView initPage(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","kitty");
		mav.setViewName("/google");
		return mav;
	}
	
	@RequestMapping(value="/jie",method=RequestMethod.POST)
	public ModelAndView jie(String hello){
		ModelAndView mav = new ModelAndView();
		System.out.println(hello);
		mav.setViewName("/google");
		return mav;
	}
	
	/**
	 * 注意:普通的接收参数和注解方式接收参数
	 * 1.普通的:form表单中的参数名称与方法中的参数名称一致
	 * 2.注解的:@RequestParam中的value属性值要与form表单中的一致,如果不一致,则不能接收到数据,方法中的属性值,要通过注解中的value值重新赋值
	 */
	@RequestMapping(value="/yueshu",method=RequestMethod.POST)
	public ModelAndView yueshu(@RequestParam(value="hehe",required=true) String yue){
		ModelAndView mav = new ModelAndView();
		System.out.println(yue);
		mav.setViewName("/google");
		return mav;
	}

}
