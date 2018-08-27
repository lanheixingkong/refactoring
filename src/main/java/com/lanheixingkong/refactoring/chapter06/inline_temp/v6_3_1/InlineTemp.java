/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.inline_temp.v6_3_1;

/**
 * 内联临时变量
 * 
 * 你有一个临时变量，只被一个简单表达式赋值一次，而它妨碍了其他重构手法。 
 * 将所有对该变量的引用动作，替换为对它赋值的那个表达式自身
 * 
 * @author: 谌磊
 * @date: 2018年8月16日 下午3:44:28
 * 
 */
public class InlineTemp {
	private Order anOrder = new Order();

	boolean test() {
		double basePrice = anOrder.getBasePrice();
		return basePrice > 1000;
	}

	boolean newTest() {
		return anOrder.getBasePrice() > 1000;
	}

	class Order {
		private double basePrice;

		public double getBasePrice() {
			return basePrice;
		}
	}
}
