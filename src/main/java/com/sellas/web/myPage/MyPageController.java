package com.sellas.web.myPage;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyPageController {

	@Autowired
	MyPageService myPageService;

	@GetMapping("/mypage")
	public String myPage(Model model, HttpSession session) {

		session.setAttribute("mnickname", "즨이");
		session.setAttribute("mexp", "16");
		model.addAttribute("nickname", session.getAttribute("mnickname"));
		model.addAttribute("exp", session.getAttribute("mexp"));

		return "mypage";
	}

	@GetMapping("/profile")
	public String profile(Model model, HttpSession session) {

		session.setAttribute("mnickname", "즨이");
		session.setAttribute("mexp", "16");
		model.addAttribute("nickname", session.getAttribute("mnickname"));
		model.addAttribute("exp", session.getAttribute("mexp"));

		return "profile";
	}

	@GetMapping("review")
	public String review(@RequestParam("pno") String pno, Model model, HttpSession session) {
		session.setAttribute("uuid", "xcxfdfs4545ssdsd");
		session.setAttribute("mnickname", "즨이");
		session.setAttribute("mexp", "16");
		// 구매자,판매자확인
		ReviewDTO reviewMember = myPageService.findId(pno);
		System.out.println(reviewMember);

		
		// 구매정보불러와서 화면전환
		// 후기쓰는 자가 판매자인 경우
		if (reviewMember.getPseller() == session.getAttribute("uuid")) {
			model.addAttribute("type", "seller");
			model.addAttribute("reviewMember",reviewMember);
			return "review";
		}
		model.addAttribute("type", "buyer");
		model.addAttribute("reviewMember",reviewMember);
		return "review";

	}

	
	@PostMapping("review")
	public String review(ReviewDTO reviewDTO, Model model, HttpSession session) {

		int result = myPageService.inputReview(reviewDTO, session);
		
		if (result == 1) {
			return "mypage";
			
		} else {
			return "profile";
		}


	}

}
