package Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomNumberGeneratorTest {

	@Test
	public void testGenerateRandomNumberInRange() {
		RandomNumberGenerator rng = new RandomNumberGenerator();
		int randomNum = rng.generateRandomNumber();
		assertTrue("Сгенерированное число вне диапазона", randomNum >= 100 && randomNum <= 700);
	}
}
