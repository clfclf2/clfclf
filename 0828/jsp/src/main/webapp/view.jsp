<%@page import="java.awt.PageAttributes.OrientationRequestedType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>    
<%@ page import="lib.DB" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>출력 뷰</h2>
<%

String idx = request.getParameter("idx");


   Connection conn=null;
   Statement st = null;
   ResultSet rs = null;
    
   String sql = null;

  try{
	conn = DB.getConnection();
    //out.println("연결 성공");
    
   //쿼리문 작성
   sql = " select * from member where idx = '"+idx+"' ";
   
   //Connection객체로부터 Statement객체를 얻어내는 코드
   st = conn.createStatement();
   
   rs = st.executeQuery(sql);
  }
   catch(Exception e){ 
     e.printStackTrace();
     out.println(sql);
   }
%>
   <% 
   if(rs != null){
      rs.next();
      
      idx= rs.getString("idx");
      String id= rs.getString("id");
      String password = rs.getString("password");
      String name = rs.getString("name");
      String gender = rs.getString("gender");
      String birth = rs.getString("birth");
      String hobby = rs.getString("hobby");
    
   %>
   
   기본키: <%=idx %><br>
   아이디: <%=id %><br>
   패스워드: <%=password %><br>
   이름: <%=name %><br>
   성별: <%=gender %><br>
   생일: <%=birth %><br>
   취미: <%=hobby %><br>
   
   
   <%
   }
   %>
  

<br>
<a href="modify.jsp?idx=<%=idx%>"><button type="button">수정</button></a>
<a href="delete.jsp?idx=<%=idx%>"><button type="button">삭제</button></a>
<a href="list.jsp"><button type="button">리스트</button></a>



</body>
</html>
