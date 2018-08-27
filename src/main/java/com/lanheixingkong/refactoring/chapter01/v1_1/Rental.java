/**
 * 
 */
package com.lanheixingkong.refactoring.chapter01.v1_1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 租赁
 * 
 * @author: 谌磊
 * @date: 2018年8月16日 上午10:41:07
 * 
 */
@Data
@AllArgsConstructor
public class Rental {

	private Movie movie;
	private int daysRented;
}
