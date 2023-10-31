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
        
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light" style="z-index: 10">
           <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="">SellAS</a>
                <button class="navbar-toggler" type="button" data-bs-target="" aria-controls="navbarSupportedContent"><img src="../img/menuIcon.png" id="menuIcon" alt="menuIcon"></button>
           </div>
        </nav>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder"></h1>
                    <p class="lead fw-normal text-white-50 mb-0">안녕하세요 ${memberInfo.mnickname }님!!</p>
                </div>
            </div>
        </header>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5" style="z-index: 10" id="productContainer">
                <div style="text-align: center;">
                <button onclick="location.href='./normalWrite'" style="background-color: red; width: 50px; height: 50px;">물품 등록</button>
                <button onclick="location.href='./fillPay'" style="background-color: yellow; width: 50px; height: 50px;">머니 충전</button><br>
                </div>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
        <c:forEach items="${normalBoardList }" var="i">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
							<c:choose>
                          	<c:when test="${i.thumbnail ne null }">
                          	<img class="card-img-top" src="./tradeImgUpload/${i.thumbnail }" alt="thumbnail" />
                          	</c:when>
                          	<c:otherwise>
                            <img class="card-img-top" src="./tradeImgUpload/defaultimg.jpg" alt="..." />
                            </c:otherwise>
                            </c:choose>
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">${i.ttitle }</h5>
                                    <!-- Product price-->
                                   작성자 :  ${i.mnickname }<br>
                                    ${i.tnormalprice } 웨일페이<br>
                                   
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div style="text-align: center;">
                            	<c:if test="${i.tnormalstate ==0 }">
                            	판매중
                            	</c:if>
                            	<c:if test="${i.tnormalstate ==1 }">
                            	거래중
                            	</c:if>
                            	<c:if test="${i.tnormalstate ==2 }">
                            	판매완료
                            	</c:if>
                            </div>
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="./normalDetail?tno=${i.tno }">상품 보러가기</a></div>
                            </div>
                        </div>
                    </div>
                             </c:forEach>

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
