public class Flight {

	private String flightNo;
	private String airplaneModel;
	private List<Ticket> tickets;
	private Company company;
	private int seatNo;
	private int firstClassNo;
	private int standardPrice;

	/**
	 * 
	 * @param flightNo
	 * @param airplaneModel
	 */
	public Flight(String flightNo, String airplaneModel) {
		// TODO - implement Flight.Flight
		throw new UnsupportedOperationException();
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	/**
	 * 
	 * @param tickets
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public int getFirstClassNo() {
		return this.firstClassNo;
	}

	/**
	 * 
	 * @param firstClassNo
	 */
	public void setFirstClassNo(int firstClassNo) {
		this.firstClassNo = firstClassNo;
	}

}