/**
 * 
 */
package com.lanheixingkong.refactoring.chapter01.v1_1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * 影片
 * 
 * @author: 谌磊
 * @date: 2018年8月16日 上午10:36:19
 * 
 */
@Data
@AllArgsConstructor
public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String title;
	private int priceCode;
	
}
