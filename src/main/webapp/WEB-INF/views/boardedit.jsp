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
        
        	$(function(){
        		
        		$(".imgEditbtn").click(function(){
        			//alert("!");
        			// 이미지박스
        			let boardImgBox = $(this).parents(".boardImgBox");
        			// 이미지이름
        			let bimage = $(this).parents(".boardImgBox").text();
        			console.log(bimage);
        			
        			// 이미지첨부박스
        			let imgInputBox = "";
        			imgInputBox += '<div class="boardimgBox">'
        						+  '<input type="file" name="boardimg" class="boardimg" id="boardimg">';
        						+  '<button id="addPhotoButton" type="button">사진 추가하기</button>';
        						+  '<div id="photoInputs"><div id="imagePreviews"></div></div>';
        			
        			boardImgBox.after(imgInputBox);
        			boardImgBox.hide();
        			
        		});
        		
        	});
        
        </script>
        <script type="text/javascript">
        
      	  $(function() {
	        	
	            var maxPhotos = 3;
	            var nextPhotoId = 1;
	
	            $("#addPhotoButton").click(function () {
	                
	            	//console.log("떠라");
	            	
	            	if (nextPhotoId <= maxPhotos) {
	                    var newInput = $("<input type='file' name='boardimg' class='boardimg' id='boardimg" + nextPhotoId + "'>");
	                    //var newPreview = $("<img class='imagePreview' id='imagePreview" + nextPhotoId + "' src='' alt='미리보기 이미지'>");
	                    $("#photoInputs").append(newInput);
	                    //$("#imagePreviews").append(newPreview);
							
	                       newInput.change(function () {
	                        resizeImage(this, 200, 200, function (resizedDataUrl) {
	                            var previewId = this.id.replace("boardimg", "imagePreview");
	                            var preview = $("#" + previewId);
	                            preview.attr("src", resizedDataUrl);
	                        }.bind(this));
	                    });

	                    nextPhotoId++;
	                } else {
	                    alert("더 이상 사진을 추가할 수 없습니다.");
	                }
	            });
	            
	        });
	        
	        function resizeImage(input, maxWidth, maxHeight, callback) {
	            if (input.files && input.files[0]) {
	                var reader = new FileReader();

	                reader.onload = function (e) {
	                    var image = new Image();
	                    image.src = e.target.result;

	                    image.onload = function () {
	                        var width = image.width;
	                        var height = image.height;

	                        if (width > maxWidth || height > maxHeight) {
	                            var ratio = Math.min(maxWidth / width, maxHeight / height);
	                            width *= ratio;
	                            height *= ratio;
	                        }

	                        var canvas = document.createElement("canvas");
	                        canvas.width = width;
	                        canvas.height = height;
	                        var ctx = canvas.getContext("2d");
	                        ctx.drawImage(image, 0, 0, width, height);

	                        var resizedDataUrl = canvas.toDataURL("image/jpeg");
	                        callback(resizedDataUrl);
	                    };
	                };

	                reader.readAsDataURL(input.files[0]);
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
        
            <div class="container px-4 px-lg-5 mt-5" style="z-index: 10">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    
                 <div>글수정페이지</div>
                    
                   <div>
						<form action="./boardEdit" method="post" id="form">
							<div class="titleBox">
								<input type="text" class="" id="btitle" name="btitle" value="${bdetail.btitle }">
							</div>
							<div class="contentBox">
								<textarea class="contentBox" name="bcontent">${bdetail.bcontent }</textarea>
								<input type="hidden" name="bno" value="${bdetail.bno}">
								<input type="hidden" name="cate" value="${param.cate}">
							</div>
							
							<div class="bimageBox">
								<span>이미지 갯수 : ${bdetail.bimagecount}</span>
								<c:if test="${imageList ne null && bdetail.bimagecount ne 0}">
									<c:forEach items="${imageList}" var="imageList">
										<div class="boardImgBox"><img class="boardImg" src="/boardImgUpload/${imageList.bimage}">
										${imageList.bimage}<button class="imgEditbtn" type="button"></button></div>
									</c:forEach>
								</c:if>
							</div>
						
						<div class="buttonBox">
							<button type="" class="editbtn">수정하기</button>
						</div>
						</form>
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
