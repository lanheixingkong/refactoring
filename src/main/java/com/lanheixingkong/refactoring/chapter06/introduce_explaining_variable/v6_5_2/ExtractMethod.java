/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.introduce_explaining_variable.v6_5_2;

/**
 * @author: 谌磊
 * @date: 2018年8月16日 下午4:48:43
 * 
 */
public class ExtractMethod {

	private int quantity;
	private int itemPrice;

	double price() {
		// price is base price - quantity discount + shipping
		return quantity * itemPrice - Math.max(0, quantity - 500) * itemPrice * 0.05
				+ Math.min(quantity * itemPrice * 0.1, 100.0);
	}

	double newPrice() {
		// price is base price - quantity discount + shipping
		return basePrice() - quantityDiscount() + shipping();
	}

	private double basePrice() {
		return quantity * itemPrice;
	}

	private double quantityDiscount() {
		return Math.max(0, quantity - 500) * itemPrice * 0.05;
	}

	private double shipping() {
		return Math.min(basePrice() * 0.1, 100.0);
	}
}
