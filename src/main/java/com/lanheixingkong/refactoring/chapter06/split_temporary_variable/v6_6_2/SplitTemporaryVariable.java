/**
 * 
 */
package com.lanheixingkong.refactoring.chapter06.split_temporary_variable.v6_6_2;

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

	private int primaryForce;
	private int mass;
	private int delay;
	private int secondaryForce;

	double getDistanceTravelled(int time) {
		double result = 0.0;

		double acc = primaryForce / mass;
		int primaryTime = Math.min(time, delay);
		result = 0.5 * acc * primaryTime * primaryTime;

		int secondaryTime = time - delay;
		if (secondaryTime > 0) {
			double primaryVel = acc * delay;
			acc = (primaryForce + secondaryForce) / mass;
			result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
		}

		return result;
	}

	double getDistanceTravelled1Step(int time) {
		// 将第一次赋值改名变为final，修改第二次赋值前引用点名称
		double result = 0.0;

		final double primaryAcc = primaryForce / mass;
		int primaryTime = Math.min(time, delay);
		result = 0.5 * primaryAcc * primaryTime * primaryTime;

		int secondaryTime = time - delay;
		if (secondaryTime > 0) {
			double primaryVel = primaryAcc * delay;
			double acc = (primaryForce + secondaryForce) / mass;
			result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
		}

		return result;
	}

	double getDistanceTravelled2Step(int time) {
		// 重复第一次的操作修改第二个赋值
		double result = 0.0;

		final double primaryAcc = primaryForce / mass;
		int primaryTime = Math.min(time, delay);
		result = 0.5 * primaryAcc * primaryTime * primaryTime;

		int secondaryTime = time - delay;
		if (secondaryTime > 0) {
			double primaryVel = primaryAcc * delay;
			final double secondaryAcc = (primaryForce + secondaryForce) / mass;
			result += primaryVel * secondaryTime + 0.5 * secondaryAcc * secondaryTime * secondaryTime;
		}

		return result;
	}
}
