package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import config.XMLConfigurationProvider;

public class PostgresConnectionManager {
	
	private static String user = new XMLConfigurationProvider().getValue("user");
	private static String pass = new XMLConfigurationProvider().getValue("password");
	private static String ssl = new XMLConfigurationProvider().getValue("ssl");
	
	public static Connection getConnection() throws SQLException {

		String url = "jdbc:postgresql://localhost/auto-moto";
		Properties props = new Properties();
		props.setProperty("user", user);
		props.setProperty("password", pass);
		props.setProperty("ssl", ssl);

		Connection conn = DriverManager.getConnection(url, props);

		return conn;

	}

}
