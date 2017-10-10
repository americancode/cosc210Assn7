
/**
 * COSC 210-001 Assignment 7
 * Prog7.java
 * 
 * This program reads in information from two text files 
 * and stores them in object arrays of that data type
 * and prints a report of what each warehouse contains
 * 
 * @author Nathaniel Churchill
 *
 */
import java.util.*;
import java.io.*;

public class Prog7 {

	public static void main(String[] args) {
		// getting input from warehouse file
		Scanner inFile = null;// scanner reference used for both text files
		try {
			inFile = new Scanner(new File("warehouse.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File was not found: " + e);
		}

		Warehouse[] warehouses = new Warehouse[10];
		int numWarehouses = 0;
		try {
			while (inFile.hasNext()) {
				String line = inFile.nextLine();
				// split on one or more spaces
				String[] splitLine = line.split("[ ]+"); 
				warehouses[numWarehouses] = new Warehouse(splitLine[0],
						splitLine[1], splitLine[2]);
				numWarehouses++;// increments the number of warehouses
			}
		} catch (InputMismatchException e) {
			System.out.println("Incorrect input in file: " + e);
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e);
		}
		inFile.close();//close warehouse.txt

		// getting input from parts file
		try {
			inFile = new Scanner(new File("parts.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File was not found: " + e);
		}

		Part[] parts = new Part[50];
		int numParts = 0;
		try {
			while (inFile.hasNext()) {
				String line = inFile.nextLine();
				// split on a comma with preceding or following spaces
				String[] splitLine = line.split("[ ]*,[ ]*"); 
				parts[numParts] = new Part(splitLine[0], splitLine[1],
						Double.parseDouble(splitLine[2]), splitLine[3],
						Integer.parseInt(splitLine[4]));
				numParts++;
			}
		} catch (InputMismatchException e) {
			System.out.println("Incorrect input in file: " + e);
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e);
		}
		inFile.close();// close parts.txt

		// Sort the array of parts
		Arrays.sort(parts, 0, numParts);

		// Output for the program
		System.out.println("Report for each warehouse" 
				+ " and the parts it contains\n");
		// print each warehouse
		for (int i = 0; i < numWarehouses; i++) {
			System.out.println(warehouses[i].getWarehouseId() + " "
					+ warehouses[i].getCity() + ", "
					+ warehouses[i].getState());
			//print the total number of parts in each warehouse
			System.out.println("Total number of parts for this warehouse: "
					+ Part.numberOfParts(warehouses[i].getWarehouseId(), parts,
							numParts)
					+ "\n");
			// print all the parts for this warehouse
			System.out.printf("%-7s%-32s%8s  %-9s\n", "Part#", "Description",
					"Price", "Quantity");
			for (int j = 0; j < numParts; j++) {
				if (warehouses[i].getWarehouseId()
						.equals(parts[j].getWarehouseId())) {
					System.out.printf("%-7s%-32s%8.2f  %-9d\n",
							parts[j].getPartNumber(), parts[j].getDescription(),
							parts[j].getPrice(), parts[j].getQuantityOfParts());
				}
			}
			System.out.println("\n");
		}
		
		
		
	}

}
