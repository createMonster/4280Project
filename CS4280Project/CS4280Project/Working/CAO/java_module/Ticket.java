public class Ticket {

	private String seatNo;
	private bool bookStatus;
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
		// TODO - implement Ticket.Ticket
		this.seatNo = seatNo;
		this.flight = flight;
		this.price = price;
		throw new UnsupportedOperationException();
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

}