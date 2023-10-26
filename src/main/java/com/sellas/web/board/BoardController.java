package com.sellas.web.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

	@Autowired 
	private BoardService boardService;
	
	@GetMapping("/board")
	public String notice(@RequestParam(value = "board", required = false, defaultValue = "1") int board, Model model) {

		List<Map<String, Object>> setupboardList = boardService.setupboardList(board);
		List<Map<String, Object>> noticeList = boardService.noticeList(board);
		model.addAttribute("list", noticeList);
		model.addAttribute("board", setupboardList);
		
		return "noticeBoard";
	}
		
		
	
}
