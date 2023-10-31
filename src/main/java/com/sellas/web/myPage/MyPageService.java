package com.sellas.web.myPage;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyPageService {

	@Autowired
	MyPageDAO myPageDAO;
	
	
	@Transactional(rollbackFor = Exception.class)
	public int inputReview(ReviewDTO reviewDTO, HttpSession session) {
		
		System.out.println("세션에 내 uuid있나요?"+session.getAttribute("muuid"));
		   String uuid = String.valueOf(session.getAttribute("muuid"));
		    reviewDTO.setMuuid(uuid);
		
	    try {
	    	//평점합치기
	        int rpoint = reviewDTO.getReviewStar1() + reviewDTO.getReviewStar2() + reviewDTO.getReviewStar3();
	        reviewDTO.setRpoint(rpoint);
	        
	        //상대방의 uuid가져오기
	        if(uuid.equals(reviewDTO.getPseller())) {
	        	String targetMember = reviewDTO.getPbuyer();
	        	reviewDTO.setTargetMember(targetMember);
	        	
	        } else {
	        	String targetMember = reviewDTO.getPseller();
	        	reviewDTO.setTargetMember(targetMember);
	        	
	        }
	        
	        int resultInput = myPageDAO.inputReview(reviewDTO);
	        int resultUpdate = myPageDAO.updatePoint(reviewDTO);

	        if (resultInput == 1 && resultUpdate == 1) {
	            return 1; // 성공적으로 처리됨
	        } else {
	            return 0; // 하나 이상의 작업이 실패함
	        }
	    } catch (Exception e) {
	        // 예외 처리
	        return -1;
	    }
	}

	public ReviewDTO findId(String pno) {
		return myPageDAO.findId(pno);
	}

	public Map<String, Object> memberInfo(String uuid) {
		return myPageDAO.memberInfo(uuid);
	}

	public int isNicknameExists(String newNickname) {
		
		return myPageDAO.isNicknameExists(newNickname);
	}

	public int nicknameModify(Map<String, Object> map) {

		return myPageDAO.nicknameModify(map);
	}


	

}
