package com.sellas.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "main";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/menubar")
	public String menubar() {
		return "menubar";
	}

	@GetMapping("default")
	public String basic() {
		return "default";
	}	

}
