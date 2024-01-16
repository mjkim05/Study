<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript">

/* 	function actionC()
	{
		//alert("함호");
		var f = document.forms[0];
		f.submit();
	} */
	
	function sendIt()
	{
		//alert("함수호출 확인");
		
		var f = document.myForm;
		
		// 체크 및 검증할 내용의 코드 작성 가능...
		
		f.submit();
		
	}

</script>

</head>
<body>

<div>
	<h1>간단한 기본 방명록 작성 실습</h1>
	<hr>
</div>

<div>
	<form action="Guest_ok.jsp" method="post" name="myForm">
		<table class="table">
			<tr>
				<th>이름</th>
				<td>
					<!-- <input type="text" name = "name" class="txt"/> -->
					<input type="text" name = "userName" class="txt"/>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<!-- <input type="text" name = "title" class="txt"/> -->
					<input type="text" name = "subject" class="txt"/>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<!-- <textarea rows="5" cols="30" name ="content"></textarea> -->
					<textarea rows="5" cols="30" name ="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- <button type="submit" class="btn" style="width: 100%">방명록 작성</button> -->
					<!-- <button type="button" class="btn" style="width: 100%;" onclick="actionC()">방명록 작성</button> -->
					<button type="button" class="btn" style="width: 100%;" onclick="sendIt()">방명록 작성</button>
				</td>
			</tr>
		</table>
	</form>
</div>


</body>
</html>