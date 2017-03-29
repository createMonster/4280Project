package jdbc;

import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*;
import java.util.*;
import java.sql.*;

public class logoutServlet extends HttpServlet 
{
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
 {
     HttpSession theSession = request.getSession(true);
     theSession.invalidate();

     response.setContentType("text/html");
     PrintWriter out = response.getWriter();

     out.println("<html><head><title>Logout Servlet</title></head><body>");
     out.println("<h1>Logout Servlet</h1>");
     out.println("You have logout successfully");

      out.println("<br>");
      out.println("<br>");
      out.println("Please click <a href=\"./login_form_demo.htm\">here</a> to login again"); 
      out.println("</body>");
      out.println("</html>");
      out.close();
  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
