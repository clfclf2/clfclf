<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="lib.DB" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
  Connection conn=null;

  try{
	conn = DB.getConnection();
	 out.println("연결 성공");
  }catch(Exception e){ 
	 e.printStackTrace();
  }
%>


<title>Insert title here</title>
</head>
<body>



</body>
</html>