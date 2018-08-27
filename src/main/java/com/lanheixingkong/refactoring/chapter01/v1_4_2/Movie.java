/**
 * 
 */
package com.lanheixingkong.refactoring.chapter01.v1_4_2;

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
public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	private Price price;

	public Movie(String title, int priceCode) {
		this.title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return price.getPriceCode();
	}

	public void setPriceCode(int priceCode) {
		switch (priceCode) {
		case Movie.REGULAR:
			price = new RegularPrice();
			break;
		case Movie.NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		case Movie.CHILDRENS:
			price = new ChildrensPrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect price code");
		}
	}

	public double getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}
}
