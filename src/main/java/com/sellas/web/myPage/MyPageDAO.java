package com.sellas.web.myPage;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageDAO {

	int inputReview(ReviewDTO reviewDTO);

	ReviewDTO findId(String pno);

	int updatePoint(ReviewDTO reviewDTO);

	Map<String, Object> memberInfo(String uuid);

	int isNicknameExists(String newNickname);

	int nicknameModify(Map<String, Object> map);

	List<Map<String, Object>> getprofileReview(Object attribute);

	ReviewDTO reviewDetail(int rno);

}
