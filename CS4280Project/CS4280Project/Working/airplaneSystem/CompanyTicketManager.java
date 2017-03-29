package airplaneSystem;

import java.util.List;

public interface CompanyTicketManager {
	Boolean approveTicket(Ticket ticket);
	List<Ticket> getAwaitingTickets(Company company);
}