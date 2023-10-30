package com.sellas.web.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;

	public List<Map<String, Object>> boardList(int cate) {
		return boardDAO.boardList(cate);
	}

	public List<Map<String, Object>> setupboardList(int cate) {
		return boardDAO.setupboardList(cate);
	}
	public int boardWrite(Map<String, Object> map) {
		map.put("muuid", "6fd651fd-9922-43c3-b0d9-57e7e6ea4c14");
		return boardDAO.boardWrite(map);
	}
	
	public int boardImage(Map<String, Object> map) {
		return boardDAO.boardImage(map);
	}

	public Map<String, Object> boardDetail(Map<String, Object> map) {
		System.out.println(map);
		//{sno=2, bno=65, imgArr[num0]=20231030184336num0라이언.png, imgArr[num1]=20231030184336num1라이언2.png}
		//{bno=65, bimage=20231030184336num0라이언.png}
		//{bno=65, bimage=20231030184336num1라이언2.png}
		
		return boardDAO.boardDetail(map);
	}

	public List<Map<String, Object>> imageList(Map<String, Object> map) {
		return boardDAO.imageList(map);
	}
	
	public int setThumbnail(Map<String, Object> map) {
		return boardDAO.setThumbnail(map);
	}
	
	public int boardEdit(Map<String, Object> map) {
		return boardDAO.boardEdit(map);
	}

	public int boardDelete(Map<String, Object> map) {
		return boardDAO.boardDelete(map);
	}

	public List<Map<String, Object>> commentList(Map<String, Object> map) {
		return boardDAO.commentList(map);
	}

	public int commentDelete(Map<String, Object> map) {
		return boardDAO.commentDelete(map);
	}

	public int commentWrite(Map<String, Object> map) {
		map.put("muuid", "6fd651fd-9922-43c3-b0d9-57e7e6ea4c14");
		return boardDAO.commentWrite(map);
	}

	public int commentEdit(Map<String, Object> map) {
		return boardDAO.commentEdit(map);
	}

}
