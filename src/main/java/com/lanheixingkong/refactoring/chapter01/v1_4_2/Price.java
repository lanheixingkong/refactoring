/**
 * 
 */
package com.lanheixingkong.refactoring.chapter01.v1_4_2;

/**
 * @author: 谌磊
 * @date: 2018年8月16日 上午11:54:48
 * 
 */
public abstract class Price {

	abstract int getPriceCode();

	abstract double getCharge(int daysRented);

	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
}
