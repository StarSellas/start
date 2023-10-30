<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        
        <!-- ******************* 추가 *********************** -->
        <link rel="stylesheet" href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
        <script src="./js/jquery-3.7.0.min.js"></script>
        
    </head>
    <body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light"
		style="z-index: 10">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="">SellAS</a>
            <button class="navbar-toggler" type="button" data-bs-target="" aria-controls="navbarSupportedContent"><img src="../img/menuIcon.png" id="menuIcon" alt="menuIcon"></button>
		</div>
	</nav>
	<!-- Header-->
        <header>

        </header>
        <!-- Section-->
        <section class="py-5">
        
            <div class="container px-4 px-lg-5 mt-5" style="z-index: 10">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <form action="./normalWirte" method="post" enctype="multipart/form-data">
                    <input type="hidden" value="${muuid }" name="muuid">
                    
                  <input type="text" placeholder="제목을 입력해주세요" name="ttitle"><br>
                  <br>
                  이 사이에 카테고리 설정해야징
                  	<select name="category">
                  	<c:forEach items="${categoryList }" var="i">
                  	<option value="${i.ino }">${i.iname }</option>
                  	</c:forEach>
                  	</select>
                  
                  
                  <br>
                  경매 종류도 설정해야지?? 물품등록하면 그냥 거래인가?
                  
                  <div>
                  <textarea placeholder="내용을 입력해주세요." name="tcontent"></textarea>
                    </div>
                    <br>
                    <br>
                    가격 : <input type="number" name="tnormalprice">원
                    
                    
                    <br>
                    <button id="addPhotoButton" type="button">사진 추가하기</button>
                    <br>
                    최대 3장
                    <div id="photoInputs">
                    <input  type="file" name="tradeimg" id="tradeimg">
                    </div>
                    <br>
                    <br>
                    <br>
                    사진 추가하기 버튼을 만들어서 눌렀을 때 인풋태그가 더 생성될 수 있도록 만들자!
                    최대 3장으로 해놓자!
                    <br>
                    <br>
                    <br>
                    
                   <button type="submit">글쓰깅</button> 
                   </form>
                   
                   제이쿼리를 사용해서 유효성을 검사하고 카테고리 값도 ino로 바꾼 후 잘못된 값이 없으면
                   서브밋하게 만들어야지
                   
                </div>
            </div>
            
        </section>
        <!-- Footer-->
        <footer id="footer">
            <div class="container">
	            <ul class="menubar">
	            	<li><i class="xi-home xi-2x"></i><div id="menu">홈</div></li>
	            	<li><i class="xi-message xi-2x"></i><div id="menu">채팅</div></li>
	            	<li><i class="xi-profile xi-2x"></i><div id="menu">마이페이지</div></li>
	            </ul>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        
        <script type="text/javascript">
        $(function(){
        	var maxPhotos = 2; // 최대 생성 가능한 input 태그 수
            var nextPhotoId = 1;

            $("#addPhotoButton").click(function() {
                if (nextPhotoId <= maxPhotos) {
                    var newInput = $("<input type='file' name='tradeimg' class='photoInput' id='tradeimg" + nextPhotoId + "'>");
                    $("#photoInputs").append(newInput);
                    nextPhotoId++;
                } else {
                    alert("더 이상 사진을 추가할 수 없습니다.");
                }
            });
        	
        });
        
        </script>
        
    </body>
</html>
