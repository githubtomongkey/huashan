package com.pingan.paic.controller;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pingan.paic.domian.User;

@RequestMapping(value="/hello")
@Controller
public class Hello2Controller {
	
	/**
	 * 文件上传
	 * 需要通过MultipartFile类型来接收数据
	 * 
	 * @throws Exception 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("show31")
	public String test31(Model model,@RequestParam("file")MultipartFile file) throws Exception{
		
		if (file!=null) {
			file.transferTo(new File("d://upload//"+file.getOriginalFilename()));
		}
		model.addAttribute("msg", "上传成功!");
		return "hello";
	}

	
	
	
	
/**
 * 当使用注解开发的时候为什么我们不需要继承Controller呐??
 * @return
 */
	@RequestMapping("/show1")
	public ModelAndView test1(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/hello");
		mv.addObject("msg", "这是第一个注解的springmvc的程序改进版");
		return mv;
	}
	@RequestMapping("/show2")
	public ModelAndView test2(){
		ModelAndView mv = new  ModelAndView();
		mv.setViewName("/hello");
//		为什么这里的addObject之后前端页面就能接收到????
		mv.addObject("msg","ant风格的映射：*");
		return mv;
	}
	@RequestMapping(value="show18/{name}/{id}")
	public String test18(Model model,@PathVariable()String name,@PathVariable()String id){
		
		model.addAttribute("msg", "接收到的参数为："+name+"..."+id);
		return "hello";
	}
	@RequestMapping(value="show23")
	@ResponseStatus(value=HttpStatus.OK)
	public void test23(@RequestParam("name")String name,
			@RequestParam("age")Integer age,
			@RequestParam("isMarry")Boolean isMarry, //可以将on或者1转换为true,0转换为false.
			@RequestParam("income")Float income,
			@RequestParam("interests")String[] interests){
		StringBuffer sb = new StringBuffer();
		sb.append("name:"+name+"\n");
		sb.append("age:"+age+"\n");
		sb.append("isMarry:"+isMarry+"\n");
		sb.append("income:"+income+"\n");
		sb.append("interests:[");
		for (String inter : interests) {
			sb.append(inter+" ");
		}
		sb.append("]");
		System.out.println(sb.toString());

	}
	
	@RequestMapping(value="show24")
	public String test24(Model model,User user) {
		model.addAttribute("msg",user);
		return "hello";
	}


}
