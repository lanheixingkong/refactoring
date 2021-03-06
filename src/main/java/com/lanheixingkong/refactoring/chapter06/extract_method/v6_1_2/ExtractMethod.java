/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.extract_method.v6_1_2;

import java.util.List;

import com.google.common.collect.Lists;

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
	private String name = "Hello world";
	private List<Order> orders = Lists.newArrayList();

	void printOwing() {
		double outstanding = 0.0;

		// print banner
		System.out.println("**************************");
		System.out.println("****** Customer Owes *****");
		System.out.println("**************************");

		// calculate outstanding
		for (Order each : orders) {
			outstanding += each.getAmount();
		}

		// print details
		System.out.println("name:" + name);
		System.out.println("amount:" + outstanding);
	}

	void newPrintOwing() {
		// print banner
		printBanner();

		// calculate outstanding
		double outstanding = getOutstanding();

		// print details
		printDetails(outstanding);
	}

	private void printBanner() {
		// 无局部变量，直接移入
		System.out.println("**************************");
		System.out.println("****** Customer Owes *****");
		System.out.println("**************************");
	}

	private void printDetails(double outstanding) {
		// 有局部变量，只是读取不做修改，将局部变量直接作为参数传入
		System.out.println("name:" + name);
		System.out.println("amount:" + outstanding);
	}

	private double getOutstanding() {
		//outstanding在原函数中只是默认初始化，直接放入新函数中默认初始化
		double result = 0.0;
		for (Order each : orders) {
			result += each.getAmount();
		}
		return result;
	}

	class Order {
		double getAmount() {
			return 1.0;
		}
	}
}
