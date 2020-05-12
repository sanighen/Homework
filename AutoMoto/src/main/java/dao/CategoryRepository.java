package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import entities.Category;

public class CategoryRepository {

	public Connection getConnection() throws SQLException {

		String url = "jdbc:postgresql://localhost/auto-moto";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "admin");
		props.setProperty("ssl", "false");

		Connection conn = DriverManager.getConnection(url, props);

		return conn;

	}

	// INSERT
	public void insert(Category category) throws SQLException {
		PreparedStatement pst = getConnection().prepareStatement("INSERT INTO categories(id, name) VALUES (?, ?);");
		pst.setLong(1, category.getId());
		pst.setString(2, category.getName());
		pst.execute();
	}

	// SELECT
	public Category select(long id) throws SQLException {

		Statement st = getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM categories WHERE id= " + id + ";");

		Category newCat = null;

		if (rs.next()) {
			newCat = new Category();
			newCat.setName(rs.getString("name"));
		}

		return newCat;

	}

	// UPDATE
	public void updateName(long id, String name) throws SQLException {
		getConnection().createStatement();
		PreparedStatement pst = getConnection().prepareStatement("UPDATE categories SET name=? WHERE id=" + id + ";");
		pst.setString(1, name);
		pst.executeUpdate();
	}

	// DELETE
	public void deleteCategory(long id) throws SQLException {
		getConnection().createStatement();
		PreparedStatement pst = getConnection().prepareStatement("DELETE FROM categories WHERE id=" + id + ";");
		pst.executeUpdate();

	}

}
