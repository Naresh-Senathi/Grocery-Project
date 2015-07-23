/**
 * 
 */
package com.wellaware.grocery;

/**
 * @author Naresh Kumar
 *
 */
public class Customer {
	private String type;
	private int inTime;
	private int numOfItems;
	private int processingTime;
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the inTime
	 */
	public int getInTime() {
		return inTime;
	}
	/**
	 * @param inTime the inTime to set
	 */
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	/**
	 * @return the numOfItems
	 */
	public int getNumOfItems() {
		return numOfItems;
	}
	/**
	 * @param numOfItems the numOfItems to set
	 */
	public void setNumOfItems(int numOfItems) {
		this.numOfItems = numOfItems;
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
	
}
