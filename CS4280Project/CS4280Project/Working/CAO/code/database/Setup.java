import java.sql.*;

public class Setup {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName = iad017_db;";

   //  Database credentials
   static final String USER = "iad017";
   static final String PASS = "iad017";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      //Class.forName("com.mysql.jdbc.Driver");
      //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
      String sql = "CREATE TABLE LarryLogin " +
                   "(username VARCHAR(20) not NULL, " + 
                   " pwd VARCHAR(20) not NULL, " + 
                   " PRIMARY KEY ( username ))"; 

      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample
