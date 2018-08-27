/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.remove_assignments_to_parameters.v6_7_2;

/**
 * 移除对参数的赋值
 * 
 * 代码对一个参数进行赋值。 以一个临时变量取代该参数的位置。
 * 
 * @author: 谌磊
 * @date: 2018年8月17日 上午9:10:27
 * 
 */
public class RemoveAssignmentsToParameters {

	int discount(int inputVal, int quantity, int yearToDate) {
		if (inputVal > 50) {
			inputVal -= 2;
		}
		if (quantity > 100) {
			inputVal -= 1;
		}
		if (yearToDate > 10000) {
			inputVal -= 4;
		}
		return inputVal;
	}

	int discount1Step(int inputVal, int quantity, int yearToDate) {
		// 以临时变量取代参数的赋值动作
		int result = inputVal;
		if (inputVal > 50) {
			result -= 2;
		}
		if (quantity > 100) {
			result -= 1;
		}
		if (yearToDate > 10000) {
			result -= 4;
		}
		return result;
	}

	int discount2Step(final int inputVal, final int quantity, final int yearToDate) {
		// 还可以加上final确保参数不会被赋值
		int result = inputVal;
		if (inputVal > 50) {
			result -= 2;
		}
		if (quantity > 100) {
			result -= 1;
		}
		if (yearToDate > 10000) {
			result -= 4;
		}
		return result;
	}
}
