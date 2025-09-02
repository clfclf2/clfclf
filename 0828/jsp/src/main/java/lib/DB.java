package lib;

import java.sql.*;

public class DB {
   
   public static Connection getConnection() throws Exception{
      
      String jdbcUrl = "jdbc:mysql://localhost:3306/jsp_db";
      String dbId = "user"; // 설정된 id
      String dbPass = "1234"; // 설정된 password
 
      Class.forName("com.mysql.cj.jdbc.Driver"); 
      Connection con = DriverManager.getConnection(jdbcUrl,dbId ,dbPass);
      
      return con;
   }
}