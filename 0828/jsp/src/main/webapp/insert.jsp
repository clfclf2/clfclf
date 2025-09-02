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
  String sql = "";
  Connection conn=null;
  PreparedStatement psmt = null;
  ResultSet rs = null;
  

  try{
	conn = DB.getConnection();
    //out.println("연결 성공");
   
	String userid = request.getParameter("userid");

	if( userid == null || userid.equals(""))
	{
	%>
	<script>
	alert("아이디 값 없음");
	location.replace("join.jsp");
	</script>   
	<%   
	   return;
	}
	
	sql = "select count(*) as cnt from member where id=?";
	psmt = conn.prepareStatement(sql);
	psmt.setString(1, userid);
	
	rs = psmt.executeQuery();
	
	rs.next();
	int cnt = rs.getInt("cnt");

	if(cnt > 0)
	{
	   %>
	   <script>
	   alert("아이디 중복");
	   location.replace("join.jsp");
	   </script>   
	   <%
	   return;
	}

	String userpwd= request.getParameter("userpwd");
	String userpwd2= request.getParameter("userpwd2");
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

	String username = request.getParameter("username");
	if(username == null || username.equals(""))
	{
	%>
	<script>
	alert("이름 값 없음");
	location.replace("join.jsp");
	</script>
	<%   
	      return;
	}

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
   //쿼리문 작성
  
   <% 
   for(int i=1; i<=177; i++){
   sql= "insert into member(id,password,name,gender,birth,hobby) values(?,?,?,?,?,?)";
   //Connection객체로부터 Statement객체를 얻어내는 코드
	
   psmt = conn.prepareStatement(sql);
   psmt.setString(1, userid+i);
   psmt.setString(2, userpwd);
   psmt.setString(3, username);
   psmt.setString(4, g);
   psmt.setString(5, ymd);
   psmt.setString(6, hobby);
   
  
   //쿼리문을 DB에 실행하는 코드
  // st.executeUpdate(sql2);
	
   psmt.executeUpdate();
   out.println("등록성공");
   }
   
   response.sendRedirect("list.jsp");
    
  }catch(Exception e){ 
    e.printStackTrace();
    out.println(sql);
  }finally {
	  if(rs !=null) rs.close();
	  if(psmt != null) psmt.close();
	  if(conn != null) conn.close(); 
  }
  %>

</body>
</html>