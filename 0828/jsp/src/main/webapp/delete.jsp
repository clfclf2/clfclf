<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>    
<%@ page import="lib.DB" %> 
<%

String idx = request.getParameter("idx");

String sql = "";

  Connection conn=null;

  try{
	  conn = DB.getConnection();
    //out.println("연결 성공");
    
   //쿼리문 작성
   sql = " delete from member where idx ='"+idx+"' ";
   
   //Connection객체로부터 Statement객체를 얻어내는 코드
   Statement st = conn.createStatement();
   
   //쿼리문을 DB에 실행하는 코드
   st.executeUpdate(sql);

   out.println("삭제 성공");
   
   response.sendRedirect("list.jsp");
    
  }catch(Exception e){ 
    e.printStackTrace();
    out.println(sql);
  }
%>