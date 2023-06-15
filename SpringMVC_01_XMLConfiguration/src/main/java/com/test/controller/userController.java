package com.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.util.HibernateUtil;

@Controller
@RequestMapping("/user")
public class userController {
	
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public String newUser(Model model) {
		System.out.println("=====>> I am in newUser method of user controller");
		model.addAttribute("User", new User());
		return "userForm";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user")User user) {
		System.out.println("====> i'm in add user method");
		userService.addUser(user);
		return "result";
	}
	
	@RequestMapping(value = "/showalluser")
	public ModelAndView showAllUser(HttpServletRequest request) {
		ArrayList<User> userList = new ArrayList<User>();
		User user1= new User("darshit", 1);
		User user2= new User("tejas", 2);
		User user3= new User("aditya", 3);
		User user4= new User("supriya", 4);
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		
		Map<String, Object> model= new HashMap<String, Object>();
		model.put("employees", userList);
		
		return new ModelAndView("employeeList",model);
	}
	
	@RequestMapping(value="/searchuserpage", method=RequestMethod.GET)
	public String searchUserPage()
	{
		System.out.println("=====>> I am in SearchUser method of user controller");
		return "searchUser";
		}

}
