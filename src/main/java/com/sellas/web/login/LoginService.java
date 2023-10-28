package com.sellas.web.login;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;

	
	/* LOGIN : 로그인 */
	
	public boolean login(Map<String, String> map) {
		
		Map<String, Object> result = loginDAO.login(map);
		
		if(result != null) {
			HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
            session.setAttribute("muuid", result.get("muuid"));
			return true;
		} else {
			return false;
		}
	}

	/* LOGOUT : 로그아웃 */
	
	public void logout() {
		
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        
		if(session.getAttribute("muuid") != null) session.removeAttribute("muuid");
	}
}
