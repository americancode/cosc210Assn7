/**
 * COSC 210-001 Assignment 7 Warehouse.java
 * 
 * This class represents a single part with the appropriate information of part
 * number, description, price, warehouse id, quantity
 * 
 * @author Nathaniel Churchill
 *
 */
public class Part implements Comparable {
	private String partNumber;
	private String description;
	private double price;
	private String warehouseId;
	private int quantityOfParts;

	// Constructor
	public Part(String partNumber, String description, double price,
			String warehouseId, int quantityOfParts) {
		super();
		this.partNumber = partNumber;
		this.description = description;
		this.price = price;
		this.warehouseId = warehouseId;
		this.quantityOfParts = quantityOfParts;
	}

	// Getters
	public String getPartNumber() {
		return partNumber;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public int getQuantityOfParts() {
		return quantityOfParts;
	}

	@Override
	public int compareTo(Object arg) {
		if (this.price > ((Part) arg).price) {
			return 1;
		} else if (this.price < ((Part) arg).price) {
			return -1;
		} else {
			return 0;
		}
	}
	//custom Methods
	/**
	 * this static method calculates the number of parts in each warehouse
	 * 
	 * @param id  the id that matches each part with the corresponding warehouse
	 * @param parts the array of Parts 
	 * @param numParts  indicates how much of the parts array is used
	 * @return returns an integer value for the number of parts in each warehouse
	 */
	public static int numberOfParts(String id, Part[] parts, int numParts){
		int numberOfParts = 0;
		for(int i = 0; i < numParts; i++){
			if (parts[i].getWarehouseId().equals(id)){
				numberOfParts += parts[i].getQuantityOfParts();
			}
		}
		return numberOfParts;
	}

}
