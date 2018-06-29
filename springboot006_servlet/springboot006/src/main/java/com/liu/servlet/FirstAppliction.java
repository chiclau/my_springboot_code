package com.liu.servlet;

import javax.servlet.annotation.WebServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class FirstAppliction {
	
/*	*//**
	 * 1.通过注册的方式来实现servlet容器
	 * 注意:参数1:表示拿到一个servlet容器的实例(相当于web.xml配置文件中获得当前类的地址)
	 * 	        参数2:具体的请求名称
	 * 
	 * 
	 * 2.通过扫描的方式来实现servlet容器
	 * 注意:@ServletComponentScan是用来扫描所有进行标注的servlet容器,并且完成实例化等操作,要添加到入口方法(main方法)的类上
	 * 注意:在servlet容器中要加入一个注解@WebServlet(urlPatterns="/liu/servController")
	 * @return
	 *//*
	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		return new ServletRegistrationBean(new TestServletAction(),"/liu/serv");
	}*/

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(FirstAppliction.class, args);
	}

}
