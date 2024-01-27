package Test;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayGeneratorTest {
		private static ArrayGenerator arrayGenerator;
		
		@BeforeClass
		public static void init() {
		arrayGenerator = new ArrayGenerator();
		}
		
		@Test
		public void testGenerateRandomArray() {
		int[] randomArray = arrayGenerator.generateRandomArray();
		
		assertEquals(10, randomArray.length);
		
		for (int value : randomArray) {
		assertNotNull(value);
		}
	}
}