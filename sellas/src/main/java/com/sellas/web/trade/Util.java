package com.sellas.web.trade;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

public class Util {
@Autowired
private NormalService normalService;
	
	public void ImageUpload(List<MultipartFile> tradeimg, Map<String, Object> map) {
			
			for (int i = 0; i < tradeimg.size(); i++) {



		      // 저장할 경로명 뽑기 request뽑기
		      HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
		            .getRequest();
		      String path = req.getServletContext().getRealPath("/tradeImgUpload");
		      System.out.println("이미지 오리지널 파일 이름 : " + tradeimg.get(i).getOriginalFilename());
		      LocalDateTime ldt = LocalDateTime.now();
		      String format = ldt.format(DateTimeFormatter.ofPattern("YYYYMMddHHmmss"));
		      String realFileName = format + tradeimg.get(i).getOriginalFilename();
		      
		      
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
		         
		         System.out.println("넣기 전에 값좀 보자"+map);
		         System.out.println("왜 안되는데!!!!!" + map.get("tno"));
		         System.out.println("왜 안되는데!!!!!" + map.get("realFileName=20231029185915loginkey.png"));
		         
		         normalService.insertTradeimg(map);
		         
		      } catch (IOException e) {
		         e.printStackTrace();
		      }
		        
			}		//(!tradeimg.isEmpty()) 의 끝(사진 넣기 끝)
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
