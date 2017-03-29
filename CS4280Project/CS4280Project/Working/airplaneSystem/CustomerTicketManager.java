package airplaneSystem;

import java.util.List;

public interface CustomerTicketManager {
	Boolean bookTickets(Customer customer, List<Ticket> tickets);
	Boolean cancelTicket(Customer customer, Ticket ticekt);
}