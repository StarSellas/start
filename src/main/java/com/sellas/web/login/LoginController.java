package com.sellas.web.login;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	
	/* LOGIN : 로그인 */
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@ResponseBody
	@PostMapping("/login")
	public boolean login(@RequestParam Map<String, String> map) {
		
		return loginService.login(map);
	}
	
	/* LOGOUT : 로그아웃 */
	
	@GetMapping("/logout")
	public String logout() {
		
		loginService.logout();
		
		return "login";
	}
}
