import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.*;

public class DBManager {

	private final String DB_NAME = "iad017_db";//really?
	private final Stirng DB_USERNAME = "iad017";
	private final String DB_USERPWD = "iad017";
	private final String url = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName = iad017_db;";
	private static DBManager instance;
	private List<String> sqlStatementNames;
	
	Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String strSQL = null;
    String result = null;

	/**
	 * 
	 * @param db
	 * @param user
	 * @param pwd
	 */
	private DBMAnager() {
		
		connect();
		// TODO - implement DBManager.DBMAnager
		
	}

	public static DBManager getInstance() {
		// TODO - implement DBManager.getInstance
		if (instance == null)
			instance = new DBAManager();
		return instance;
		
	}

	public void connect() {
		// TODO - implement DBManager.connect
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, DB_USERNAME, DB_USERPWD);
			
		}
		catch(SQLException sqlex) {
	        sqlex.printStackTrace();	      
	    }
		throw new UnsupportedOperationException();
	}

	public bool disconnect() {
		con.close();
		stmt.close();
		rs.close();		
	}
	
	public String getSQLStatement(String name){
		
		String filename = "sql.txt";
		String line = null;
		FileReader fileReader = null;
		String statement = null;
		try{
			fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((line = bufferedReader.readLine())!=null){
				if(line.contains(name)){
					int equalMark = line.indexOf("=");
					statement = line.substring(equalMark+1);
					return statement;
				}		
			}
		}
		catch(FileNotFoundException ex) {
	        System.out.println(
	            "Unable to open file '" + 
	            fileName + "'");                
	    }
	    catch(IOException ex) {                 
	        // Or we could just do this: 
	        ex.printStackTrace();
	    }
	    finally
	    {
	        if(fileReader != null){
	           bufferedReader.close();            
	        }
	    }
	}
	
	//to be modified
	public void executeSQLStatement(String statement, JSONObject obj) {
		String firstWord = statement.substring(0, statement.indexOf(' '));
		String id = obj.getString("id");
		
		stmt = con.prepareStatement(statement);
		stmt.setString(1, x);//to be modified
		if(firstWord == "SELECT" || firstWord =="select"){
			rs = stmt.executeQuery(statement);
		}
		else{
			int rows = stmt.executeUpdate(statement);
		}
	}

}