<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>  
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>    
<%@ page import="lib.DB" %> 

<%
Date now= new Date();
SimpleDateFormat s= new SimpleDateFormat("yyyy");
int year= Integer.parseInt(s.format(now));
%>
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
    
  }catch(Exception e){ 
    e.printStackTrace();
    out.println(sql);
  }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지</title>
</head>
<body>

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
    String str[] = birth.split("-");  
 %>
 
 기본키: <%=idx %><br>
 아이디: <%=id %><br>
 패스워드: <%=password %><br>
 이름: <%=name %><br>
 성별: <%=gender %><br>
 생일: <%=birth %><br>
 취미: <%=hobby %><br>
 
 

<br>
<h2>회원 정보 수정</h2>
<form name="join_form" method="post" action="modify_proc.jsp">
<input type ="hidden" name="idx" value=<%=idx %>>
		아이디 <input type="text" name ="userid" value=<%=id%>><br>
		비밀번호 <input type="password" name ="password" value=<%=password%> ><br>
		비밀번호 확인 <input type="password" name ="password2" value=<%=password %>><br>
		이름 <input type="text" name ="name" value=<%=name %>><br>
		성별 <input type="radio" name="gender" value="남" <%=(gender.contains("남"))?"checked":""%>>남자
<input type="radio" name="gender" value="여" <%=(gender.contains("여"))?"checked":""%>>여자<br>
		
		
		생일 <select name="y">
		<%  for( int i=1950; i<year+1; i++){
		%>	
		<option <%= i==Integer.parseInt(str[0])? "selected":"" %>><%=i %></option>
		
		
		<%
		}
		%>
		
		</select>년
		
		<select name="m">
		<%  for( int i=1; i<13; i++){	
				if(i<10){
			%>
			<option <%= i==Integer.parseInt(str[1])? "selected":"" %>>0<%=i %></option>
			<%
			}
				else{
			%>
				<option <%= i==Integer.parseInt(str[1])? "selected":"" %>><%=i %></option>
			<%}
			%>	
			<%}%>
			
			
		</select>월
		<select name="d">
		<%  for( int i=1; i<32; i++){	
				if(i<10){
			%>
			<option <%= i==Integer.parseInt(str[2])? "selected":"" %>>0<%=i %></option>
			<%
			}
				else{
			%>
				<option <%= i==Integer.parseInt(str[2])? "selected":"" %>><%=i %></option>
			<%}
			%>	
			<%}%>
		</select>일
		<br>
	취미 <input type="checkbox" name="hobby" value="축구" <%=(hobby.contains("축구"))?"checked":""%>>축구
		<input type="checkbox" name="hobby" value="게임" <%=(hobby.contains("게임"))?"checked":""%>>게임
		<input type="checkbox" name="hobby" value="영화" <%=(hobby.contains("영화"))?"checked":""%>>영화
		<br>
		<button type="submit">수정</button>
		<button type="reset">리셋</button>
		<a href="list.jsp"><button type="button">리스트</button></a>
		</form>
 <%
 }
 %>
</body>
</html>