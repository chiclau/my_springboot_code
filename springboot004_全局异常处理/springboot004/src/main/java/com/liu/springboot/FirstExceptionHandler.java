package com.liu.springboot;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ControllerAdvice是spring3.2 引入的一个新注解,作用是一个增强型的控制,通过方法的注解来执行不同的方法
 * 1.初始化;2.封装对象;3.异常处理
 * 注意:要执行的方法需要加入注解@ExceptionHandler异常处理,要方法的方法需要加入一个值,就是要处理异常的类
 * 
 * 第一步:通过controller来方法请求方法
 * 第二步:只有当controller中的方法出现异常时,才会访问到@ExceptionHandler的方法
 * 注意:可以在@ControllerAdvice中添加指定的异常处理方法
 */
@ControllerAdvice
public class FirstExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public void TestException(Exception e){
		e.printStackTrace();
		System.out.println("出问题了再找我");
	}
	
/*	@ExceptionHandler(value=ArithmeticException.class)
	public void Test2Exception(ArithmeticException e){
		e.printStackTrace();
		System.out.println("告诉你分母不能为0的!!!");
	}*/
	
	@ResponseBody
	@ExceptionHandler(value=ArithmeticException.class)
	public String test2Exception(ArithmeticException e){
		e.printStackTrace();
		System.out.println("告诉你分母不能为0的!!!");
		return "{\"err\":\"页面上显示报错了!\"}";
	}
	
	@ExceptionHandler(value=MyException.class)
	public void test3Exception(MyException e){
		e.printStackTrace();
		System.out.println("自定义的出错了吧");
	}
	
}
