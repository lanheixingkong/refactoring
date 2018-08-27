/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.replace_temp_with_query.v6_4_1;

/**
 * 以查询取代临时变量
 * 
 * 你的程序以一个临时变量保存某一表达式的运算结果。 
 * 将这个表达式提炼到一个独立函数中。将这个临时变量的所有引用点替换为对新函数的调用。
 * 此后，新函数就可被其他函数使用。
 * 
 * @author: 谌磊
 * @date: 2018年8月16日 下午3:50:57
 * 
 */
public class ReplaceTempWithQuery {

	private int quantity;
	private int itemPrice;

	double test() {
		double basePrice = quantity * itemPrice;
		if (basePrice > 1000) {
			return basePrice * 0.95;
		} else {
			return basePrice * 0.98;
		}
	}

	double newTest() {
		if (basePrice() > 1000) {
			return basePrice() * 0.95;
		} else {
			return basePrice() * 0.98;
		}
	}

	double basePrice() {
		return quantity * itemPrice;
	}
}
