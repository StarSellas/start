package com.sellas.web.board;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardController {

	@Autowired 
	private BoardService boardService;
	
	// (카테고리별)게시판페이지
	@GetMapping("/board")
	public String board(@RequestParam(value = "cate", required = false, defaultValue = "1") int cate, Model model) {

		List<Map<String, Object>> setupboardList = boardService.setupboardList(cate);
		List<Map<String, Object>> boardList = boardService.boardList(cate);
		//System.out.println(setupboardList);
		//[{sno=1, sname=공지사항}, {sno=3, sname=나눔}, {sno=2, sname=판매요청}]
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
	public String boardWrite(@RequestParam("boardimg")MultipartFile boardimg, 
							@RequestParam Map<String, Object> map) {
		// 파일이 있다면 업로드
		if(!boardimg.isEmpty()) {
			
			HttpServletRequest request = 
			         ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
			String path = request.getServletContext().getRealPath("/boardImgUpload");
			System.out.println("경로: "+ path);
			//경로: C:\Users\gogus\git\sellas\src\main\webapp\boardImgUpload

			
			System.out.println(boardimg.getOriginalFilename());
			System.out.println(boardimg.getSize());
			System.out.println(boardimg.getContentType());
			//resource-28.jpg
			//81618
			//image/jpeg
			File boardimgName = new File(path, boardimg.getOriginalFilename());
			
			try {
				boardimg.transferTo(boardimgName);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("파일올림");
			map.put("bimage", boardimg.getOriginalFilename());
		}
		
		int result = boardService.boardWrite(map);
		// System.out.println("bno는 :" + map.get("bno"));
		int result2 = boardService.boardWrite2(map);
		System.out.println(result2);
		
		if (result == 1 && result2 == 1) {
			return "redirect:/boardDetail?cate=" + map.get("cate") + "&bno=" + map.get("bno");
		} else {
			System.out.println("글쓰기 실패");
			return "redirect:/boardDetail?cate=" + map.get("cate");
		}
	}
	
	// 게시글 + 댓글 페이지
	@GetMapping("boardDetail")
	public String boardDetail(@RequestParam Map<String, Object> map, Model model) {
		//System.out.println("디테일map : " +  map); // 디테일map : {cate=2, bno=5}
		Map<String, Object> detailList = boardService.boardDetail(map);
		List<Map<String, Object>> commentList = boardService.commentList(map);
		//System.out.println("디테일페이지 : " + detailList);
		//{bno=5, bread=0, mnickname=셀라스, commentcount=2, bdate=14:27:46, sno=2, sname=판매요청, btitle=판매요청글씀, bcontent=ㅁㅇㄴㄹ, mno=1}
		model.addAttribute("bdetail", detailList);
		model.addAttribute("comments", commentList);
		//System.out.println(commentList);
		//{bno=5, mnickname=셀라스, cdate=17:21:09, cno=1, ccontent=댓글입니다, clike=0}
		
		return "boardDetail";
	}
	
	// 게시글수정 페이지
	@GetMapping("boardEdit")
	public String boardEdit(@RequestParam Map<String, Object> map, Model model) {
		Map<String, Object> detailList = boardService.boardDetail(map);
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
		if(result == 1) {
			return "redirect:/board?cate="+map.get("cate");
		} else {
			System.out.println("글삭제 실패");
			return "redirect:/board?cate="+map.get("cate");
		}
	}
	
	// **************************************** 댓글 ****************************************
	
	
	// 댓글쓰기
	@PostMapping("commentWrite")
	public String commentWrite(@RequestParam Map<String, Object> map) {
		//System.out.println(map); // {ccontent=댓글다시써, cate=2, bno=4}
		int result = boardService.commentWrite(map);
		
		if(result == 1) {
			return "redirect:/boardDetail?cate="+map.get("cate")+"&bno="+map.get("bno");
		} else {
			System.out.println("댓글쓰기 실패");
			return "redirect:/boardDetail?cate="+map.get("cate")+"&bno="+map.get("bno");
		}
	}
	
	// 댓글삭제
	@GetMapping("commentDelete")
	public String commentDelete(@RequestParam Map<String, Object> map) {
		System.out.println("잡아온값 :" +map);
		// 잡아온값 :{cate=2, bno=5, cno=1}
		int result = boardService.commentDelete(map);
		//System.out.println("결과값 :" + result);
		
		if(result == 1) {
			return "redirect:/boardDetail?cate="+map.get("cate")+"&bno="+map.get("bno");
		} else {
			System.out.println("댓글삭제 실패");
			return "redirect:/boardDetail?cate="+map.get("cate")+"&bno="+map.get("bno");
		}
	}
	
	// 댓글수정
	@PostMapping("commentEdit")
	public String commentEdit(@RequestParam Map<String, Object> map) {
		
		System.out.println(map);
		//{bno=4, cno=3, cate=2, ccontent=댓글3수정}

		int result = boardService.commentEdit(map);
		System.out.println(result);
		
		if(result == 1) {
			return "redirect:/boardDetail?cate="+map.get("cate")+"&bno="+map.get("bno");
		} else {
			System.out.println("댓글수정 실패");
			return "redirect:/boardDetail?cate="+map.get("cate")+"&bno="+map.get("bno");
		}
	}
	
	
	// 카테고리 테스트
	@GetMapping("test")
	public String boardTest(@RequestParam(value = "cate", required = false, defaultValue = "1") int cate, Model model) {
		List<Map<String, Object>> setupboardList = boardService.setupboardList(cate);
		List<Map<String, Object>> boardList = boardService.boardList(cate);
		model.addAttribute("list", boardList);
		model.addAttribute("board", setupboardList);
		
		return "test";
	}
	
	
	
}
