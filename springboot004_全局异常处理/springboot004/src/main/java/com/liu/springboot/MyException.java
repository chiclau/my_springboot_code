package com.liu.springboot;

/**
 * 自定义异常
 * @author Administrator
 *
 */
public class MyException extends Exception {

	public MyException(String message){
		super(message);
	}
}
