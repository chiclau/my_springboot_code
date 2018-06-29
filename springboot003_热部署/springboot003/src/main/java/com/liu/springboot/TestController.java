package com.liu.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devtools")
public class TestController {

	@RequestMapping("/test")
	public void test(){
		System.out.println("hello kitty");
	}
	
	@RequestMapping("/test2")
	public void test2(){
		System.out.println("hello tomcat");
	}
}
