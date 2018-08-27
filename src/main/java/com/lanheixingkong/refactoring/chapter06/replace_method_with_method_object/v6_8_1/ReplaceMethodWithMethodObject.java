/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.replace_method_with_method_object.v6_8_1;

/**
 * 以函数对象取代函数
 * 
 * 你有一个大型函数， 其中对局部变量的使用使你无法采用Extract Method。 将这个函数放进一个单独对象中，如此一来局部变量就成了对象内的字段。
 * 然后你可以在同一个对象中将这个大型函数分解为多个小型函数。
 * 
 * @author: 谌磊
 * @date: 2018年8月17日 上午9:34:29
 * 
 */
public class ReplaceMethodWithMethodObject {

	class Order {
		double price() {
			double primaryBasePrice;
			double secondeBasePrice;
			double tertiaryBasePrice;
			// long computation;
			// TODO
			
			return 0;
		}
	}
}
