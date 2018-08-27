/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.introduce_explaining_variable.v6_5_2;

/**
 * 引入解释性变量
 * 
 * 你有一个复杂的表达式。 将该复杂表达式（或其中一部分）的结果放进一个临时变量， 以此变量名称来解释表达式用途。
 * 
 * @author: 谌磊
 * @date: 2018年8月16日 下午4:26:35
 * 
 */
public class IntroduceExplainingVariable {

	private int quantity;
	private int itemPrice;

	double price() {
		// price is base price - quantity discount + shipping
		return quantity * itemPrice - Math.max(0, quantity - 500) * itemPrice * 0.05
				+ Math.min(quantity * itemPrice * 0.1, 100.0);
	}

	double price1Step() {
		// price is base price - quantity discount + shipping
		final double basePrice = quantity * itemPrice;
		return basePrice - Math.max(0, quantity - 500) * itemPrice * 0.05 + Math.min(basePrice * 0.1, 100.0);
	}

	double price2Step() {
		// price is base price - quantity discount + shipping
		final double basePrice = quantity * itemPrice;
		final double quantityDiscount = Math.max(0, quantity - 500) * itemPrice * 0.05;
		return basePrice - quantityDiscount + Math.min(basePrice * 0.1, 100.0);
	}

	double price3Step() {
		// price is base price - quantity discount + shipping
		final double basePrice = quantity * itemPrice;
		final double quantityDiscount = Math.max(0, quantity - 500) * itemPrice * 0.05;
		final double shipping = Math.min(basePrice * 0.1, 100.0);
		return basePrice - quantityDiscount + shipping;
	}
}
