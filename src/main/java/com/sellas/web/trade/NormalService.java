package com.sellas.web.trade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NormalService {
	@Autowired
	private NormalDAO normalDAO;
	
	public List<Map<String, Object>> cateList() {
		// TODO Auto-generated method stub
		return normalDAO.cateList();
	}

	public List<Map<String, Object>> normalBoardList() {
		// TODO Auto-generated method stub
		return normalDAO.normalBoardList();
	}

	public Map<String, Object> mainMember(String muuid) {
		// TODO Auto-generated method stub
		return normalDAO.mainMember(muuid);
	}

	public int insertTradeimg(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return normalDAO.insertTradeimg(map);
		
	}

	
	
	
	
	
	
	public int normalWrite(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return normalDAO.normalWrite(map);
	}

	public Map<String, Object> normalDetail(int tno) {
		// TODO Auto-generated method stub
		return normalDAO.normalDetail(tno);
	}

	public int normalDetailCount(int tno) {
		// TODO Auto-generated method stub
		return normalDAO.normalDetailCount(tno);
	}

	public List<Map<String, Object>> normalDetailImage(int tno) {
		// TODO Auto-generated method stub
		return normalDAO.normalDetailImage(tno);
	}



	public void setThumbnail(String realFileName) {
		normalDAO.setThumbnail(realFileName);
		
	} 

	

}
