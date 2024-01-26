package Test;

import java.util.Arrays;

public class ArrayGenerator {
public int[] generateRandomArray() {
	RandomNumberGenerator rng = new RandomNumberGenerator();
	int[] array = new int[10];
	for (int i = 0; i < array.length; i++) {
	array[i] = rng.generateRandomNumber();
	}
	return array;
	}
}
