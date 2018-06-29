package com.liu.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class TestController {

	@RequestMapping(value="/test",method=RequestMethod.GET)
	public void test(){
		System.out.println("我是测试用的");
		int x = 100/0;
	}
	
	/**
	 * 自定义异常处理
	 */
	@RequestMapping("/test2")
	public void test2() throws MyException{
		System.out.println("我是test2");
		throw new MyException("我就是自己玩,没事");
	}

}
