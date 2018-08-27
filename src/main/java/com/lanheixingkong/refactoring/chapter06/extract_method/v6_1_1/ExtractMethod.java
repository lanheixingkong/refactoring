/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.extract_method.v6_1_1;

/**
 * 提炼函数
 * 
 * 你有一段可以被组织在一起并独立出来
 * 将这段代码放进一个独立函数中，并让函数名称解释该函数的用途
 * 
 * @author: 谌磊
 * @date: 2018年8月16日 下午2:43:33
 * 
 */
public class ExtractMethod {
	private String name;

	void printOwing(double amount) {
		printBanner();

		// print details
		System.out.println("name:" + name);
		System.out.println("amount:" + amount);
	}

	void newPrintOwing(double amount) {
		printBanner();
		printDetails(amount);
	}

	/**
	 * @param amount
	 */
	private void printDetails(double amount) {
		System.out.println("name:" + name);
		System.out.println("amount:" + amount);
	}

	/**
	 * 
	 */
	private void printBanner() {
		// TODO
	}
}
