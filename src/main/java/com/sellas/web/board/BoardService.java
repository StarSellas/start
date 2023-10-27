package com.sellas.web.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		map.put("muuid", "asdfda321412asd");
		return boardDAO.boardWrite(map);
	}

	public Map<String, Object> boardDetail(int bno) {
		return boardDAO.boardDetail(bno);
	}

	public int boardEdit(Map<String, Object> map) {
		return boardDAO.boardEdit(map);
	}

	public int boardDelete(Map<String, Object> map) {
		return boardDAO.boardDelete(map);
	}

	public List<Map<String, Object>> commentList(int bno) {
		return boardDAO.commentList(bno);
	}


}
