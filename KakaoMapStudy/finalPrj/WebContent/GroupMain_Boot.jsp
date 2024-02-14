<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GroupMain</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/groupMain_Boot.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<!-- 캐러샐 추가 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">

</head>

</head>
<body>
	<c:import url="GroupMenu_Boot.jsp"></c:import>

	<div class="main">
		<!-- 사이즈 커질 때 양쪽 공백 -->
		<div class="col-md-1"></div>
		
		<!-- 왼쪽 구성 -->
		<div class="left col-xs-12 col-sm-4 col-md-2">
		
			<!-- 그룹 프로필 + 그룹원 목록 -->
			<div id="groupProfile">
				<img alt="깜찍한 고양이 사진" src="img/cute_cat.jpg"><br> 
				<span>고양이 좋아</span><br>
				 멤버: 100명<br>
				 고양이를 사랑하는 그룹 😺
			</div>
			<br>
			
			<div id="groupMember">
				<span>그룹원 목록</span>
				<ul>
					<li>으나👑</li>
					<li>밍</li>
					<li>낑</li>
					<li>욱</li>
					<li>깡</li>
					<li>고양이</li>
					<li>나비</li>
					<li>:</li>
				</ul>
			</div> 
		</div> <!-- end left -->
		
		<!-- 중간 영역 -->		
		<div class="center col-xs-12 col-sm-4 col-md-6">
		
		<!-- 캐러셀 (슬라이드 구성)  -->		
		<div id="slideWrap" class="carousel slide" data-ride="carousel">			
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="img/gray_back.png" alt="" width="1100" height="250">
						 <div class="carousel-caption">
						 <br>
                		 <h3>오랜만에 등산</h3>
           				 <p>모임 날짜 : 2024. 02. 07</p>
           				 <p>모임 지역 : 서울시 중랑구</p>
           				 <p>참석 여부 확인 기간 : 2024.01.20 ~ 2024.02.02 </p>
           				 <button class="button">참석 여부 선택하러 가기</button>
             		   </div>
					</div>
					<div class="carousel-item">
						<img src="img/gray_back.png" alt="" width="1100" height="250">
						 <div class="carousel-caption">
						 <br>
                		 <h3>맛집 투어 어때용>.O </h3>
           				 <p>모임 날짜 : 2024. 02. 14</p>
           				 <p>모임 지역 : 경기도 하남시</p>
           				 <p>참석 여부 확인 기간 : 2024.01.31 ~ 2024.02.09</p>
           				 <button class="button">참석 여부 선택하러 가기</button>
             		   </div>
					</div>
					<div class="carousel-item">
						<img src="img/gray_back.png" alt="" width="1100" height="250">
						 <div class="carousel-caption">
						 <br>
                		 <h3>클라이밍 해요</h3>
           				 <p>모임 날짜 : 2024. 02. 27</p>
           				 <p>모임 지역 : 서울시 마포구</p>
           				 <p>참석 여부 확인 기간 : 2024.01.15 ~ 2024.02.22 </p>
           				 <button class="button">참석 여부 선택하러 가기</button>
             		   </div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#slideWrap" data-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</a> 
				<a class="carousel-control-next" href="#slideWrap" data-slide="next">
				 <span class="carousel-control-next-icon"></span>
				</a>
			</div> <!-- end carousel slide -->
			<!-- 캐러셀 끝 -->
			
			
			<!-- 최신글 시작 -->
			<ul class="list-group list-group-flush">
			<div>
			<div class="newpost_Left">
				<h3>자유 게시판 최신글</h3>
  				<li class="list-group-item">일단 최대한 레이아웃</li>
  				<li class="list-group-item">위주로 정리 했습니다.</li>
 				<li class="list-group-item">예쁘게는 여러분이...</li>
  				<li class="list-group-item">잘 해주실거라고 생각해요</li>
  				<li class="list-group-item">중요할 때 빠져서 죄송합니다.</li>
  				<li class="list-group-item">다들 아자아자 화이팅!</li>
  				<li class="list-group-item">다 끝내고 보니까 더 허접... 미안해용...</li>
  			</div>
  			<div class="newpost_Right">	
  				<h3>히스토리 최신글</h3>
  				<li class="list-group-item">목요일 회식 후기</li>
  				<li class="list-group-item">못가게 됐다..ㅠㅠ</li>
 				<li class="list-group-item">다들 재밌게 잘 놀고와...</li>
  				<li class="list-group-item">너무 재밌게는 놀지말고</li>
  				<li class="list-group-item">담에 나 있을때 또해!!</li>
  				<li class="list-group-item">안하면 나 운다ㅠ</li>
  			</div>	
			</ul>	
			<!-- 최신글 끝 -->
			</div> <!-- end center -->
			
		<!-- 마지막(오른쪽) 영역 -->	
		<div class="right col-xs-12 col-sm-4 col-md-2">
		
		<!-- 내프로필 + 캘린더 -->
		<div id="groupMyProfile">
				<img alt="깜찍한 고양이 사진" src="img/cat2.jpg"><br> 
				<p><span>밍</span> 포인트 : 2024pt</p>
				<button class="button">정보 수정</button>
				<br><br>
				<c:import url="Calender.jsp"></c:import>
				<!-- 캘린더는 구현할려고 보니까 생각보다 스크립트 처리나 할게 많더라구요. 일단 지금 단계에서 할건 아닌가 싶어서 
				     임시로 예전 수업한 캘린더 넣어놨습니다 (--)(__) 
				     레이아웃만 봐주세용! -->
		</div>
		<br>
		
		
		
		</div> <!-- end right -->
		
		<!-- 사이즈 커질 때 양쪽 공백 -->
		<div class="col-md-1"></div>
		
		</div> <!-- end main -->

	<div class="footer col-xs-12 col-sm-12 col-md-12">
		<footer>
			<br> <a>이용약관</a> <a>개인정보처리방침</a> <a>약속해조 정책</a> <a>고객센터</a> <a>ⓒ
				약속해조</a>
		</footer>
	</div>

</body>
</html>