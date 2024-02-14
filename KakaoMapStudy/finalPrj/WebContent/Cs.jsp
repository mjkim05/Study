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
<title>고객센터 - 우리만</title>
<link rel="stylesheet" href="<%=cp%>/css/font.css">
<link rel="stylesheet" href="<%=cp%>/css/memberHeader.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">

	*
	{
		text-align: center; 
		font-family: 라인Seed;
		font-weight: bold;
	}
	
	input
	{
		width: 50%;
		height: 40pt;
		border-radius: 15px;
		border: solid 2px #ff8a3d;
		font-size: 15pt;
	}
	
	.search
	{
		position: relative;
	}
	
	.search button
	{
		position: absolute;
   		color: #ff8a3d;
    	left: 72%;
    	top: 9px;
   		background: none;
   		border: none;
	}
	
	
	.bi-search
	{
		font-size: 20pt;
	}
	
	hr
	{
		margin-left: auto;
		margin-right: auto;
		width: 70%;
		height: 30%;
	}
	
	
	h3
	{
		margin-left: 15%;
		text-align: left;
	}
	

	.simple
	{
		height: 35pt;
		text-align: left;
		padding: 10px;
		margin-left: 27%;
		
	}
	
	#qna h3
	{
		height: 35pt;
		text-align: left;
		margin-left: 28%;
	}
	
	.g-col-2
	{
		font-size: 15pt;
	}

	.inquiry 
	{
		border: solid 1px #F2F2F2;
		border-radius: 5px;
		padding: 20px;
		margin-left: 18%;
		background-color: #F2F2F2;
		
	}

	.inquiry a
	{
		font-size: 15pt;
		text-decoration: none;
		color: gray;
		
	}
	
	.inquiry i
	{
		font-size: 25pt;
		padding: 20px;
		text-align: center;
		color: gray;
	}
	
	.notices, .qnaList
	{
		padding: 15px;
		height: 35pt;
		text-align: left;
		margin-left: 15%;
		width: 70%;
	}
	
	.more
	{
		color: black;
		text-decoration: none;
		text-align: right;
		margin-right: 16%;
	}
	
	/* footer CSS */

	.footer
	{
		width:100%;
		text-align: center;
		
	}
	
	.footer a
	{
		padding: 20px;
		margin: 10px;
	}
	
	
</style>

</head>
<body>

<!-- 임시 헤더 영역 -->
<div>
	<br>
	<c:import url="MemberHeader.jsp"></c:import>
	<hr />
</div>

<div>
<br><br>
	<h2>
	<span style="color: #ff8a3d;">우리만</span> 고객센터입니다.<br>
	무엇을 도와드릴까요?
	</h2>
	<br>
</div>
<div class="search">
	<input type="search" placeholder="궁금하신 내용을 검색해주세요." />
	<button type="button"><i class="bi bi-search"></i></button>
	<br><br><br>
</div>

<h3>자주 묻는 질문</h3>
<hr />
<div class="grid text-center" >
		<div class="g-col-2 g-start-3" style="color: #ff8a3d;">회원</div>
		<div class="g-col-2">친구</div>
		<div class="g-col-2">그룹</div>
		<div class="g-col-2">모임</div>
		<div class="g-w-100"></div>
		<div class="g-col-2 g-start-3">경고</div>
		<div class="g-col-2">신고</div>
		<div class="g-col-2">포인트</div>
		<div class="g-col-2">기타</div>
</div>
<hr />

<ul class="list-group">
  <a href="Faq.jsp" class="more">더보기 > </a>
  <li class="list-group-item qnaList"> Q. 회원 탈퇴 후 재가입이 바로 가능한가요?</li>
  <li class="list-group-item qnaList"> Q. 회원 정보를 수정하고 싶어요</li>
  <li class="list-group-item qnaList"> Q. 아이디를 여러개 사용할 수 있나요? </li>
  <li class="list-group-item qnaList"> Q. 로그인에 문제가 있어요</li>
</ul>


<br><br>
<br><br>

<div class="grid text-center">
    <div class="g-col-3 g-start-2">
		<div id="qna">
			<h3>간단하게 해결하기</h3>
			<ul class="list-group">
		 		<li class="list-group-item simple">이용 가이드</li>
		  		<li class="list-group-item simple">아이디 / 비밀번호 찾기</li>
		 		<li class="list-group-item simple">내 회원정보 수정</li>
			</ul>
		</div>
    </div>
    <div class="g-col-3">
    	<div>
		<h3> 1:1 문의 </h3>
			<div class="row row-col-2 input-group">
				<div class="col inquiry input-group-addon">
					<a href="QnaInsertForm.jsp">
						<i class="bi bi-chat-left-text"></i>
						<p>1:1 문의 접수</p>
					</a>
				</div>
				<div class="col inquiry input-group-addon">
					<a href="QnaList.jsp"> 
						<i class="bi bi-file-earmark-text"></i>
						<p>1:1 문의 내역</p>
					</a>
				</div>
			</div> <!-- end row row-col-2 -->
		</div>
  </div>
    <div class="g-col-3">
    	<div>
		<h3> 신고 </h3>
			<div class="row row-col-2 input-group">
				<div class="col inquiry input-group-addon">
					<a href="">
						<i class="bi bi-megaphone"></i>
						<p>신고 접수</p>
					</a>
				</div>
				<div class="col inquiry input-group-addon">
					<a href=""> 
						<i class="bi bi-file-earmark-text"></i>
						<p>신고 내역</p>
					</a>
				</div>
			</div> <!-- end row row-col-2 -->
		</div>
  </div>
  
  
  
</div>

<br><br>
<br><br>


<div>
	<h3>공지사항</h3>
	<hr>
	<ol class="list-group list-group-numbered">
	<a class="more">더보기 > </a>
  	<li class="list-group-item notices">개인정보 관련 정책</li>
  	<li class="list-group-item notices">플랫폼 규칙</li>
  	<li class="list-group-item notices">그 외 공지 등등</li>
	</ol>
</div>

<br><br><br>

<!-- footer 영역 추후 임포트 -->
<div class="footer col-xs-12 col-sm-12 col-md-12">
	<footer>
		<br> 
		<a>이용약관</a> <a>개인정보처리방침</a> <a>우리만 정책</a> <a>고객센터</a> <a> ⓒ 우리만</a>
	</footer>
</div>
<br>

</body>
</html>