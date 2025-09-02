<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="lib.DB" %>

<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String birth = request.getParameter("birth");
	String[] hobbyArr = request.getParameterValues("hobby");
	String hobby = "";
	if(hobbyArr != null){
		for(int i=0; i<hobbyArr.length; i++){
			hobby += hobbyArr[i];
			if(i < hobbyArr.length-1) hobby += ",";
		}
	}

	Connection conn = null;
	Statement st = null;

	try {
		conn = DB.getConnection();
		st = conn.createStatement();

		String sql = "INSERT INTO member(id,password,name,gender,birth,hobby) "
				   + "VALUES('" + id + "','" + password + "','" + name + "','" 
				   + gender + "','" + birth + "','" + hobby + "')";

		int result = st.executeUpdate(sql);
		
		if(result > 0){
			out.println("<h3>회원가입 성공!</h3>");
			out.println("<a href='memberForm.jsp'>다시 가입하기</a>");
		}else{
			out.println("<h3>회원가입 실패</h3>");
		}
		
	} catch(Exception e){
		e.printStackTrace();
		out.println("<h3>에러 발생: "+ e.getMessage() +"</h3>");
	} finally {
		if(st != null) try{ st.close(); }catch(Exception e){}
		if(conn != null) try{ conn.close(); }catch(Exception e){}
	}
%>
