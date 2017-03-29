package airplaneSystem;

import java.util.List;

public class Customer {

	private String id;
	private String pwd;
	private List<Ticket> tickets;
	private String bonusPoint;

	/**
	 * 
	 * @param id
	 * @param pwd
	 */
	public Customer(String id, String pwd) {
		// TODO - implement Customer.Customer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public static Customer getCustomerFromID(String id) {
		// TODO - implement Customer.getCustomerFromID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dest
	 * @param depart
	 * @param destTime
	 */
	public Boolean queryTicket(String dest, String depart, String destTime) {
		// TODO - implement Customer.queryTicket
		throw new UnsupportedOperationException();
	}

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
		// TODO - implement Customer.applyBookingTicket
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ticket
	 */
	public Boolean cancelTicket(Ticket ticket) {
		// TODO - implement Customer.cancelTicket
		throw new UnsupportedOperationException();
	}

	public Boolean useBonusPoint() {
		// TODO - implement Customer.useBonusPoint
		throw new UnsupportedOperationException();
	}

}