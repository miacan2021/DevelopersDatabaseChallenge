package com.a0521.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a0521.pma.dao.DeveloperRepository;
import com.a0521.pma.entity.Developer;

import java.util.List;


@Controller
@RequestMapping("/developers")
public class DevelopersController {
	
	@Autowired
	DeveloperRepository devRepo;

	@GetMapping
	public String displayDev(Model model) {
		List<Developer> developers = devRepo.findAll();
		model.addAttribute("developerList", developers);
		model.addAttribute("developer", new Developer());
		return "developers";
	}
	

	@PostMapping("/save")
	public String createProject(Developer developer, Model model) {
		devRepo.save(developer);
		return "redirect:/developers";
	}

}