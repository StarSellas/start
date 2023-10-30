package com.sellas.web.trade;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NormalDAO {

	List<Map<String, Object>> cateList();

	List<Map<String, Object>> normalBoardList();

	Map<String, Object> mainMember(String muuid);

	int insertTradeimg(Map<String, Object> map);

	int normalWrite(Map<String, Object> map);

	Map<String, Object> normalDetail(int tno);

	int normalDetailCount(int tno);

	List<Map<String, Object>> normalDetailImage(int tno);

 
	void setThumbnail(String realFileName);

	int normalDelete(Map<String, Object> map);

	void fillWhalePay(Map<String, Object> map);

	int normalEdit(Map<String, Object> map);

	int normalDeleteEditImage(Map<String, Object> deleteImage);

	int SelectnormalThumbnail(Map<String, Object> map);

	

}
