import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Test;

import config.XMLConfigurationProvider;

class NasaProviderTest {

	@Test
	void checkURLConnection() {

		String link = new XMLConfigurationProvider().getValue("url") + new XMLConfigurationProvider().getValue("key");

		try {

			URL url = new URL(link);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.connect();

			assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
		} catch (UnknownHostException e) {
			fail("No internet connection.");
		} catch (MalformedURLException e) {
			fail("Error connecting to site");
		} catch (IOException e) {
			fail("Error connecting to site");
		}

	}

}
