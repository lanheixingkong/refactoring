/**
 * 
 */
package com.lanheixingkong.refactoring.chapter01.v1_4_1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * 影片
 * 
 * @author: 谌磊
 * @date: 2018年8月16日 上午10:36:19
 * 
 */
@Data
@AllArgsConstructor
public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	private int priceCode;

	public double getCharge(int daysRented) {
		double result = 0.0;
		switch (this.priceCode) {
		case Movie.REGULAR:
			result += 2;
			if (daysRented > 2) {
				result += (daysRented - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (daysRented > 3) {
				result += (daysRented - 3) * 1.5;
			}
			break;
		}
		return result;
	}

	public int getFrequentRenterPoints(int daysRented) {
		if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
			return 2;
		}
		return 1;
	}
}
