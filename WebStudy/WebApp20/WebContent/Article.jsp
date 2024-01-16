<%@page import="com.test.BoardDTO"%>
<%@page import="com.test.BoardDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%


	String error = (String)session.getAttribute("error");

	Connection conn = DBConn.getConnection();
	BoardDAO dao = new BoardDAO(conn);
	
	// 이전 페이지(List.jsp)로부터 넘어온 데이터 수신
	// num, pageNum
	
	String pageNum = request.getParameter("pageNum");
	String strNum = request.getParameter("num");
	int num = Integer.parseInt(strNum);
	
	// 해당 게시물의 조회수 증가
	dao.updateHitCount(num);
	
	// 이전, 다음 게시물 번호 확인
	int beforNum = dao.getBeforeNum(num);			//  ??  103
	int nextNum = dao.getNextNum(num);				//  	103   ??
	
	BoardDTO dtoBefore = null;
	BoardDTO dtoNext = null;
	
	if (beforNum != -1)
		dtoBefore = dao.getReadDate(beforNum);
	
	if (nextNum != -1)
		dtoNext	= dao.getReadDate(nextNum);
	
	// 해당 게시물의 상세 내용 가져오기
	BoardDTO dto = dao.getReadDate(num);
	
	// 게시물 본문 라인 수 확인 
	int lineSu = dto.getContent().split("\n").length;
	
	// 게시물 내용
	dto.setContent(dto.getContent().replaceAll("\n", "<br>"));
	//-- 즉
	//   안녕하세요\n반갑습니다\n화요일입니다\n기운냅시다\n안녕히가세요
	//   → 안녕하세요<br>반갑습니다<br>화요일입니다<br>기운냅시다<br>안녕히가세요
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Article.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/article.css">
<script type="text/javascript">

	function sendIt()
	{
		f = document.myForm;
		<%-- String error = '';
		error = <%=error%>; --%>
		//var pwdSource = prompt("비밀번호를 입력하세요");
		//alert (pwd);
		
		document.getElementById("pwdSource").value=prompt("비밀번호를 입력하세요");
		
	/* 	if (error=='-1')
		{	
			alert ("비밀번호가 일치하지 않습니다. \n 다시 입력해주세요!");
			return;
		} */
		
		f.submit();
		
		
	}

</script>
</head>
<body>

<div id= "bbs">
	
	<div id="bbs_title">
		게 시 판 (JDBC 연동 버전)
	</div> <!-- bbs_title -->
	
	<div id="bbsArticle">
		
		<div id="bbsArticle_header">
			<%=dto.getSubject() %>
		</div> <!-- bbsArticle_header" -->

		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>작성자</dt>
				<!-- <dt>정현욱</dt> -->
				<dd><%=dto.getName() %></dd>
				
				<dt>라인수</dt>
				<!-- <dd>23</dd> -->
				<dd><%=lineSu %></dd>
			</dl>
		</div> <!-- bbsArticle_bottomLine -->
		
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>등록일</dt>
				<!-- <dd>2023-12-19</dd> -->
				<dd><%=dto.getCreated() %></dd>
				
				<dt>조회수</dt>
				<!-- <dd>13</dd> -->
				<dd><%=dto.getHitCount() %></dd>
			</dl>
		</div> <!-- "bbsArticle_bottomLine" -->
		
		<div id="bbsArticle_content">
			<table style="width: 600px;">
				<tr>
					<td style="padding: 10px 40px 10px 10px; vertical-align: top; height: 150px;">
						<!-- 어쩌구 저쩌구 내용 -->
						<%=dto.getContent() %>
					</td>
				</tr>
			</table>
		</div> <!-- "bbsArticle_content" -->
		
		<div class="bbsArticle_bottomLine">
			<!-- 이전 글 : (104) 취미 관련 게시물 -->
			<%
			if(beforNum != -1)
			{
			%>
				<!-- 이전글 있음 -->
				<a href= "<%=cp%>/Article.jsp?pageNum=<%=pageNum %>&num=<%=beforNum%>">
				이전 글 : (<%=beforNum %>) <%=dtoBefore.getSubject()%>
				</a>
			<%
			}
			else
			{
			%>
				이전글 : 없음
			<%
			}
			%>
		</div><!-- "bbsArticle_bottomLine" -->
		
		<div class="bbsArticle_bottomLine">
			<!-- 다음 글 : (102) 날씨 관련 게시물 -->
			<%
			if  (nextNum != -1)
			{
			%>
				<a href= "<%=cp%>/Article.jsp?pageNum=<%=pageNum %>&num=<%=nextNum%>">
				다음 글 : (<%=nextNum %>) <%=dtoNext.getSubject() %>
				</a>
			<%
			}
			else
			{
			%>
				다음 글 : 없음
			<%
			}
			%>

		</div><!-- "bbsArticle_bottomLine" -->
	
	</div><!-- bbsArticle -->

	<div class="bbsArticle_noLine" style="text-align: right;"> 
		<!-- From : 211.238.142.151 -->
		From : <%=dto.getIpAddr() %>
	</div> <!-- "bbsArticle_noLine" -->
	
	<div id="bbsArticle_footer">
		<div id="leftFooter">
			<input type="button" value="수정" class="btn2" 
			onclick="javascript:location.href='<%=cp%>/updated.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>&status=1'"/>
			<input type="button" value="삭제" class="btn2" 
			onclick="javascript:location.href='<%=cp%>/updated.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>&status=2'"/>
			
			
	<%-- 	<form action="<%=cp%>/Delete_ok.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>&pwd=<%=dto.getPwd() %>"
		method="post" name="myForm" style="display: inline;">	
			<input type="button" value="삭제" class="btn2" 
			onclick="sendIt()"/>
			<input type="hidden" name="pwdSource" id="pwdSource">
		</form>	 --%>
		
		</div> <!-- "leftFooter" -->
		
		<div id="rightFooter">
			<input type="button"  value="리스트" class="btn2"
			onclick="javascript:location.href='<%=cp%>/List.jsp?pageNum=<%=pageNum%>'"/>
		</div> <!-- "rightFooter" -->
		
	</div> <!-- bbsArticle_footer -->
	
</div><!-- bbs -->

</body>
</html>















