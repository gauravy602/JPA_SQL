package com.khushi.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khushi.demo.dao.AlienRepo;
import com.khushi.demo.model.*;


@Controller
public class AlienController {
	@Autowired
	AlienRepo repo;
	Alien a = new Alien();
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addalien(Alien a) {
		repo.save(a);
		return "home.jsp";
	}
	@RequestMapping("/getAlien") 
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView();
		Alien al= new Alien();
		 al = repo.findById(aid).orElse(new Alien());
		 System.out.println(al);
	     mv.addObject("name",al);
	     mv.setViewName("result.jsp");
	     return mv;
	}
	
}
