import org.json.*;
import java.io.*;
import java.util.*;

public class Customer {

	private String id;
	private String pwd;
	private String phone;
	private String email;
	private List<Ticket> tickets;
	private int bonusPoint;

	/**
	 * 
	 * @param id
	 * @param pwd
	 */
	public Customer(String id, String pwd, String phone, String email) {
		this.id = id;
		this.pwd = pwd;
		this.phone = phone;
		this.email = email;	
		this.bonusPoint = 0;
		this.tickets = new ArrayList<Tickets>();
		JSONObject obj = new JSONObject("{\}");
		DBManager DBm = DBManager.getInstance();
		String SQLName = "NEWCUSTOMER";
		DBm.executeSQLStatement(DBm.getSQLStatement(SQLName), obj);
	}
	
	public Customer(String id){
		this.id = id;		
	}

	/**
	 * 
	 * @param id
	 */
	public static Customer getCustomerFromID(String id) {
		
		if(checkCustomer(id))
			return Customer(id);
		// TODO - implement Customer.getCustomerFromID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dest
	 * @param depart
	 * @param destTime
	 */
//	public bool queryTicket(String dest, String depart, String destTime) {
//		// TODO - implement Customer.queryTicket
//		throw new UnsupportedOperationException();
//	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getBonusPoint() {
		return this.bonusPoint;
	}

	public String getPwd() {
		return this.pwd;
	}

	/**
	 * 
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	/**
	 * 
	 * @param ticket
	 */
	public void applyBookingTicket(Ticket ticket) {
		tickets.add(ticket);
		// TODO - implement Customer.applyBookingTicket
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ticket
	 */
	public bool cancelTicket(Ticket ticket) {
		tickets.remove(ticket);
		// TODO - implement Customer.cancelTicket
		throw new UnsupportedOperationException();
	}

	public bool useBonusPoint() {
		if(bonusPoint>0)
			return true;
		return false;
		// TODO - implement Customer.useBonusPoint
		throw new UnsupportedOperationException();
	}

}