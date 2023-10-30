<%@page import="java.util.Map"%>
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
        <link href="css/board.css" rel="stylesheet">
        
        <!-- ******************* 추가 *********************** -->
        <link rel="stylesheet" href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
        
    </head>
    <body>
   <!-- Navigation-->
   <nav class="navbar navbar-expand-lg navbar-light bg-light"
      style="z-index: 10">
      <div class="container px-4 px-lg-5">
         <a class="navbar-brand" href="/">SellAS</a>
         <span>${sessionScope.muuid }</span>
         <button class="navbar-toggler" type="button" data-bs-target="" aria-controls="navbarSupportedContent"><a href="/menu"><img src="../img/menuIcon.png" id="menuIcon" alt="menuIcon"></a></button>
      </div>
   </nav>
   <!-- Header-->
        <header>

        </header>
        <!-- Section-->
        <section class="py-5">
        
            <div class="container px-4 px-lg-5 mt-5" style="z-index: 10" id="productContainer">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">


            <!-- 게시판 카테고리 드롭다운 -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4" id="cateBar">
               <li class="nav-item dropdown">
               <c:choose>
                  <c:when test="${empty param}">
                     <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
                     role="button" data-bs-toggle="dropdown" aria-expanded="false">
                     게시판
                     </a>
                  </c:when>
                  <c:otherwise>
                     <c:forEach items="${board}" var="board">
                        <c:if test="${param.cate eq board.sno}">
                           <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
                           role="button" data-bs-toggle="dropdown" aria-expanded="false">
                           ${board.sname }
                           </a>
                           <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                              <li><a class="dropdown-item" href="/board?cate=${board.sno }">${board.sname }</a></li>
                           </ul>
                        </c:if>
                     </c:forEach>
                  </c:otherwise>
               </c:choose>
               
               
                  <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                     <c:forEach items="${board}" var="board">
                        <li><a class="dropdown-item" href="/board?cate=${board.sno }">${board.sname }</a></li>
                     </c:forEach>
                  </ul>
               </li>
            </ul>

            
            <div>
               <table id="boardList">
                  <c:forEach items="${list}" var="list">
                     <tr>
                        <td class="btitle" onclick="location.href='/boardDetail?cate=${param.cate}&bno=${list.bno }'" data-bno="${list.rowNum}">
                           ${list.rowNum} & ${list.bno}. ${list.btitle} (${list.commentcount})
                        </td>
                        <td>${list.bdate}</td>
                        <td>${list.bread}</td>
                     </tr>
                  </c:forEach>
               </table>
            </div>
            
            <div class="writeBtnBox">
               <c:if test="${param.cate eq 2 || param.cate eq 3}">
                     <button class="writeBtn" onclick="location.href='/boardWrite?cate=${param.cate}'">글쓰기</button>
               </c:if>
            </div>

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
    </body>
</html>