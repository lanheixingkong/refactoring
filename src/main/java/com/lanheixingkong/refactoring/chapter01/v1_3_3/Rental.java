/**
 * 
 */
package com.lanheixingkong.refactoring.chapter01.v1_3_3;

import com.lanheixingkong.refactoring.chapter01.v1_1.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 租赁
 * 
 * @author: 谌磊
 * @date: 2018年8月16日 上午10:41:07
 * 
 */
@Data
@AllArgsConstructor
public class Rental {

	private Movie movie;
	private int daysRented;

	/**
	 * @param rental
	 * @return
	 */
	public double getCharge() {
		double result = 0.0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (getDaysRented() > 2) {
				result += (getDaysRented() - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (getDaysRented() > 3) {
				result += (getDaysRented() - 3) * 1.5;
			}
			break;
		}
		return result;
	}

	public int getFrequentRenterPoints() {
		if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
			return 2;
		}
		return 1;
	}
}
