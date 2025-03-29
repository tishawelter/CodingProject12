package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else
			throw new IllegalArgumentException("Both parameters must be positive");
	}
	
	// this method finds the average of an array of numbers
	public double findAverage(double[] numbers) {
		double sum = 0;
		for (double number : numbers) {
			sum += number;
		}
		return sum / numbers.length;
	}
	
	public int randomNumberSquared() {
		int randomNumber = getRandomInt();
		return randomNumber * randomNumber;
	}
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
}