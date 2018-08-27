/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.introduce_explaining_variable.v6_5_1;

/**
 * 引入解释性变量
 * 
 * 你有一个复杂的表达式。 将该复杂表达式（或其中一部分）的结果放进一个临时变量， 以此变量名称来解释表达式用途。
 * 
 * @author: 谌磊
 * @date: 2018年8月16日 下午4:26:35
 * 
 */
public class IntroduceExplainingVariable {
	private String platform = "";
	private String browser = "";
	private int resize = 0;

	void test() {
		if (platform.toUpperCase().indexOf("MAC") > -1 && browser.toUpperCase().indexOf("IE") > -1 && wasInitialized()
				&& resize > 0) {
			// TODO
		}
	}

	void newTest() {
		final boolean isMacOS = platform.toUpperCase().indexOf("MAC") > -1;
		final boolean isIEBrowser = browser.toUpperCase().indexOf("IE") > -1;
		final boolean wasResized = resize > 0;
		if (isMacOS && isIEBrowser && wasInitialized() && wasResized) {
			// TODO
		}
	}

	private boolean wasInitialized() {
		// TODO Auto-generated method stub
		return false;
	}
}
