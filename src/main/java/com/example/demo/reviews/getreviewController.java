package com.example.demo.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.repos.reviewrepo;
import com.example.demo.tables.reviews;

@Controller
public class getreviewController {
	
	@Autowired
	reviewrepo rep;
   
	@RequestMapping("addreview")
	@ResponseBody
	public String addreview(reviews r)
	{
		rep.save1(r.getMname(),r.getMreview(),r.getRating());
		double c=rep.getCountByMName(r.getMname());
		double r1=rep.getrating(r.getMname());
		double r2=r.getRating();
		double r3=((c*r1)+r2)/(c+1);
		rep.updaterec(r.getMname(), r3);
		return "Review Added";
	}
	
	@RequestMapping("getreview/{mname}")
	@ResponseBody
	public String getreview(@PathVariable("mname") String name)
	{
		return rep.findBymname(name);
	}
}
