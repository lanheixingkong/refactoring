/**
 * 
 */
package com.lanheixingkong.refactoring.chapter01.v1_3_3;

import java.util.Vector;

import lombok.Data;

/**
 * 顾客
 * 
 * @author: 谌磊
 * @date: 2018年8月16日 上午10:42:09
 * 
 */
@Data
public class Customer {

	private String name;
	private Vector<Rental> rentals = new Vector<Rental>();

	public void addRental(Rental rental) {
		this.rentals.addElement(rental);
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		for (Rental each : rentals) {
			frequentRenterPoints += each.getFrequentRenterPoints();
			
			result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
			totalAmount += each.getCharge();
		}

		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";

		return result;
	}

}
