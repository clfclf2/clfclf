<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>  
<%@ page language="java" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력</title>
</head>
<body>
<h1> 회원 정보</h1>
<%


String id= request.getParameter("userid");
String ps= request.getParameter("userpwd");
String ps2= request.getParameter("userpwd2");
String n= request.getParameter("username");
String g= request.getParameter("gender");
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


아이디 : <%= id %><br>
비밀번호 : <%= ps %><br>
비번확인 : <%= ps2 %><br>
이름 : <%= n %><br>
성별 :  <%= g %><br>
생년월일 : <%= y%>년 <%= m%>월 <%= d%>일<br>
취미 : <%
if(h !=null){
for(String str:h){
%><%= str %> 
<%}
}
%>
<br>

<% 
String sql = "";

  Connection conn=null;
  
  try{
     String jdbcUrl = "jdbc:mysql://localhost:3306/jsp_db";
     String dbId = "user"; // 설정된 id
     String dbPass = "1234"; // 설정된 password
   
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
    //out.println("연결 성공");
    
   //쿼리문 작성
   sql = "insert into member(id,password,name,gender,birth,hobby) " +
   " values('"+id+"','"+ps+"','"+n+"','"+g+"','"+ymd+"','"+hobby+"')";
   
   //Connection객체로부터 Statement객체를 얻어내는 코드
   Statement st = conn.createStatement();
   
   //쿼리문을 DB에 실행하는 코드
   st.executeUpdate(sql);

   out.println("등록성공");
    
  }catch(Exception e){ 
    e.printStackTrace();
    out.println(sql);
  }
%>
<br>
<a href="list.jsp"><button type="button">리스트</button></a>
</body>
</html>