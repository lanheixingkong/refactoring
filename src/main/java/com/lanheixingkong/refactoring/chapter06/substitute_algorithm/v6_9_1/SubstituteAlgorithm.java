/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.substitute_algorithm.v6_9_1;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 替换算法
 * 
 * 你想要把某个算法替换为另一个更清晰的算法。 将函数体替换为另一个算法。
 * 
 * @author: 谌磊
 * @date: 2018年8月17日 上午10:08:16
 * 
 */
public class SubstituteAlgorithm {

	String foundPerson(String[] people) {
		for (int i = 0; i < people.length; i++) {
			if (people[i].equals("Don")) {
				return "Don";
			}
			if (people[i].equals("John")) {
				return "John";
			}
			if (people[i].equals("Kent")) {
				return "Kent";
			}
		}
		return "";
	}

	String newFoundPerson(String[] people) {
		List<String> candidates = Lists.newArrayList("Don", "John", "Kent");
		for (int i = 0; i < people.length; i++) {
			if (candidates.contains(people[i])) {
				return people[i];
			}
		}
		return "";
	}
}
