package net.umapath;

public class Address {

	AddressId id;
	String street;
	String city;
	String state;
	public AddressId getId() {
		return id;
	}
	public void setId(AddressId id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
}
