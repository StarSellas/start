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
	<nav class="navbar navbar-expand-lg navbar-light bg-light" style="z-index: 10">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="/">SellAS</a>
			<c:choose>
				<c:when test="${sessionScope.muuid eq null}">
					<a href="/login">로그인</a>
				</c:when>
				<c:otherwise>
					<span>${sessionScope.mnickname} 로그인완</span>
				</c:otherwise>
			</c:choose>
			<button class="navbar-toggler" type="button" data-bs-target="" aria-controls="navbarSupportedContent">
				<a href="/menu"><img src="../img/menuIcon.png" id="menuIcon" alt="menuIcon"></a>
			</button>
		</div>
	</nav>



	<!-- Footer-->
        <footer id="footer">
            <div class="container">
	            <ul class="menubar">
	            	<li onclick="location.href='./'"><i class="xi-home xi-2x"></i><div id="menu">홈</div></li>
	            	<li onclick="location.href='#'"><i class="xi-message xi-2x"></i><div id="menu">채팅</div></li>
	            	<li onclick="location.href='#'"><i class="xi-profile xi-2x"></i><div id="menu">마이페이지</div></li>
	            </ul>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
