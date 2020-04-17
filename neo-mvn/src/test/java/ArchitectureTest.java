import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArchitectureTest {

	@Test
	void checkBothCLIandGUI() {
		try {

			Class.forName("main.CLIApplication");
			Class.forName("main.GUIApplication");

		} catch (ClassNotFoundException e) {
			fail("The Application doesn't have both GUI and CLI.");
		}

	}

	@Test
	void checkMethodMain() {
		try {

			Class.forName("main.CLIApplication").getMethod("main", String[].class);
			Class.forName("main.GUIApplication").getMethod("main", String[].class);

		} catch (ClassNotFoundException e) {
			fail("The Application doesn't have both GUI and CLI.");
		} catch (NoSuchMethodException e) {
			fail("The Application class doesn't have \"main()\" method.");
		} catch (SecurityException e) {

		}

	}

	@Test
	void checkAsteroidandDataProviderClass() {
		try {

			Class.forName("space.Asteroid");
			Class.forName("space.NasaDataProvider");

		} catch (ClassNotFoundException e) {
			fail("The package \"space\" doesn't have both classes Asteroid and NasaDataProvider.");
		}

	}

}
