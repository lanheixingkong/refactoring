/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.split_temporary_variable.v6_6_1;

/**
 * 分解临时变量
 * 
 * 你的程序有某个临时变量被赋值超过一次，它既不是循环变量，也不被用于收集计算结果。 针对每次赋值，创造一个独立、对应的临时变量。
 * 
 * @author: 谌磊
 * @date: 2018年8月17日 上午8:54:02
 * 
 */
public class SplitTemporaryVariable {

	private int height;
	private int width;

	void test() {
		double temp = 2 * (height + width);
		System.out.println(temp);
		temp = height * width;
		System.out.println(temp);
	}

	void newTest() {
		final double perimeter = 2 * (height + width);
		System.out.println(perimeter);
		final double area = height * width;
		System.out.println(area);
	}
}
