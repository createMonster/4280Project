package airplaneSystem;

import java.util.List;

public class Company {

	private List<Flight> flights;
	private String companyName;
	private String email;
	private String phone;
	private String name;
	private String pwd;

	/**
	 * 
	 * @param name
	 * @param pwd
	 */
	public void Conpany(String name, String pwd) {
		// TODO - implement Company.Conpany
		throw new UnsupportedOperationException();
	}

	public List<Flight> getFlights() {
		return this.flights;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * 
	 * @param flight
	 */
	public Boolean addFlight(Flight flight) {
		// TODO - implement Company.addFlight
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param flight
	 */
	public void setStandardPrice(Flight flight) {
		// TODO - implement Company.setStandardPrice
		throw new UnsupportedOperationException();
	}

}