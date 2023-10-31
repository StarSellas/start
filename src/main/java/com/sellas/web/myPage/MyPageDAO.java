package com.sellas.web.myPage;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageDAO {

	int inputReview(ReviewDTO reviewDTO);

	ReviewDTO findId(String pno);

	int updatePoint(ReviewDTO reviewDTO);

	Map<String, Object> memberInfo(String uuid);

	int isNicknameExists(String newNickname);

	int nicknameModify(Map<String, Object> map);

}
