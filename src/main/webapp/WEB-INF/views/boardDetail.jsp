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
        <link href="css/detail.css" rel="stylesheet">
        <script src="./js/jquery-3.7.0.min.js"></script>
        
        <script type="text/javascript">
       		 
        	function bedit(bno){
       			 //alert("수정할 글번호 : " + bno);
       			 let edit = confirm("글을 수정하시겠습니까?")
       			 //console.log(edit);
       			 if(edit){
       				 location.href="/boardEdit?cate=${detail.sno}&bno=${detail.bno }";
       			 }
       		 }
        	
        	function bdelete(bno){
      			 let bdelete = confirm("글을 삭제하시겠습니까?")
       			 console.log(bdelete);
      			 if(bdelete){
       				 location.href="/boardDelete?cate=${detail.sno}&bno=${detail.bno }";
       			 }
        	}
        
        </script>
        
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
        
            <div class="container px-4 px-lg-5 mt-5" style="z-index: 10"></div>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    
                  <h5>카테고리번호 : ${detail.sno }</h5>
                  <div class="detailContainer">
	                  <div class="titleBox">
	                  	<div> 제목 : ${detail.btitle } // <span>조회수 : ${detail.bread }</span></div>
	                  	<div>글쓴이 : ${detail.mnickname } // <span>날짜 : ${detail.bdate }</span></div>
	                  </div>
	                  <div class="contentBox">
		                  <div>내용 : ${detail.bcontent }</div>
	                  </div>
	                  <div class="buttonBox">
		                  <button onclick="bedit(${detail.bno})">글수정</button>
		                  <button onclick="bdelete(${detail.bno})">글삭제</button>
		              </div>
                  </div>  
                   
                   <div class="commentContainer">댓글창영역</div>
                   
                </div>
            </div>
            
        </section>
        <!-- Footer-->
        <footer id="footer">
            <div class="container">
	            <ul class="menubar">
	            	<li onclick="location.href='./'"><i class="xi-home xi-2x"></i><div id="menu">홈</div></li>
	            	<li><i class="xi-message xi-2x"></i><div id="menu">채팅</div></li>
	            	<li><i class="xi-profile xi-2x"></i><div id="menu">마이페이지</div></li>
	            </ul>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
