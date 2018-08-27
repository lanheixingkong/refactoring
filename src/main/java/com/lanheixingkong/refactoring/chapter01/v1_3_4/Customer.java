/**
 * 
 */
package com.lanheixingkong.refactoring.chapter01.v1_3_4;

import java.util.Vector;

import com.lanheixingkong.refactoring.chapter01.v1_3_3.Rental;

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

		String result = "Rental Record for " + getName() + "\n";
		for (Rental each : rentals) {

			result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
		}

		result += "Amount owed is " + getTotalAmount() + "\n";
		result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

		return result;
	}

	private double getTotalAmount() {
		double totalAmount = 0;
		for (Rental each : rentals) {
			totalAmount += each.getCharge();
		}
		return totalAmount;
	}

	private int getTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental each : rentals) {
			frequentRenterPoints += each.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}
}
