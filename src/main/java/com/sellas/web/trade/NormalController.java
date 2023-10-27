package com.sellas.web.trade;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import retrofit2.http.GET;

@Controller
public class NormalController {
	@Autowired
	private NormalService normalService;
	
	//main.jsp로 보내주는 메소드입니다.
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		
		//==========================하드코딩 해놨습니다~~~~~ 합쳐지면 지움===================
		String muuid= "asdfda321412asd";
		session.setAttribute("muuid", muuid);
		//세션에 저장된 uuid를 가지고 회원 정보 조회
		Map<String, Object> mainMemberInfo = normalService.mainMember(muuid);
		//System.out.println("메인 회원의 정보입니다  : " + mainMemberInfo);
		model.addAttribute("memberInfo", mainMemberInfo);
		
		
		//거래 리스트를 뽑아옵니다.
		List<Map<String, Object>> normalBoardList = normalService.normalBoardList();
		
		System.out.println("보드 리스트 : " + normalBoardList);
		//System.out.println(tradeBoardList);
		model.addAttribute("normalBoardList", normalBoardList);
		return "main";
	}
	//default jsp로 보내주는 메소드입니다.
	@GetMapping("default")
	public String basic() {
		return "default";
	}	
	
	//글 쓰기를 눌렀을 때 tradeWrite로 보내주는 메소드입니다.
	@GetMapping("/normalWrite")
	public String tradeWrite(Model model, HttpSession session) {
		//세션에 값이 없으면 로그인 창으로 보내기 설정
		
		
		model.addAttribute("muuid", session.getAttribute("muuid"));
		
		
		//카테고리 list로 불러오기
		List<Map<String, Object>> categoryList =  normalService.cateList();
		
		System.out.println(categoryList);  
		//[{ino=7, iname=가공식품}, {ino=2, iname=가구 / 인테리어},....]
		
		model.addAttribute("categoryList", categoryList);
		return "normalWrite";
	}
	
	//글쓰기 버튼을 눌렀을 때 실행되는 메소드입니다.
	//사진 파일 업로드 사용하실거면 매개변수 tradeimg랑 주석 참고
	@PostMapping("/normalWirte")
	public String tradeWirte(@RequestParam(value="tradeimg",required = false) List<MultipartFile> tradeimg ,@RequestParam Map<String, Object> map) {
		//System.out.println("글쓰기에서 보내주는 값입니당 : " + map);
		//System.out.println("이미지가 오려나..?" + tradeimg);
		//System.out.println("트레이드 이미지 사이즈는 : " + tradeimg.size());
		
		
		  
		//tnormalstate값 넣어주기
		map.put("tnormalstate", 0);
		//ttype값 넣어주기
		map.put("ttype", 0);
		 	
		//일단 보드에 넣어보자
		int tradeWriteResult = normalService.normalWrite(map);
			if(tradeWriteResult == 1) {
				
				int LastTno = (int) map.get("tno");
				
				System.out.println("★★ 방금 넣은 따끈따끈한 값입니다 : " + LastTno );
				//가져온 tno 값을 맵에 넣기
				map.put("tno", LastTno);
				//여기부터 사진 넣는 방식임다
				
				if (!tradeimg.isEmpty()) {
					
					for (int i = 0; i < tradeimg.size(); i++) {
						
					
					
				      // 저장할 경로명 뽑기 request뽑기
				      HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				            .getRequest();
				      String path = req.getServletContext().getRealPath("/tradeImgUpload");
				      System.out.println("이미지 오리지널 파일 이름 : " + tradeimg.get(i).getOriginalFilename());
				      LocalDateTime ldt = LocalDateTime.now();
				      String format = ldt.format(DateTimeFormatter.ofPattern("YYYYMMddHHmmss"));
				      String realFileName = format +"num"+i+ tradeimg.get(i).getOriginalFilename();
				
				      
				      
				      
				      //확장자 자르기
				      String[] parts = tradeimg.get(i).getOriginalFilename().split("\\.");
				      String lastPart = parts[parts.length - 1];
				      System.out.println(lastPart);
				      
				      
				      
				      //확장자 아니면 파일 없애보리기 
						
						 if(!(lastPart.equals("jpg") || lastPart.equals("png") ||
						  lastPart.equals("jpeg") || lastPart.equals("bmp") || lastPart.equals("gif")
						 || lastPart.equals("jpe"))) { realFileName = "deleteMe"; }
						 
				      
				
				      File newFileName = new File(path, realFileName);
				      
				      //진짜 이름을 맵에 넣기
				      map.put("realFileName", realFileName);
				      
				      try {
				         FileCopyUtils.copy(tradeimg.get(i).getBytes(), newFileName);
				         
				         
				         int insertTradeimgResult = normalService.insertTradeimg(map);
				         
				         if(insertTradeimgResult == 1 &&i==0) {
					    	  normalService.setThumbnail(realFileName);
					      }
				         
				         
				      } catch (IOException e) {
				         e.printStackTrace();
				      } 
				        
					}//for문의 끝
				}//(!tradeimg.isEmpty()) 의 끝(사진 넣기 끝)
			
			}//tradeResult의 값이 1일 때 if 문의 끝
	
		
		
		
		 
		return "redirect:/";
	}
	
	
	@GetMapping("/normalDetail")
	public String tradeDetail(@RequestParam(name = "tno", required = true, defaultValue = "1") int tno, Model model) {
		System.out.println("tno 값은 : " + tno);
		//tno값에 맞는 값을 가져오기
		Map<String, Object> normalDetail = normalService.normalDetail(tno);
		System.out.println("디테일 값입니다 : " + normalDetail);
		//혹시 사진이 있나요?
		int normalDetailCount = normalService.normalDetailCount(tno);
		System.out.println("사진이 있나요? "+normalDetailCount);
		if(normalDetailCount > 0) {
			//사진 realFileName 가져오기
			List<Map<String, Object>> normalDetailImage = normalService.normalDetailImage(tno);
			System.out.println("실제 파일 이름입니당 : " + normalDetailImage);
			//모델에 값 넣기
			model.addAttribute("normalDetailImage", normalDetailImage);
		}
		
		 
		model.addAttribute("detail", normalDetail);
		return "normalDetail";
	}
	
	
	
	
	
	
	
	
}//컨트롤러 끝
