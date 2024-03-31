package com.example.demo.watchlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.repos.watchlistrepo;
import com.example.demo.tables.watchlist;

@Controller
public class getwatchlistController {
	
	@Autowired
	watchlistrepo rep;
	
	@RequestMapping("addtowatchlist")
	@ResponseBody
	public String add(watchlist w)
	{
		if(rep.checkrec(w.getUsername(), w.getPass()))
		{
			rep.save1(w.getUsername(),w.getMname(),w.getPass());
			String d="Movie added to watchlist user:";
			d+=w.getUsername();
			return d;
		}
		return "Incorrect username or password";
	}
	
	@RequestMapping("getwatchlist")
	@ResponseBody
	public String get(String name,String pass)
	{
		if(rep.checkrec(name,pass))
		{
			List<String> l1=rep.getrec(name);
			String d="";
			for(String x:l1)
			{
				d+=x;
				d+='\n';
			}
			return d;
		}
		return "Incorrect username or password";
	}
	
	@RequestMapping("deletewatchlist")
	@ResponseBody
	public String delete(String name,String pass,String mname)
	{
		if(rep.checkrec(name,pass))
		{
			rep.del1(name,pass,mname);
			String d="";
			d+="Movie "+mname+" deleted from user:"+name+" watchlist";
			return d;
		}
		return "Incorrect username or password";
	}
}
