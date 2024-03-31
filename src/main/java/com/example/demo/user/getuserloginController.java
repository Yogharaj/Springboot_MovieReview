package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.repos.userrepo;
import com.example.demo.tables.users;

@Controller
public class getuserloginController {

	@Autowired
	userrepo rep;
	
	@RequestMapping("adduser")
	@ResponseBody
	public String adduser(String name,String pass)
	{
		users u=new users();
		u.setUsername(name);
		u.setPass(pass);
		if(rep.userexists(name))
		{
			return "Username already exists";
		}
		rep.save(u);
		return "User added successfully";
	}
}
