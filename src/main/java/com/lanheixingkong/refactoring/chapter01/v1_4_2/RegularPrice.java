/**
 * 
 */
package com.lanheixingkong.refactoring.chapter01.v1_4_2;

/**
 * @author: 谌磊
 * @date: 2018年8月16日 上午11:55:54
 * 
 */
public class RegularPrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.REGULAR;
	}

	public double getCharge(int daysRented) {
		double result = 2;
		if (daysRented > 2) {
			result += (daysRented - 2) * 1.5;
		}
		return result;
	}

}
