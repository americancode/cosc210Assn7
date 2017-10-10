/**
 * COSC 210-001 Assignment 7
 * Part.java
 * 
 * This class represents one warehouse with the attributes
 * of id number, city, and state
 * 
 * @author Nathaniel Churchill
 *
 */
public class Warehouse {
	private String warehouseId;
	private String city;
	private String state;

	//Constructor
	public Warehouse(String warehouseId, String city, String state) {
		super();
		this.warehouseId = warehouseId;
		this.city = city;
		this.state = state;
	}
	//Getters
	public String getWarehouseId() {
		return warehouseId;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
}
