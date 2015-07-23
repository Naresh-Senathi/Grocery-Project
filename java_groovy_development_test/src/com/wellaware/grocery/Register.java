/**
 * 
 */
package com.wellaware.grocery;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Naresh Kumar
 *
 */
public class Register {
	private boolean registerInTraining;
	private int processingTime;
	private int numOfCustInLine;
	private int number;
	private int totalProcessingTime;
	private LinkedList<Customer> CustomerQueue; 
	
	public Register(){
		CustomerQueue = new LinkedList<Customer>();
	}
	/**
	 * @return the registerInTraining
	 */
	public boolean isRegisterInTraining() {
		return registerInTraining;
	}
	/**
	 * @param registerInTraining the registerInTraining to set
	 */
	public void setRegisterInTraining(boolean registerInTraining) {
		this.registerInTraining = registerInTraining;
	}
	/**
	 * @return the processingTime
	 */
	public int getProcessingTime() {
		return processingTime;
	}
	/**
	 * @param processingTime the processingTime to set
	 */
	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}
	/**
	 * @return the numOfCustInLine
	 */
	public int getNumOfCustInLine() {
		return numOfCustInLine;
	}
	/**
	 * @param numOfCustInLine the numOfCustInLine to set
	 */
	public void setNumOfCustInLine(int numOfCustInLine) {
		this.numOfCustInLine = numOfCustInLine;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the customerQueue
	 */
	public LinkedList<Customer> getCustomerQueue() {
		return CustomerQueue;
	}
	/**
	 * @param customerQueue the customerQueue to set
	 */
	public void setCustomerQueue(LinkedList<Customer> customerQueue) {
		CustomerQueue = customerQueue;
	}
	/**
	 * @return the totalProcessingTime
	 */
	public int getTotalProcessingTime() {
		return totalProcessingTime;
	}
	/**
	 * @param totalProcessingTime the totalProcessingTime to set
	 */
	public void setTotalProcessingTime(int totalProcessingTime) {
		this.totalProcessingTime = totalProcessingTime;
	}
	
}
