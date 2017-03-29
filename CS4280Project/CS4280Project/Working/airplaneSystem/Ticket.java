package airplaneSystem;

public class Ticket {

	private String seatNo;
	private Boolean bookStatus;
	private SeatType type;
	private Flight flight;
	private Customer customer;
	private int price;

	/**
	 * 
	 * @param seatNo
	 * @param flight
	 * @param price
	 */
	public Ticket(String seatNo, Flight flight, int price) {
		this.setBookStatus(false);
		//please add the rest of the fields, noting that price should be determine by both flight and type
	}

	public int getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Boolean getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(Boolean bookStatus) {
		this.bookStatus = bookStatus;
	}

}