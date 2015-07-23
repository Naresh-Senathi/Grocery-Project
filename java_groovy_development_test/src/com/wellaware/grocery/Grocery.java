/**
 * 
 */
package com.wellaware.grocery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Naresh Kumar
 *
 */
public class Grocery {

	private static Grocery grocery = new Grocery();

	/* A private Constructor prevents any other class from instantiating. */
	private Grocery() {
	}

	/* Static 'instance' method */
	public static Grocery getInstance() {
		return grocery;
	}

	private int numOfCustomers = 0;
	
	public static Register[] registerArray;
	public static Customer[] customerArray;
	
	public static void main(String args[]) throws IOException {
		
		// Initializing Grocery
		Grocery grocery = Grocery.getInstance();
		grocery.readFile(args[0]);
		
		for(int t=0;;t++){
			Customer inCustomer = null;
			for(int i=0; i<grocery.numOfCustomers;i++){
				if(t == customerArray[i].getInTime()){
					inCustomer = customerArray[i];
					break;
				}
			}
			
			if(inCustomer != null){
				if(inCustomer.getType().equals("A")) {
					Register addCustARegister = registerArray[0];
					for(int j=0; j<registerArray.length-1; j++){
						if(registerArray[j].getCustomerQueue().size() < registerArray[j+1].getCustomerQueue().size()){
							addCustARegister = registerArray[j];
						}
					}
					addCustARegister.getCustomerQueue().add(inCustomer);
					inCustomer.setProcessingTime(addCustARegister.getProcessingTime() * inCustomer.getNumOfItems());
				}
				else {
					Register addCustBRegister = registerArray[0];
					boolean registerAssigned = false;
					for(int j=0; j<registerArray.length; j++){
						if(registerArray[j].getCustomerQueue().size()==0){
							addCustBRegister = registerArray[j];
							registerAssigned = true;
						}
					}
					if (!registerAssigned) {
						for (int j = 0; j < registerArray.length - 1; j++) {
							if (registerArray[j]
									.getCustomerQueue()
									.get(registerArray[j].getCustomerQueue()
											.size() - 1).getNumOfItems() < registerArray[j + 1]
									.getCustomerQueue()
									.get(registerArray[j + 1]
											.getCustomerQueue().size() - 1)
									.getNumOfItems()) {
								addCustBRegister = registerArray[j];
							}
						}
					}
					addCustBRegister.getCustomerQueue().add(inCustomer);
					inCustomer.setProcessingTime(addCustBRegister.getProcessingTime() * inCustomer.getNumOfItems());
				}
			}
			
			for(int i=0; i<grocery.numOfCustomers; i++){
				for(int j=0; j<registerArray.length;j++){
					if(t!=0 && t == (registerArray[j].getTotalProcessingTime() + customerArray[i].getProcessingTime())){
						if (registerArray[j].getCustomerQueue().size() > 0) {
							if (registerArray[j].getCustomerQueue().get(0) == customerArray[i]) {
								registerArray[j].getCustomerQueue().remove(0);
								registerArray[j].setTotalProcessingTime(t);
							}
						}
					}
				}
			}
			
			boolean billingDone = true;
			for(int j=0; j<registerArray.length; j++){
				if(t==0 || registerArray[j].getCustomerQueue().size()!=0){
					billingDone = false;
					break;
				}
			}
			if(billingDone){
				int totalProcessingTime = registerArray[0].getTotalProcessingTime();
				for(int j=0; j<registerArray.length-1; j++){
					if(registerArray[j+1].getTotalProcessingTime() > registerArray[j].getTotalProcessingTime()){
						totalProcessingTime = registerArray[j+1].getTotalProcessingTime();
					}
				}
				System.out.print("Finished at: t=");
				System.out.print(totalProcessingTime+1); 
				System.out.print("minutes");
				break;
			}
		}
	}

	/* Read the input File and return the content as String */
	private void readFile(String fileName) throws IOException {
		String content = null;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				String[] tokens = line.split(" ");
				if(tokens.length == 1){
					//Initializing Registers
					registerArray = new Register[Integer.parseInt(tokens[0])];
					for(int i=0; i<registerArray.length; i++){
						registerArray[i] = new Register();
						registerArray[i].setNumber(i+1);
						registerArray[i].setNumOfCustInLine(0);
						registerArray[i].setTotalProcessingTime(0);
						if (i != registerArray.length - 1) {
							registerArray[i].setProcessingTime(1);
							registerArray[i].setRegisterInTraining(false);
						} else {
							registerArray[i].setProcessingTime(2);
							registerArray[i].setRegisterInTraining(true);
						}
					}
				} else {
					grocery.numOfCustomers++;
					sb.append(line);
					sb.append(System.lineSeparator());
				}
				line = br.readLine();
			}
			content = sb.toString();
			
			//Initializing Customers
			customerArray = new Customer[grocery.getNumOfCustomers()];
			String[] tokens = content.split(System.lineSeparator());
			for(int i=0; i<tokens.length; i++){
				String[] customer = tokens[i].split(" ");
				customerArray[i] = new Customer();
				customerArray[i].setType(customer[0]); 
				customerArray[i].setInTime(Integer.parseInt(customer[1]));
				customerArray[i].setNumOfItems(Integer.parseInt(customer[2]));
			}
		} finally {
			br.close();
		}
	}
	
	/**
	 * @return the grocery
	 */
	public static Grocery getGrocery() {
		return grocery;
	}

	/**
	 * @param grocery the grocery to set
	 */
	public static void setGrocery(Grocery grocery) {
		Grocery.grocery = grocery;
	}

	/**
	 * @return the numOfCustomers
	 */
	public int getNumOfCustomers() {
		return numOfCustomers;
	}

	/**
	 * @param numOfCustomers the numOfCustomers to set
	 */
	public void setNumOfCustomers(int numOfCustomers) {
		this.numOfCustomers = numOfCustomers;
	}

	/**
	 * @return the registerArray
	 */
	public static Register[] getRegisterArray() {
		return registerArray;
	}

	/**
	 * @param registerArray the registerArray to set
	 */
	public static void setRegisterArray(Register[] registerArray) {
		Grocery.registerArray = registerArray;
	}

	/**
	 * @return the customerArray
	 */
	public static Customer[] getCustomerArray() {
		return customerArray;
	}

	/**
	 * @param customerArray the customerArray to set
	 */
	public static void setCustomerArray(Customer[] customerArray) {
		Grocery.customerArray = customerArray;
	}
	
}
