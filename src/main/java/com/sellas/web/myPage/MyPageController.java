package com.sellas.web.myPage;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import retrofit2.http.GET;

@Controller
public class MyPageController {

	@Autowired
	MyPageService myPageService;

	@GetMapping("/mypage")
	public String myPage(Model model, HttpSession session) {
		
		String uuid = String.valueOf(session.getAttribute("muuid"));
		//가져오는값 :mnickname, mpoint, mbalance
		
		//세션에 저장된 uuid를 가지고 멤버조회
		Map<String, Object> member = myPageService.memberInfo(uuid);
		
		//일치하는 정보가 없다면
		if(member == null) {
			return "login";
		}
		
		 session.setAttribute("mnickname", member.get("mnickname"));
		 session.setAttribute("mpoint", member.get("mpoint"));
		 model.addAttribute("nickname", session.getAttribute("mnickname"));
		 model.addAttribute("exp", session.getAttribute("mpoint"));
		 
		return "mypage";
	}

	@GetMapping("/profile")
	public String profile(Model model, HttpSession session) {
		
		//로그인 안했을시
		if(session==null) {
			return "login";
		}
		
		 model.addAttribute("nickname", session.getAttribute("mnickname"));
		 model.addAttribute("exp", session.getAttribute("mpoint"));

		return "profile";
	}
	
	//프로필수정(닉네임/사진)
	@GetMapping("/profileEdit/{muuid}")
	public String profileEdit(@PathVariable("muuid") String uuid, Model model, HttpSession session) {
		
		model.addAttribute("nickname", session.getAttribute("mnickname"));
		
		return "profileEdit";
	}
	
	
	/**
	 * 닉네임 중복검사
	 * @param newNickname
	 * @return
	 */
    @PostMapping("/profileEdit/isNicknameExists")
    @ResponseBody
    public int isNicknameExists(@RequestParam("newNickname") String newNickname) {
	int result = myPageService.isNicknameExists(newNickname); 	
    	return result;
    }
	

    @PostMapping("/profileEdit/nicknameModify")
    @ResponseBody
    public int mypageModify(@RequestParam Map<String, Object> map, HttpSession session) {
    
    	System.out.println("뭐있음?"+map);
    	map.put("uuid",session.getAttribute("muuid"));
    	int result = myPageService.nicknameModify(map);

      return result;
    }
	

	//거래후기글쓰기
	@GetMapping("review")
	public String review(@RequestParam("pno") String pno, Model model, HttpSession session) {
		// 구매자,판매자확인
		ReviewDTO reviewMember = myPageService.findId(pno);
		
		// 구매정보불러와서 화면전환
		// 후기쓰는 자가 판매자인 경우
		if (reviewMember.getPseller() == session.getAttribute("muuid")) {
			model.addAttribute("type", "seller");
			model.addAttribute("reviewMember",reviewMember);
			return "review";
		}
		model.addAttribute("type", "buyer");
		model.addAttribute("reviewMember",reviewMember);
		return "review";

	}

	
	@PostMapping("review")
	public String review(ReviewDTO reviewDTO, HttpSession session) {

		int result = myPageService.inputReview(reviewDTO, session);
		
		if (result == 1) {
			return "mypage";
			
		} else {
			return "profile";
		}


	}

}
