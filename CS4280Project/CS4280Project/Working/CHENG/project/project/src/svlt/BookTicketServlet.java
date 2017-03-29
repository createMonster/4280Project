/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svlt;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


/**
 *
 * @author yanrcheng2
 */
public class BookTicketServlet extends HttpServlet {

        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName = aiad068_db;";

        //  Database credentials
        static final String USER = "aiad068";
        static final String PASS = "aiad068";

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String strDetails = "";
        String fno = null;
        String sno = null;
        try {
            fno = request.getParameter("flight#");
            sno = request.getParameter("seat#");
        }catch (NullPointerException npe){
            out.println("please enter the required information");
        }
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM WCCTicket ";
                    //+ "WHERE Fno = " + fno + " AND Sno = " + sno + ";";
            
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                strDetails += (rs.getString("Fno") != null? rs.getString("Fno") : "Not found");
                strDetails += "-";
                strDetails += (rs.getString("Sno") != null? rs.getString("Sno") : "Not found");
                strDetails += "-";
                strDetails += rs.getString("price");
                strDetails += "-";
                strDetails += rs.getString("type");
                strDetails += "-";
                strDetails += (rs.getString("book_status").equals("0")?"Not Booked" : "Booked");
                strDetails += "<br />";
            }
            out.println(strDetails);

            
        } catch (SQLException sqle) {
            //Handle errors for JDBC
            out.println("Message:  " + sqle.getMessage());
            out.println("SQLState: " + sqle.getSQLState());
            out.println("Vendor Error: " + sqle.getErrorCode());
        }catch (NullPointerException npe){
            out.println("null pointer exception");
        }catch (Exception e) {
            //Handle errors for Class.forName
            out.println("something went wrong");
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        out.println("Goodbye!");
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
