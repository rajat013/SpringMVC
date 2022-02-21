package com.stackroute.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stackroute.myapp.model.UserProfile;
import com.stackroute.myapp.repository.UserRepo;

@Controller
public class MyAppController {
	
	
	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	
	UserRepo urepo=context.getBean("userrepo",UserRepo.class);
	
	@GetMapping("/")
	
	public String showUI()
	{       System.out.println("added from git cli");
		return "welcome";
	}
	
	
	@PostMapping("/save")
	
//	public String getName(@RequestParam("txtname") String nam,ModelMap mp)
//	{
//	
//		System.out.println("name is" + nam);
//		mp.put("name",nam);
//		
//		return "login";
//		
//	
//	}
		
// @GetMapping("/save")
	
	public ModelAndView getName(@ModelAttribute("UserProfile") UserProfile user,ModelAndView modelview)
	{
	
		 urepo.addUser(user);
		
		modelview=new ModelAndView("welcome");
		
		modelview.addObject("records", urepo.getUsers());
		
		return modelview;
		
		
		//mp.put("name",nam);
		
		//return "login";
		
	
	}
	
	
	@RequestMapping("deluser")
	public String deleteUser(@RequestParam("username") String name,ModelMap map)
	{
		urepo.deleteUser(name);
		map.put("records",urepo.getUsers());
		return "welcome";
	}
	
	@RequestMapping("modifyuser")
	public String modifyUser(@RequestParam("username") String name,ModelMap map)
	{
	//	urepo.deleteUser(name);
		urepo.update(name);
		map.put("userdetail",urepo.getUserbyName(name));
		map.put("records",urepo.getUsers());
		return "welcome";
		
		
	}
	
	 
}
