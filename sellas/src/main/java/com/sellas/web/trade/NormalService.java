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
		//tnormalstate값 넣어주기
				map.put("tnormalstate", 0);
				//ttype값 넣어주기
				map.put("ttype", 0);
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

	public int normalDelete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return normalDAO.normalDelete(map);
	}

	public void fillWhalePay(Map<String, Object> map) {
		// TODO Auto-generated method stub
		normalDAO.fillWhalePay(map);
	}

	public int normalEdit(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return normalDAO.normalEdit(map);
	}

	public int normalDeleteEditImage(Map<String, Object> deleteImage) {
		
		return normalDAO.normalDeleteEditImage(deleteImage);
	}

	public int SelectnormalThumbnail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return normalDAO.SelectnormalThumbnail(map);
	} 

	

}
