package com.example.AdminDataLab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.AdminDataLab.AdminDao;
import com.example.AdminDataLab.entity.Admin;


@Controller
public class AdminController {
	
	@Autowired
	AdminDao a;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",a.findAll() );
		System.out.println(a.findAll());
		return "index";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam("playerName") String n) {
		Admin a1 = a.findByName(n);
		System.out.println(a1);
		
		return new ModelAndView("search", "admin", a1);
	}
	
	@PostMapping("/add")
	public ModelAndView addNewPlayer(@RequestParam("playerName") String n, @RequestParam("playerPosition") String pos) {
		Admin a1 = new Admin(n, pos);
		a.update(a1);
		return new ModelAndView("index", "admin", a.findAll());
	}
	
	@RequestMapping("/update")
	public ModelAndView updatePlayer(@RequestParam("playerName") String n) {
		return new ModelAndView("updateform","n",n); 
	}
	
	@PostMapping("/updateperson")
	public ModelAndView updatePerson(@RequestParam("playerName") String n, @RequestParam("playerPosition") String pos) { 
		
		Admin a1 = new Admin(n, pos);
		a.update(a1);
		return new ModelAndView("index", "list", a.findAll());
	}
	
	@RequestMapping("/delete")
	public ModelAndView remove(@RequestParam("playerName") String n) {
		a.deleteByName(n);
		return new ModelAndView("index", "list", a.findAll());
	}

}
