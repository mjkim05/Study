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
<title>AjaxTest05.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style type="text/css">
	#search
	{
		width: 500px;
	}
	#list
	{
		border: 1px solid gray;
		width: 500px;
		
		position: absolute;
		left: 70px;
		top:138px;
		font-weight: bold;
		color: #343;
		
		display: none;
	}
	#list .item
	{
		padding: 2px;
	}
	#list #footer
	{
		height: 14px;
		background-color: #DDD;
		text-align: right;
		padding: 5px;
		font-size: small;
	}
	
</style>
<script type="text/javascript" src="<%=cp%>/js/ajax.js"></script>
<script type="text/javascript">

	// 검색팡에서 키보드 입력이 발생할 때 마다
	// 그 때까지의 입력된 단어를 서버로 전송하고 
	// 전송된 단어에 맞는 추천 검색어를 받아올 수 있도록 처리
	function search()
	{
		// 확인 
		//alert("함수 호출");
		
		// 데이터 수집(입력된 값 얻어오기)
		var search = document.getElementById("search").value;
		
		// 테스트
		//alert(search);

		// 서버로 전송하기 전에 유효성 검사 ----------------------------------------
		
		// ① 검색어가 존재할 경우에만 서버로 전송할 수 있도록 처리
		if (search.replace(" ","")=="")
		{
			document.getElementById("list").style.display = "none";
			return;
		}
		
		// ② 입력된 검색어가 완성형 한글일 경우에만 
		//	  검색 키워드를 전송할 수 있도록 처리
		//    정규표현식 사용
		var regEx = /^[가-힣]{1,}$/;
		
		if (!regEx.test(search))
		{	
			return;	
		}
		// ---------------------------------------- 서버로 전송하기 전에 유효성 검사 
		
		// URL 구성
		var url = "test05.do?search="+search;
		
		//XMLHttpRequest 객체(AJAX) 생성
		
		ajax = createAjax();
		
		ajax.open("GET",url,true);
		
		ajax.onreadystatechange = function()
		{
			if(ajax.readyState==4 && ajax.status==200)
			{
				callBack();
			}
		};
		
		ajax.send("");
	}
	
	// 추출된 업무 수행 내용
	// -- XML 목록으로 받아온 검색어들을
	//  적절한 리스트로 생성해서 화면에 출력 할 수 있도록 처리
	function callBack()
	{
		// XML 문서 생성
		var doc = ajax.responseXML;
		
		// XML 문서의 최상위 엘리먼트(루트 엘리먼트)
		//-- 현재는... 『<list></list>』 엘리먼트
		var root = doc.documentElement;
		
		// 루트 엘리먼트 하위의 모든 <item></item> 엘리먼트 반환하기
		var itemList = root.getElementsByTagName("item");
		
		// 추천 검색어 출력(노출 지점)초기화
		document.getElementById("items").innerHTML = "";
		
		// 수신한 데이터(추천 검색어 삽입)
		for (var i=0; i<itemList.length; i++)
		{
			// ※ 태그가 가지는 텍스트는
			//    태그의 첫 번째 자식이고..
			//    텍스트 노드의 값은 (텍스트...)
			//    nodeValue 로 가져온다.
			var word = itemList[i].firstChild.nodeValue;
			//var last = itemList[i].lastChild.nodeValue;
			
			// 출력 지점에 추가 → items
			document.getElementById("items").innerHTML 
			+= "<div class='item'>" + word +"</div>";
		}	
		
		// 최종적으로 목록을 화면에 보일 수 있도록 렌더링
		//document.getElementById("list").style.display = "block"; 
		document.getElementById("list").style.display = "inline-block"; 
		
		/* 		
		for (var i = 0; i < itemList.length; i++)
		{
			var item = itemList[i].getElemebtsByTagName("item")[i];
	
			var itemText = item.firstChild.nodeValue
	
			document.getElementById("items").innerHTML 
			+= "<div class='item'>"
						+ itemText + "</div>";
		}

		document.getElementById("items").style.display = "inline-block"; 
		*/
		
	}
</script>

</head>
<body>

<div>
	<h1>AJAX 실습 - 추천 검색어</h1>
	<hr />
</div>

<div>
	검색어
	<input type="text" class="control" id="search" 
	 placeholder="검색어를 입력하세요" onkeyup="search()">
</div>

<div id="list">
	<div id="items">
		<div class="item">가습기</div>
		<div class="item">가요대전</div>
		<div class="item">가방</div>
		<div class="item">가다랑어</div>
		<div class="item">가위</div>
		<div class="item">가죽</div>
		<div class="item">가족</div>
		<div class="item">가지</div>
		<div class="item">가평</div>
	</div>
	<div id="footer">
		추천 검색어
	</div>
</div>


</body>
</html>




















