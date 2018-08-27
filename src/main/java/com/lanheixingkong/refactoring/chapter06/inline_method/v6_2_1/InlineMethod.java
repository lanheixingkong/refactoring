/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.inline_method.v6_2_1;

/**
 * 内联函数
 * 
 * 一个函数的本体与名称同样清楚易懂 在函数调用点插入函数本体，然后移除该函数
 * 
 * @author: 谌磊
 * @date: 2018年8月16日 下午3:27:33
 * 
 */
public class InlineMethod {
	private int numberOfLateDeliveries = 0;

	int getRating() {
		return (moreThanFiveLateDeliveries()) ? 2 : 1;
	}

	private boolean moreThanFiveLateDeliveries() {
		return numberOfLateDeliveries > 5;
	}

	int newGetRating() {
		return (numberOfLateDeliveries > 5) ? 2 : 1;
	}
}
