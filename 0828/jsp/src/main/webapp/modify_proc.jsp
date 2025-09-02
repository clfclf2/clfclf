<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>  
<%@ page language="java" %>
<%@ page import="lib.DB" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력</title>
</head>
<body>
<h1> 회원 정보</h1>
<%

String idx = request.getParameter("idx");
String userid= request.getParameter("userid");
String userpwd= request.getParameter("password");
String userpwd2= request.getParameter("password2");
if(!userpwd.equals(userpwd2))
{
%>
<script>
alert("비밀번호가 일치하지 않습니다.");
location.replace("join.jsp");
</script>   
<%   
      return;
}
String name= request.getParameter("name");

String gender= request.getParameter("gender");
String y= request.getParameter("y");
String m= request.getParameter("m");
String d= request.getParameter("d");
String [] h =request.getParameterValues("hobby");
String ymd = y+"-"+m+"-"+d;
String hobby ="";
if(h !=null){
for(String str:h){
	hobby += str;
	}
}

%>

<% 
String sql = "";

  Connection conn=null;
  PreparedStatement psmt = null;
  try{
	  conn = DB.getConnection();
    //out.println("연결 성공");
    
   //쿼리문 작성
   //sql = "update member set id='"+id+"', name='"+n+"',gender='"+g+"',  birth='"+ymd+"', hobby='"+hobby+"' where idx = '"+idx+"' ";
   //Connection객체로부터 Statement객체를 얻어내는 코드
   sql = "update member set id =?, password =?, name =? , gender=? , hobby =?, birth =? where idx=?";
    
	psmt = conn.prepareStatement(sql);
   
   psmt.setString(1, userid);
   psmt.setString(2, userpwd);
   psmt.setString(3, name);
   psmt.setString(4, gender);
   psmt.setString(5, hobby);
   psmt.setString(6, ymd);
   psmt.setString(7, idx);
   
   //쿼리문을 DB에 실행하는 코드
   psmt.executeUpdate();

   out.println("수정 성공");
   
   response.sendRedirect("view.jsp?idx="+idx);
    
  }catch(Exception e){ 
    e.printStackTrace();
    out.println(sql);
  }
%>
<a href="list.jsp"><button type="button">리스트</button></a>
</body>
</html>