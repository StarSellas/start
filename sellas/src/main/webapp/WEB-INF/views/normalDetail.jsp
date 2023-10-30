<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>일반거래 디테일</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />

<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<link rel="stylesheet" href="../css/tradeDetail.css">
<!-- ******************* 추가 *********************** -->
<link rel="stylesheet"
	href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script src="./js/jquery-3.7.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light"
		style="z-index: 10">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="">SellAS</a>
			<button class="navbar-toggler" type="button" data-bs-target=""
				aria-controls="navbarSupportedContent">
				<img src="../img/menuIcon.png" id="menuIcon" alt="menuIcon">
			</button>
		</div>
	</nav>
	<!-- Header-->
	<header> </header>
	<!-- Section-->


	<section class="py-5">

		<div class="container px-4 px-lg-5 mt-5 tradecontainter"
			style="z-index: 10" id="productContainer">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

				<div id="detail">
					<input type="hidden" value="${detail.tno }" class="normalTno">
					<input type="hidden" value="${detail.muuid }" class="normalMuuid">
					세션값이오나용 ${sessionScope.muuid } 여기에 수정삭제를 만들까 아래에 수정삭제를 만들까 고민해봅시다

					<h2>제목 : ${detail.ttitle} , 상태 : ${detail.tnormalstate}</h2>
					<br>

					<h6>카테고리 : ${detail.iname }</h6>


					<div id="detailID">${detail.mnickname}</div>
					<div id="detailDate">${detail.tdate}&nbsp;
						&nbsp;&nbsp;&nbsp;작성자: ${detail.mnickname}</div>

					<c:if test="${normalDetailImage ne null }">
						<c:forEach items="${normalDetailImage }" var="i">
							<img alt="" src="./tradeImgUpload/${i.timage }"
								style="width: 200px; height: 200px;">
						</c:forEach>
					</c:if>

					${detail.tcontent}
					<br>
					<c:if test="${sessionScope.muuid == detail.muuid && detail.tnormalstate == 0}">
						<button id="normalEditBtn">수정하기</button>
						<button id="normalDeleteBtn">등록 취소</button>
					</c:if>
					<c:if test="${sessionScope.muuid != detail.muuid &&detail.tnormalstate == 0}">
						<button id="requestTradeBtn">거래 신청</button>
					</c:if>
				</div>
			</div>
		</div>


	</section>
	<!-- Footer-->
	<footer id="footer">
		<div class="container">
			<ul class="menubar">
				<li onclick="location.href='./'"><i class="xi-home xi-2x"></i>
				<div id="menu">홈</div></li>
				<li><i class="xi-message xi-2x"></i>
				<div id="menu">채팅</div></li>
				<li><i class="xi-profile xi-2x"></i>
				<div id="menu">마이페이지</div></li>
			</ul>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
	<script type="text/javascript">
	
	$(function(){
			let tno = $(".normalTno").val();
			let muuid = $(".normalMuuid").val();
		$("#normalEditBtn").click(function(){
			alert(tno);
			if(confirm("수정하시겠습니까?")){
				alert("ㅎㅎ");
				location.href='./normalEdit?tno='+tno;
			}
		});//수정 버튼 눌렀을 때 끝
		
		$("#normalDeleteBtn").click(function(){
			if(confirm("정말 삭제하시겠습니까?")){
				$.ajax({
					url : "normalDelete",
		               type : "post",
		               data : {tno : tno , muuid: muuid},
		               dataType : "json",
		               success:function(data){
		            	   if(data.deleteSuccess == 1){
		            		   alert("삭제가 완료되었습니다.");
		            		   location.href='/';
		            	   }
		               },
		               error:function(error){
		            	   alert("ㅠㅠ");
		               }
				});
			}
		});//삭제 버튼 눌렀을 때 끝
		
		$("#requestTradeBtn").click(function(){
			alert("!");
		});
		
		
	});
	 
	
	</script>
</html>
