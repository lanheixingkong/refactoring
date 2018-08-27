/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.remove_assignments_to_parameters.v6_7_1;

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

		// TODO
		return inputVal;
	}
	
	int newDiscount(int inputVal, int quantity, int yearToDate) {
		int result = inputVal;
		if (inputVal > 50) {
			result -= 2;
		}
		
		// TODO
		return result;
	}
}
