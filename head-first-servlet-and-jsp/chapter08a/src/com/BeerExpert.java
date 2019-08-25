package com;

public class BeerExpert {
	public static String selectBeerByColor(String color) {
		if (color.equals("light")) {
			return "White Wine";
		}
		else if (color.equals("normal")) {
			return "Grape Wine";
		}
		else return "Red Wine";
	}
}
