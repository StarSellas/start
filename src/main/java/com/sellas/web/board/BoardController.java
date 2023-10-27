package com.sellas.web.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

	@Autowired 
	private BoardService boardService;
	
	// (카테고리별) 게시판페이지
	@GetMapping("/board")
	public String notice(@RequestParam(value = "cate", required = false, defaultValue = "1") int cate, Model model) {

		List<Map<String, Object>> setupboardList = boardService.setupboardList(cate);
		List<Map<String, Object>> boardList = boardService.boardList(cate);
		model.addAttribute("list", boardList);
		model.addAttribute("board", setupboardList);
		
		return "board";
	}
		
	// 글쓰기 페이지
	@GetMapping("/boardWrite")
	public String boardWrite(@RequestParam(value = "cate", required = false, defaultValue = "1") int cate, Model model) {
		List<Map<String, Object>> setupboardList = boardService.setupboardList(cate);
		model.addAttribute("board", setupboardList);

		return "boardWrite";
	}
	
	// 글쓰기 로직
	@PostMapping("/boardWrite")
	public String boardWrite(@RequestParam Map<String, Object> map) {
		int result = boardService.boardWrite(map);
		//System.out.println("bno는 :" + map.get("bno"));
		if(result == 1) {
			return "redirect:/boardDetail?cate="+map.get("cate")+"&bno="+map.get("bno");
		} else {
			System.out.println("글쓰기 실패");
			return "redirect:/boardDetail?cate="+map.get("cate");
		}
	}
	
	// 게시글 페이지
	@GetMapping("boardDetail")
	public String boardDetail(@RequestParam("bno") int bno, Model model) {
		//System.out.println("디테일의 bno : " +  bno);
		Map<String, Object> detailList = boardService.boardDetail(bno);
		List<Map<String, Object>> commentList = boardService.commentList(bno);
		//System.out.println(detailList);
		//{bno=11, bread=0, mnickname=셀라스, commentcount=0, bdate=12:29:22, sno=2, btitle=글써, bcontent=글써, mno=1}
		model.addAttribute("detail", detailList);
		model.addAttribute("comments", commentList);
		//System.out.println(commentList);
		//{bno=5, mnickname=셀라스, cdate=17:21:09, cno=1, ccontent=댓글입니다, clike=0}
		
		return "boardDetail";
	}
	
	// 게시글수정 페이지
	@GetMapping("boardEdit")
	public String boardEdit(@RequestParam("bno") int bno, Model model) {
		Map<String, Object> detailList = boardService.boardDetail(bno);
		//System.out.println(detailList);
		// {bno=11, bread=0, mnickname=셀라스, commentcount=0, bdate=12:29:22, sno=2, btitle=글써, bcontent=글써, mno=1}
		model.addAttribute("detail", detailList);
		
		return "boardedit";
	}
	
	// 게시글수정 로직
	@PostMapping("boardEdit")
	public String boardEdit(@RequestParam Map<String, Object> map) {
		//System.out.println(map);
		// {btitle=판매해주세여, bcontent=판매좀해주세여, bno=6, cate=2}
		int result = boardService.boardEdit(map);
		//System.out.println(result);
		
		if(result == 1) {
			return "redirect:/boardDetail?cate="+map.get("cate")+"&bno="+map.get("bno");
		} else {
			System.out.println("글수정 실패");
			return "redirect:/boardDetail?cate="+map.get("cate");
		}
	}
	
	// 게시글삭제 로직
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam Map<String, Object> map) {
		//System.out.println(map);
		int result = boardService.boardDelete(map);
		//System.out.println(result);
		
		return "redirect:/board?cate="+map.get("cate");
	}
	
	// **************************************** 댓글 ****************************************
	
	@GetMapping("cdelete")
	public String cdelete(@RequestParam int cno) {
		
		return "";
	}
	
	
	
	
	
	
	
}
