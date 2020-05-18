package db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadSQLFile {

	public static String getText(String fileName) throws IOException {

		ClassLoader classLoader = ReadSQLFile.class.getClassLoader();
		try {
			InputStream inputStream = classLoader.getResourceAsStream("sql/" + fileName + ".sql");
			Scanner reader = new Scanner(inputStream);
			String data = "";
			while (reader.hasNextLine()) {
				data += reader.nextLine();
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;

	}

}
