/**
 * 
 */
package com.lanheixingkong.refactoring.chapter01.v1_4_2;

/**
 * @author: 谌磊
 * @date: 2018年8月16日 上午11:55:54
 * 
 */
public class ChildrensPrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.CHILDRENS;
	}

	public double getCharge(int daysRented) {
		double result = 1.5;
		if (daysRented > 3) {
			result += (daysRented - 3) * 1.5;
		}
		return result;
	}
}
