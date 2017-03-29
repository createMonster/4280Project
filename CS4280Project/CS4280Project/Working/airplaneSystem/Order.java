package airplaneSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private List<Ticket> tickets;
	private Customer customer;
	private Date date;
	
	public Order(Customer customer){
		this.customer = customer;
		this.tickets = new ArrayList<>();
		this.date = new Date();
	}
	
	public void addTicket(Ticket ticket){
		this.tickets.add(ticket);
	}
	
	public void cancelTicket(Ticket ticket){
		this.tickets.remove(ticket);
	}
}
