<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="lib.DB"%>
<%@ page import="java.lang.Math"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String sql = "";

	Connection conn = null;
	ResultSet rs = null;
	Statement st = null;

	int total = 0; //전체 게시물 숫자
	int scale = 4; //한페이지 게시물 숫자
	int total_page = 0; //전체 페이지 숫자
	int offset = 0; //디비 오프셋
	String _page = request.getParameter("_page");
	if (_page == null)
		_page = "1";
	int now_page = Integer.parseInt(_page); //현재 페이지

	int page_scale = 5;
	int page_group = 0;

	offset = (now_page - 1) * scale;

	//out.print(offset);

	try {

		conn = DB.getConnection();

		sql = "select count(*) as cnt from member ";
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		rs.next();

		total = rs.getInt("cnt");

		total_page = (int) Math.ceil((double) total / scale);

		page_group = (int) Math.ceil((double) total_page / page_scale);

		out.println(page_group);
		//쿼리문 작성
		sql = "select *from member order by idx asc limit 10";

		//Connection객체로부터 Statement객체를 얻어내는 코드
		st = conn.createStatement();
		// st.executeUpdate();
		rs = st.executeQuery(sql);
		//쿼리문을 DB에 실행하는 코드
	%>

	<table border="1">
		<tr>
			<td>idx</td>
			<td>id</td>
			<td>password</td>
			<td>name</td>
			<td>gender</td>
			<td>birth</td>
			<td>hobby</td>
		</tr>

		<%
		while (rs.next()) {
			String idx = rs.getString("idx");
			String id = rs.getString("id");
			String password = rs.getString("password");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			String birth = rs.getString("birth");
			String hobby = rs.getString("hobby");
		%>
		<tr>
			<td><a href="view.jsp?idx=<%=idx%>"><%=idx%></a></td>
			<td><%=id%></td>
			<td><%=password%></td>
			<td><%=name%></td>
			<td><%=gender%></td>
			<td><%=birth%></td>
			<td><%=hobby%></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<%
	
	for (int i = 1; i <= total_page; i++) {
	%>
	<a href="list.jsp?_page=<%=i%>"><%=i%></a> |
	<%

	%>
	<%
	}

	// out.println("등록성공");

	} catch (Exception e) {
	e.printStackTrace();
	out.println(sql);
	} finally {
	if (rs != null) {
	rs.close();
	}
	if (rs != null) {
	rs.close();
	}
	if (conn != null) {
	conn.close();
	}
	}
	%>

	<a href="join.jsp"><button type="button">회원가입</button></a>



</body>
</html>