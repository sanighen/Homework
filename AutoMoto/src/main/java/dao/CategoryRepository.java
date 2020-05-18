package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.PostgresConnectionManager;
import db.ReadSQLFile;
import entities.Category;

public class CategoryRepository {

	private List<Category> list = new ArrayList<>();

	public Category find(long id) throws SQLException, IOException {
		PreparedStatement pst = PostgresConnectionManager.getConnection().prepareStatement(ReadSQLFile.getText("find"));
		pst.setLong(1, id);
		ResultSet rs = pst.executeQuery();
		Category newCat = null;
		if (rs.next()) {
			newCat = new Category();
			newCat.setId(rs.getLong("id"));
			newCat.setName(rs.getString("name"));
			newCat.setParent_category_id(rs.getLong("parent_category_id"));
		}
		System.out.println(newCat);
		return newCat;
	}

	public List<Category> findAll() throws SQLException, IOException {
		Statement st = PostgresConnectionManager.getConnection().createStatement();
		ResultSet rs = st.executeQuery(ReadSQLFile.getText("findAll"));
		Category newCat = null;
		while (rs.next()) {
			newCat = new Category();
			newCat.setId(rs.getLong("id"));
			newCat.setName(rs.getString("name"));
			newCat.setParent_category_id(rs.getLong("parent_category_id"));
			list.add(newCat);
		}
		for (Category l : list) {
			System.out.println(l);
		}
		return list;
	}

	public List<Category> findAllByParent(Category category) throws SQLException, IOException {
		PreparedStatement pst = PostgresConnectionManager.getConnection().prepareStatement(ReadSQLFile.getText("findAllByParent"));
		long parent_id = category.getParent_category_id();
		pst.setLong(1, parent_id);
		ResultSet rs = pst.executeQuery();
		category = null;
		while (rs.next()) {
			category = new Category();
			category.setId(rs.getLong("id"));
			category.setName(rs.getString("name"));
			category.setParent_category_id(rs.getLong("parent_category_id"));
			list.add(category);
		}
		for (Category l : list) {
			System.out.println(l);
		}
		return list;
	}

	public boolean create(Category category) throws SQLException, IOException {
		PreparedStatement pst = PostgresConnectionManager.getConnection().prepareStatement(ReadSQLFile.getText("create"));
		pst.setLong(1, category.getId());
		pst.setString(2, category.getName());
		return pst.execute();
	}

	public boolean update(Category category) throws SQLException, IOException {
		PreparedStatement pst = PostgresConnectionManager.getConnection().prepareStatement(ReadSQLFile.getText("update"));
		pst.setString(1, category.getName());
		pst.setLong(2, category.getId());
		pst.executeUpdate();
		return true;
	}

	public boolean delete(Category category) throws SQLException, IOException {
		PreparedStatement pst = PostgresConnectionManager.getConnection().prepareStatement(ReadSQLFile.getText("delete"));
		pst.setLong(1, category.getId());
		return pst.execute();
	}

	public boolean save(Category category) throws SQLException {
		return false;
	}

}
