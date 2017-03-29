package svlt;

import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*;
import java.util.*;
import java.sql.*;

public class Register extends HttpServlet 
{
 String userName = null;
 
 // processes the http GET request, throws Servlet exception if it cannot handle client 's request or throws IO exception if there is any problem in stream processing 
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
 {
     HttpSession theSession = request.getSession(true);
     String ID = (String)theSession.getAttribute("ID");

     response.setContentType("text/html");
     PrintWriter out = response.getWriter();

     if (ID == null) {
      response.sendRedirect("login_form_demo.htm");
      // Notice that the above sendRedirect method should be called in order to redirect the client back to the login page or other error page. For demo purpose, here we output the error message and session information with the following code. 
      out.println("<html><head><title>Main Servlet</title></head><body>");
      out.println("<h1>Sorry! Login Failure.</h1>");
      out.println("<br><br>");
      out.println("Your web browser probably does not support session cookie, or has disabled its usage.");
      out.println("<br><br>");
     }
     else
     {
      try {
        userName = checkDetail(ID);
      } catch (Exception e) {
        e.printStackTrace();
      } 

      out.println("<html><head><title>Main Servlet</title></head><body>");
      out.println("<h1>Main Page</h1>");
      out.println("<br>");
      out.println("Welcome "+ userName + "&nbsp; (" + ID + ")");

      out.println("<br><br><br>");
      out.println("<a href=\"logoutServlet\">Logout</a>");
      out.println("<br><br><br>");
     }

      // ---------------------------------------
      out.println("<hr>");
      Integer accessCount = new Integer(0);
      if (theSession.isNew())
        out.println("Session: New");
      else
        out.println("Session: Already exists");
      out.println("<br>");
      Integer previousAccessCount = (Integer) theSession.getAttribute("accessCount");
      if (previousAccessCount != null)
        accessCount = new Integer(previousAccessCount.intValue() + 1);  
      theSession.setAttribute("accessCount", accessCount);
      out.println("Number of previous access: " + accessCount);
      out.println("<br>");
      out.println("Session ID: " + theSession.getId());
      out.println("<br>");
      out.println("Session Max Inactive Time: " + theSession.getMaxInactiveInterval() + " seconds");
      out.println("<br>");
      java.util.Date createdDateTime = new java.util.Date(theSession.getCreationTime());
      out.println("Session Creation Time: " + createdDateTime);
      out.println("<br>");
      java.util.Date lastAccessedDateTime = new java.util.Date(theSession.getLastAccessedTime());
      out.println("Session Last Accessed Time: " + lastAccessedDateTime);
      out.println("<br>");
      if(request.isRequestedSessionIdFromCookie())
        out.println("Session: created from cookie");
      if(request.isRequestedSessionIdFromURL())
        out.println("Session: came as part of the URL");
      out.println("<hr>");
      // ------------------------------------------------

      out.println("</body>");
      out.println("</html>");
      out.close();
  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  public String checkDetail(String ID) throws Exception {
      
      String url = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName = iad00_db;";
      String dbLoginId = "iad00";
      String dbPwd = "iad00abc";

      Connection con = null;
      Statement stmt = null;
      ResultSet rs = null;
      String strSQL = null;
      String result = null;

      try {
          /* not required for JDBC 4 */
          /* Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); */
          con = DriverManager.getConnection(url, dbLoginId, dbPwd);
          stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
      }
      /* catch(java.lang.ClassNotFoundException cnfe) {
          cnfe.printStackTrace();
      } */
      catch(SQLException sqlex) {
        sqlex.printStackTrace();
      }

      try {
        strSQL = "SELECT s.* FROM std_tbl s, login_tbl l WHERE l.user_id= '"+ID+"' AND l.user_id=s.std_id";
        rs = stmt.executeQuery(strSQL);
        while (rs.next())
        {
           userName = rs.getString("first_name");
           userName = userName + " " + rs.getString("last_name");
        }
      }
      catch(SQLException sqlex) {
        sqlex.printStackTrace();
        throw sqlex;
      }
      return userName;
  }
}