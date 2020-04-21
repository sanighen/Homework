package config;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.io.InputStream;

public class XMLConfigurationProvider {

	public String getValue(String keyName) {

		ClassLoader classLoader = getClass().getClassLoader();
		String value = null;

		try (InputStream inputStream = classLoader.getResourceAsStream("nasa.xml")) {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xmlDoc = builder.parse(inputStream);
			Node key = xmlDoc.getElementsByTagName(keyName).item(0);
			Element eKey = (Element) key;
			value = eKey.getAttribute("value");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		return value;

	}

}
