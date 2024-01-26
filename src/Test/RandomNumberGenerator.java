package Test;

import java.util.Random;

public class RandomNumberGenerator {
	public int generateRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(601) + 100;
		return randomNumber;
	}

	public static void main(String[] args) {
		RandomNumberGenerator rng = new RandomNumberGenerator();
		int randomNum = rng.generateRandomNumber();
		System.out.println("Случайное число: " + randomNum);
	}
}
