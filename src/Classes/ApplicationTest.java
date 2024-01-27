package Classes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ApplicationTest {

	@Test
	public void test() {
		Product eco_tariff = new Rate(135.50, "Экономный");
		Product services1 = new AdditionalServices(500, "Уборка ванн и туалетов");
		Product services2 = new AdditionalServices(600, "Чистка ковров");
		
		List<Product> services = new ArrayList<>();
		services.add(services1);
		services.add(services2);
		
		Application newApplic = new Application(50, eco_tariff, services);
		double result = newApplic.Calculate();
		assertTrue("Неверно подсчитано значение суммы", result == 7875);
	}

}
