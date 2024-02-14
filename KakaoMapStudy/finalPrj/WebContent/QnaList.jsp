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
<title>1:1 문의사항 내역 - 우리만</title>
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
		font-family: 라인Seed;
		font-weight: bold;
		text-align: center;
	}
	
	.aaa
	{
		margin-left: 15%;
		text-align: left;
	}
	
	hr 
	{
		margin-left: auto;
		margin-right: auto;
		width: 70%;
		height: 30%;
	}
	
	.date
	{
		margin-left: 15%;
		text-align: left;
		width: 70%;
		background-color: #f3f3f1;
		border: solid 1px #f3f3f1;
		border-radius: 10px;
		padding: 15px;
		font-size: 15pt;
	}
	
	input
	{
		padding: 6px;
		border: solid 1px;
		border-radius: 5px;
	}
	
	 select
	 {
	 	padding: 10px;
	 	border: solid 1px;
		border-radius: 5px;
	 }
	 
	
	.btn
	{
		font-size: 13pt;
		padding: 10px;
		width: 100pt;
	}

	.btnSelect
	{
		background-color:  #ff8000;
		color: white;
	}
	
	.btnSelect:hover
	{
		background-color: #e97501;
		color: white;
	}
	
	.nav-tabs
	{
		padding: 5px;
	}
	
	.table
	{
		margin-left: auto;
		margin-right: auto;
		width: 70%;
		
	}
	
	li.nav-item 
	{
    	margin-right: 0;
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
		width: 30pt;
	}
	
	
</style>

</head>
<body>

<!-- 임시 헤더 영역 -->
<div>
	<br>
	<c:import url="MemberHeader.jsp"></c:import>
	<hr />
	<br>
</div>

<div>
	<h3 class="aaa">1:1 문의 내역</h3>
	<hr />
	<div class="date">
		<select name="" id="">
			<option value="">3개월</option>
			<option value="">6개월</option>
			<option value="">1년</option>
			<option value="">2년</option>
			<option value="">직접설정</option>
		</select>
		<input type="date" /> ~ <input type="date" />
		<button class="btn btnSelect">조회</button>
		<button class="btn btnInsert" onclick="location.href='QnaInsertForm.jsp'">1:1문의 작성</button>
	</div>
	<br>
	<div class="aaa">
		<ul class="nav nav-tabs">
			<li class="nav-item">
				<a href="" class="nav-link active" aria-current="page">전체</a>
			</li>
			<li class="nav-item">
				<a href="" class="nav-link active" aria-current="page">대기중</a>
			</li>
			<li class="nav-item">
				<a href="" class="nav-link active" aria-current="page">처리중</a>
			</li>
			<li class="nav-item">
				<a href="" class="nav-link active" aria-current="page">처리완료</a>
			</li>
		</ul>	
	</div>
	<br />
	<table class="table">
		<tr>
		<thead>
			<th>번호</th>
			<th>문의유형</th>
			<th>제목</th>
			<th>문의날짜</th>
			<th>상태</th>
		</thead>
		</tr>
		<tbody class="table-group-divider">
		<tr>
			<td>1</td>
			<td>친구</td>
			<td>친구 추가가 안됩니다.</td>
			<td>2024-02-13</td>
			<td>대기중</td>
		</tr>
		<tr>
			<td>2</td>
			<td>포인트</td>
			<td>제 포인트 돌려주세요</td>
			<td>2024-02-10</td>
			<td>처리중</td>
		</tr>
		<tr>
			<td>3</td>
			<td>신고</td>
			<td>신고 포상같은거 없나요?</td>
			<td>2024-01-10</td>
			<td>처리완료</td>
		</tr>
		</tbody>	
	</table>
</div>



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