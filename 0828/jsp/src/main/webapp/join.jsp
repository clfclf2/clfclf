<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
Date now = new Date();
SimpleDateFormat s = new SimpleDateFormat("yyyy");
int year = Integer.parseInt(s.format(now));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form name="join_form" method="post" action="join_proc2.jsp">
		아이디 <input type="text" name="userid"><br> 비밀번호 <input
			type="password" name="userpwd"><br> 비밀번호 확인 <input
			type="password" name="userpwd2"><br> 이름 <input
			type="text" name="username"><br> 성별 <input type="radio"
			name="gender" value="남자">남자 <input type="radio" name="gender"
			value="여자">여자<br> 생일 <select name="y">
			<%
			for (int i = 1950; i < year + 1; i++) {
			%>
			<option><%=i%></option>
			<%
			}
			%>

		</select>년 <select name="m">
			<%
			for (int i = 1; i < 13; i++) {
				if (i < 10) {
			%>
			<option>0<%=i%></option>
			<%
			} else {
			%>
			<option><%=i%></option>
			<%
			}
			%>
			<%
			}
			%>

		</select>월 <select name="d">
			<%
			for (int i = 1; i < 32; i++) {
				if (i < 10) {
			%>
			<option>0<%=i%></option>
			<%
			} else {
			%>
			<option><%=i%></option>
			<%
			}
			%>
			<%
			}
			%>
		</select>일 <br> 취미 <input type="checkbox" name="hobby" value="축구">
		축구 <input type="checkbox" name="hobby" value="게임"> 게임 <input
			type="checkbox" name="hobby" value="영화"> 영화 <br>
		<button type="submit">가입</button>
		<button type="reset">취소</button>
		<a href="list.jsp"><button type="button">리스트</button></a>
	</form>
</body>
</html>