/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svlt;

/**
 *
 * @author yanrcheng2
 */
public class SQLStatement {
    public static String createFlightTable = "CREATE TABLE WCCFlight"
            + " (Fno VARCHAR(20) not NULL,"
            + " Cname VARCHAR(20) not NULL,"
            + " Dairport VARCHAR(20) not NULL,"
            + " Aairport VARCHAR(20) not NULL,"
            + " Dtime VARCHAR(20) not NULL,"
            + " Atime VARCHAR(20) not NULL,"
            + " airplane VARCHAR(20) not NULL,"
            + " PRIMARY KEY ( Fno, Cname ));";
    
    public static String createTicketTable = "CREATE TABLE WCCTicket"
            + " (Fno VARCHAR(20) not NULL,"
            + " Sno VARCHAR(20) not NULL,"
            + " price INTEGER not NULL,"
            + " type INTEGER not NULL,"
            + " book_status bit not NULL,"
            + " PRIMARY KEY ( Fno, Sno ));";
    
    public static String createOrdertable = "CREATE TABLE WCCOrder"
            + " (Ono VARCHAR(20) not NULL,"
            + " user_name VARCHAR(20) not NULL,"
            + " Cname VARCHAR(20) not NULL,"
            + " Fno VARCHAR(20) not NULL,"
            + " Sno VARCHAR(20) not NULL,"
            + " payment_status bit not NULL,"
            + " PRIMARY KEY ( Ono ), "
            + " FOREIGN KEY ( Fno, Sno ) REFERENCES WCCTicket(Fno, Sno));";
    
    public static String insertFlightSample = "INSERT INTO WCCFlight"
            + " VALUES ( \'SampleFno\', \'SampleCompany\', \'SampleAirport\', "
            + " \'SampleAirport\', \'123456\', \'123456\', \'SampleAirplane\')";
    
    public static String insertTicketSample = "INSERT INTO WCCTicket"
            + " VALUES ( \'SampleFno\', \'SampleSeat#\', \'1000\', "
            + " \'2\', \'0\')";
    
    public static String insertOrderSample = "INSERT INTO WCCOrder"
            + " VALUES ( \'SampleOno\', \'Joe\', \'Samplecompany\', "
            + " \'SampleFno\', \'SampleSeat#\', \'0\')";
    
    
    
    /*
            
     stmt.executeUpdate(SQLStatement.createFlightTable);
     out.println("flight table created");
            
     stmt.executeUpdate(SQLStatement.createTicketTable);
     out.println("Ticket table created");
            
     stmt.executeUpdate(SQLStatement.createOrdertable);
     out.println("order table created");

     stmt.executeUpdate(SQLStatement.insertFlightSample);
     out.println("flight instance created");
            
     stmt.executeUpdate(SQLStatement.insertTicketSample);
     out.println("ticket instance created");
            
     stmt.executeUpdate(SQLStatement.insertOrderSample);
     out.println("order instance created");
     */

    /* a testing with TestTable
     String sql = "CREATE TABLE TestTable "
     + "(username VARCHAR(20) not NULL, "
     + " pwd VARCHAR(20) not NULL, "
     + " PRIMARY KEY ( username ));";
            
     String insertionSql = "INSERT INTO TestTable"
     + " VALUES ( \'bill\', \'123\' );";
            
     String extractionSql = "SELECT * FROM TestTable;";

     //stmt.executeUpdate(sql);
     //table creation finish
                        
     //stmt.executeUpdate(insertionSql);
     //out.println("insertion completed");
            
     rs = stmt.executeQuery(extractionSql);
     while (rs.next()) {
     strDetails += rs.getString("username");
     strDetails += "-";
     strDetails += rs.getString("pwd");
     strDetails += "<br />";
     }
     out.println(strDetails);
     */

}

