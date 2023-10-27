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
        <link rel="stylesheet" href="../css/tradeDetail.css">
        <!-- ******************* 추가 *********************** -->
        <link rel="stylesheet" href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
        <script src="./js/jquery-3.7.0.min.js"></script>
        <style type="text/css">
        <style type="text/css">
.cdel{
 float: right;
}
.cedit {
 float: right;
}

#main{
   margin: 0 auto;
   width:95%;
   margin-top: 60px;
   color: black;
}
#detail{
   background-color: white;
   margin: 0 auto;
   width: 90%;
   height: auto;
   margin-top: 15px;
   color: black;
   padding: 10px;
   box-sizing: border-box;
}
#detailH{
   height: 40px;
   line-height: 40px;
   font-size: x-large;
   border-bottom: 1px solid black;
   box-sizing: border-box;
   overflow: hidden;
}
#detailIdDate{
   height: 50px;
   line-height: 30px;
   border-bottom: 1px gray solid;
   padding:10px;
   box-sizing: border-box;
   
}
#detailID, #detailDate{
   width: 45%;
   float: left;
   text-align: left;
}
#detailDate{
   float: right;
   text-align: right;
}
#detailContent{
   padding:10px;
   min-height:300px;
   height: auto;
   border-bottom: 1px solid white;
   box-sizing: border-box;
   text-align: left;
}

textarea {
  border: none;
  outline: none; /* 선택 시 나타나는 외곽선도 없앨 수 있습니다. */
  /* 여기에 원하는 다른 스타일을 추가할 수 있습니다. */
}
</style>
        
        
        
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
        
            <div class="container px-4 px-lg-5 mt-5 tradecontainter" style="z-index: 10">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    
                 <div id="detail">

			세션값이오나용 ${sessionScope.muuid }
			여기에 수정삭제를 만들까 아래에 수정삭제를 만들까 고민해봅시다
			
         <div id="detailH">${detail.ttitle}
         <br>
          </div>
         <div id="detailN_no" style="margin-left: 100%-30px;"> </div>
         <div id="detailIdDate">
            <div id="detailID">${detail.muuid}</div>
            <div id="detailDate">${detail.tdate}  &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;작성자 : ${detail.muuid}</div>
         </div>
         <c:if test="${normalDetailImage ne null }">
         	<c:forEach items="${normalDetailImage }" var="i">
         <img alt="" src="./tradeImgUpload/${i.timage }" style="width: 200px; height: 200px;">
         </c:forEach>
         </c:if>
         
         <div id="detailContent" style="word-wrap: break-word; ">${detail.tcontent}
         <div style="text-align: center;">
          <button>거래 신청(tstate가 0일 경우에만)</button>
         </div>
         </div>

        			
         			
 					
                   </div>
                 
                   
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
