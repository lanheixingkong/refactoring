/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.replace_method_with_method_object.v6_8_2;

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

	class Account {
		int gamma(int inputVal, int quantity, int yearToDate) {
			int importantValue1 = (inputVal * quantity) + delta();
			int importantValue2 = (inputVal * yearToDate) + 100;
			if ((yearToDate - importantValue1) > 100) {
				importantValue2 -= 20;
			}

			int importantValue3 = importantValue2 * 7;
			// and so on

			return importantValue3 - 2 * importantValue1;
		}

		int newGamma(int inputVal, int quantity, int yearToDate) {
			// 将旧函数委派给函数对象执行
			return new Gamma(this, inputVal, quantity, yearToDate).compute();
		}

		/**
		 * @return
		 */
		private int delta() {
			return 0;
		}
	}

	class Gamma {
		// 源对象fianl修饰
		private final Account account;
		// 源方法中的参数和临时变量做为Field
		private int inputVal;
		private int quantity;
		private int yearToDate;
		private int importantValue1;
		private int importantValue2;
		private int importantValue3;

		// 构造方法传入源对象和源方法的参数
		Gamma(Account account, int inputVal, int quantity, int yearToDate) {
			this.account = account;
			this.inputVal = inputVal;
			this.quantity = quantity;
			this.yearToDate = yearToDate;
		}

		int compute() {
			// 源方法搬入compute()中，调用源对象中方法的地方，都改为使用源对象来调用
			int importantValue1 = (inputVal * quantity) + account.delta();
			int importantValue2 = (inputVal * yearToDate) + 100;
			if ((yearToDate - importantValue1) > 100) {
				importantValue2 -= 20;
			}

			int importantValue3 = importantValue2 * 7;
			// and so on

			return importantValue3 - 2 * importantValue1;
		}
	}

	class NewGamma {
		// 源对象fianl修饰
		private final Account account;
		// 源方法中的参数和临时变量做为Field
		private int inputVal;
		private int quantity;
		private int yearToDate;
		private int importantValue1;
		private int importantValue2;
		private int importantValue3;

		// 构造方法传入源对象和源方法的参数
		NewGamma(Account account, int inputVal, int quantity, int yearToDate) {
			this.account = account;
			this.inputVal = inputVal;
			this.quantity = quantity;
			this.yearToDate = yearToDate;
		}

		int compute() {
			// 源方法搬入compute()中，调用源对象中方法的地方，都改为使用源对象来调用
			int importantValue1 = (inputVal * quantity) + account.delta();
			int importantValue2 = (inputVal * yearToDate) + 100;
			importantThing();

			int importantValue3 = importantValue2 * 7;
			// and so on

			return importantValue3 - 2 * importantValue1;
		}

		void importantThing() {
			// 可以使用其他方法来重构compute()
			if ((yearToDate - importantValue1) > 100) {
				importantValue2 -= 20;
			}
		}
	}
}
