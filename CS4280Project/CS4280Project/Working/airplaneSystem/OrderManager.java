package airplaneSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderManager implements CompanyTicketManager, CustomerTicketManager {
	
	static private OrderManager orderManager = new OrderManager();
	
	private HashMap<Customer, Order> orders;
	private HashMap<Company, List<Ticket>> awaitingTickets;
	
	private OrderManager(){
		this.orders = new HashMap<>();
		this.awaitingTickets = new HashMap<>();
	}
	
	public static OrderManager getInstance() {return orderManager;}
	
	@Override
	public Boolean bookTickets(Customer customer, List<Ticket> tickets) {
		Boolean done = true;
		Order order = new Order(customer);
		for(Ticket t : tickets){
			t.setCustomer(customer);
			order.addTicket(t);
			addAwaitingTicket(t);
		}
		orders.put(customer, order);
		return done;
	}

	private void addAwaitingTicket(Ticket ticket) {
		if(awaitingTickets.containsKey(ticket.getFlight().getCompany())){
			awaitingTickets.get(ticket.getFlight().getCompany()).add(ticket);
		}else{
			List<Ticket> container = new ArrayList<>();
			container.add(ticket);
			awaitingTickets.put(ticket.getFlight().getCompany(), container);
		}
	}

	@Override
	public Boolean cancelTicket(Customer customer, Ticket ticket) {
		Boolean done = true;
		orders.get(customer).cancelTicket(ticket);
		awaitingTickets.get(ticket.getFlight().getCompany()).remove(ticket);
		return done;
	}

	@Override
	public Boolean approveTicket(Ticket ticket) {
		Boolean done = true;
		awaitingTickets.get(ticket.getFlight().getCompany()).remove(ticket);
		ticket.setBookStatus(true);
		return done;
	}

	@Override
	public List<Ticket> getAwaitingTickets(Company company) {
		return awaitingTickets.get(company);
	}
}