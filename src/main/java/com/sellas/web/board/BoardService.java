package com.sellas.web.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;

	public List<Map<String, Object>> noticeList(int board) {
		return boardDAO.noticeList(board);
	}

	public List<Map<String, Object>> setupboardList(int board) {
		return boardDAO.setupboardList(board);
	}


}
