/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.replace_temp_with_query.v6_4_2;

/**
 * 以查询取代临时变量
 * 
 * 你的程序以一个临时变量保存某一表达式的运算结果。 将这个表达式提炼到一个独立函数中。将这个临时变量的所有引用点替换为对新函数的调用。
 * 此后，新函数就可被其他函数使用。
 * 
 * @author: 谌磊
 * @date: 2018年8月16日 下午3:50:57
 * 
 */
public class ReplaceTempWithQuery {

	private int quantity;
	private int itemPrice;

	double getPrice() {
		double basePrice = quantity * itemPrice;
		double discountFactor;
		if (basePrice > 1000) {
			discountFactor = 0.95;
		} else {
			discountFactor = 0.98;
		}
		return basePrice * discountFactor;
	}

	double getPrice1Step() {
		// 将临时变量变成final，检查它们是否的确只被赋值一次
		final double basePrice = quantity * itemPrice;
		final double discountFactor;
		if (basePrice > 1000) {
			discountFactor = 0.95;
		} else {
			discountFactor = 0.98;
		}
		return basePrice * discountFactor;
	}

	double getPrice2Step() {
		// 替换临时变量，把赋值的右侧表达式提炼出来
		final double basePrice = basePrice();
		final double discountFactor;
		if (basePrice > 1000) {
			discountFactor = 0.95;
		} else {
			discountFactor = 0.98;
		}
		return basePrice * discountFactor;
	}

	double getPrice3Step() {
		// 把临时变量的引用点替换掉，删除临时变量
		final double discountFactor;
		if (basePrice() > 1000) {
			discountFactor = 0.95;
		} else {
			discountFactor = 0.98;
		}
		return basePrice() * discountFactor;
	}

	double getPrice4Step() {
		// 替换另外一个临时变量
		return basePrice() * discountFactor();
	}

	double basePrice() {
		return quantity * itemPrice;
	}

	double discountFactor() {
		return basePrice() > 1000 ? 0.95 : 0.98;
	}
}
