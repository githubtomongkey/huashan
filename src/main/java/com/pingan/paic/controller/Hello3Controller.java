package com.pingan.paic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pingan.paic.domian.User;

@RestController
@RequestMapping(value="/hello3")
public class Hello3Controller {
	@RequestMapping(value="demo1")
	public List<User> demo1(){
		List<User> list = new ArrayList<User>();
		for(int i = 0;i< 20;i++) {
			User user = new User();
			user.setId(i+1L);
			user.setUsername("zhangsan"+i);
			user.setName("张三"+i);
			user.setAge(18);
			list.add(user);
		}
		return list;
	}
	
	@RequestMapping(value="demo2")
	public String demo2(Model model) {
		model.addAttribute("msg", "使用额@RestController注解");
		return "hello";
	}

}
