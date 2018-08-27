/**
 * 
 */
package com.lanheixingkong.refactoring.chapter01.v1_3_1;

import java.util.Vector;

import com.lanheixingkong.refactoring.chapter01.v1_1.Movie;
import com.lanheixingkong.refactoring.chapter01.v1_1.Rental;

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
			double thisAmount = amountFor(each);

			frequentRenterPoints++;
			if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1) {
				frequentRenterPoints++;
			}

			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}

		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";

		return result;
	}

	/**
	 * @param rental
	 * @return
	 */
	private double amountFor(Rental rental) {
		double result = 0.0;
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (rental.getDaysRented() > 2) {
				result += (rental.getDaysRented() - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += rental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (rental.getDaysRented() > 3) {
				result += (rental.getDaysRented() - 3) * 1.5;
			}
			break;
		}
		return result;
	}
}
