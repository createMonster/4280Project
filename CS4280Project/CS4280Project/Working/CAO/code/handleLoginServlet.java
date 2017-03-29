package svlt;

import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*;
import java.sql.*;

public class handleLoginServlet extends HttpServlet 
{ 
 // processes the http GET request, throws Servlet exception if it cannot handle client 's request or throws IO exception if there is any problem in stream processing 
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
 {
     // gets the parameter from the form
     String user_id = request.getParameter("user_id");
     String user_pwd  = request.getParameter("user_pwd");
     String supportCookie = request.getParameter("supportCookie");
     String strCheckLogin = "";

     if(user_id == null || user_pwd == null)
	response.sendRedirect("./login_form_demo.htm");

     try {
      strCheckLogin = checkLogin(user_id, user_pwd);
     } catch (Exception e) {
      e.getMessage();
     }

     if (strCheckLogin.equals("Success"))
     {
	// apply session tracking, save the information in session
        // notice that session should be retrieved before you get Printer for response
        HttpSession session = request.getSession(true);
	session.setAttribute("ID",user_id);

        if (supportCookie == null) {
	  response.sendRedirect("mainServlet");
        }
        else { 
          response.setContentType("text/html");
          PrintWriter out = response.getWriter();
          out.println("<html><head><title></title></head>");
          out.println("<body>");
          out.println("If your web browser does not accept session cookie, please click <a href=\"");
          out.println(response.encodeURL("mainServlet"));
          out.println("\">here</a> to login");
          out.println("</body>");
          out.println("</html>");
          out.close();
        }
     }
     else
     {
      // specifies the content type to the client browser
      response.setContentType("text/html");

      // obtains PrintWriter object to send the text of HTML document to the client browser
      PrintWriter out = response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>Login Servlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h2>Login Failure</h2>");
      out.println("<p>Sorry, your login request is rejected by the following reason: </p>");
      out.println("<br><img src=\"http://upload.wikimedia.org/wikipedia/en/thumb/d/d6/OldStopSign.PNG/45px-OldStopSign.PNG\">");
      out.println("<br><b>" + strCheckLogin + "</b>");
      out.println("<br><br>");
      out.println("<A href=\"./login_form_demo.htm\">Please login again</A>");
      out.println("<br><br>");
      out.println("</body>");
      out.println("</html>");
      out.close();
   }
}

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }


  // authenticate the user login
  private String checkLogin(String id, String password) throws Exception {

      // STEP 1: define the connection URL
      String url = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=iad00_db;";
      String dbLoginId = "iad00";
      String dbPwd = "iad00abc";

      Connection con = null;
      Statement stmt = null;
      ResultSet rs = null;
      String strSQL = null;
      String result = null;

      try {
	  // STEP 2: load the SQL server 2000 JDBC driver
          /* not required for JDBC 4 */
	  /* Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); */

          // STEP 3: establish the connection to the database
	  con = DriverManager.getConnection(url, dbLoginId, dbPwd);

	  // STEP 4: create a statement
	  stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
      }
      /* catch(java.lang.ClassNotFoundException cnfe) {
	  cnfe.printStackTrace();
	} */
      catch(SQLException sqlex) {
        sqlex.printStackTrace();
      }

      strSQL = "SELECT * FROM login_tbl " + "WHERE user_id = '" + id + "'";

      try {
	  // STEP 5: execute a query
	  rs = stmt.executeQuery(strSQL);

	  // STEP 6: loop through the resultset object
	  if(!rs.next())
	  {
	    result = "Invalid Login";
	  }		
	  else if(!rs.getString("user_pwd").equals(password))
	  {
	    result = "Wrong Password";
	  }
	  else
	  {
	    result = "Success";
	  }

	  rs.close();   //close ResultSet object
	  stmt.close(); //close Statement object
	  con.close();  //close Connection object

      }
      catch(SQLException sqlex) {
	  sqlex.printStackTrace();
	  throw sqlex;
      }

      return result;
  }
}
