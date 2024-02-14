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
<title>1:1 문의사항 등록 - 우리만</title>
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
	
	
	.table-bordered
	{
		width: 70%;
	}
	
	.form-control, .form-select
	{
		padding: 10px;
	}
	
	hr
	{
		margin-left: auto;
		margin-right: auto;
		width: 70%;
		height: 30%;
	}
	
	textarea
	{
		resize: none;
	}
	
	.aaa
	{
		margin-left: 15%;
		text-align: left;
	}
	
	.btn
	{
		font-size: 15pt;
		padding: 10px;
		width: 100pt;
	}

	.btnSubmit
	{
		background-color:  #ff8000;
		color: white;
	}
	
	.btnSubmit:hover
	{
		background-color: #e97501;
		color: white;
	}
	

	
	.bbb
	{
		background-color: #f3f3f1;
		border: solid 1px #f3f3f1;
		border-radius: 10px;
		width: 70%;
		padding: 20px;
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
	<h3 class="aaa">1:1 문의 접수</h3>
	<hr />
	<form action="">
		<table class="aaa table table-bordered" >
			<tr>
				<th>문의 유형 * </th>
				<td>
					<select class="form-select" name="" id="">
						<option value="">문의 유형을 선택해주세요.</option>
						<option value="">회원</option>
						<option value="">친구</option>
						<option value="">그룹</option>
						<option value="">신고</option>
						<option value="">포인트</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>문의 제목 *</th>
				<td>
					<input class="form-control" type="text" placeholder="제목을 작성해주세요" />
				</td>
			</tr>
			<tr>
				<th>문의 내용 *</th>
				<td>
					<textarea class="form-control" rows="10" cols="100" placeholder="문의 내용을 작성해주세요"></textarea>
				</td>
			</tr>
			<tr>
				<th>사진 접수 </th>
				<td>
					<input class="form-control" type="file" />
				</td>
			</tr>
		</table>
		<hr>
		<div>
		<span>문의에 대한 답변 등록시 연락을 드립니다.</span><br>
		<table class="aaa table table-bordered">
			<tr>
				<th rowspan="2">연락 수단</th>
				<td colspan="2">
				<input type="radio" name="phone" id="cellphone" /> <label for="cellphone">휴대번호</label>
				<input type="radio" name="phone" id="telephone"/> <label for="telephone">전화번호</label>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="" id="" class="form-control" placeholder="번호를 입력해주세요" />
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="" id="" class="form-control" placeholder="이메일을 입력해주세요" />
				</td>
			</tr>	
			</table>
		</div>
		<hr><br>
		
		<div class="">
		<button type="button" class="btn btnSubmit">접수하기</button>
		<button type="button" class="btn btn-secondary">취소하기</button>
		</div>
	</form>
</div>

<br><br>

<div class="aaa bbb">
문의내용 답변 안내<br><br>
답변은 마이룸 또는 회원정보에 등록된 이메일로 확인 가능합니다. (문의내용에 따라 고객센터 또는 매장에서 연락드릴 수 있습니다.)<br>
당일 17시 이후 문의건과 공휴일 1:1 문의는 문의 유형과 이름/연락처/이메일 주소를 남겨 주시면 확인 후 운영시간에 통지해 드립니다.<br>
정상근무일 기준이며, 통지예정일이 휴일인 경우 다음 정상 근무일에 진행 됩니다.<br>
설/추석 연휴 기간 동안은 고객센터 휴무로 인해 1:1 문의 답변이 불가 합니다.<br>
설/추석 연후 끝난 이후부터 순차적으로 답변드릴 예정이니 양해 부탁드립니다.<br>
신학기(3월, 9월)에는 문의량이 급증하여 답변이 지연될 수 있습니다.<br>

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