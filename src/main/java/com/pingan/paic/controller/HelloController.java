package com.pingan.paic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 配置自定义处理器步骤：
1、	自定义处理器需要实现Controller接口
2、	复写hanleRequest方法
虽然在springmvc的整个架构中，处理器叫做Handler（处理器），但是我们在真正使用的时候一般都定义为XxxxController（因为实现了Controller接口）。
注意：虽然叫做Controller,但其实是个Handler处理器，而不是控制器，控制器仍然是DispatcherServlet。

 * @author lenovo
 *
 */
public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/hello");
		mv.addObject("msg","这是springMvc的第一个程序");
		return mv;
	}

}
