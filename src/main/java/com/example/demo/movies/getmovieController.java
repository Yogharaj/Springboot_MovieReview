package com.example.demo.movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repos.movierepo;
import com.example.demo.tables.movies;

@Controller
public class getmovieController 
{
	@Autowired
	movierepo rep;
	@PostMapping("addmovie")
	@ResponseBody
	public String addmovie(movies m)
	{
		rep.save(m);
		return "Movie Added";
	}
	
	@RequestMapping("getmovies")
	@ResponseBody
	public 	String getmovie()
	{
	    return rep.findAll().toString();
	}
	
	@RequestMapping("getmovie/{name}")
	@ResponseBody
	public String getmovie(@PathVariable("name") String name)
	{
		movies m1=rep.findByMname(name);
		return m1.mdesc;
	}
}
