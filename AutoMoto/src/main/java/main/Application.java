package main;

import java.sql.SQLException;

import dao.CategoryRepository;
import entities.Category;

public class Application {

	public static void main(String[] args) throws SQLException {

		// CREATE
//		Category testCat = new Category(101, "Test Category 2", 0);
//		CategoryRepository cr = new CategoryRepository();
//		cr.insert(testCat);
		
		// READ
//		CategoryRepository cr = new CategoryRepository();
//		Category foundCat = cr.read(100);
//		System.out.println(foundCat);
		
		// UPDATE 
//		CategoryRepository cr = new CategoryRepository();
//		cr.updateName(101,"asdasd");
		
		// DELETE
		CategoryRepository cr = new CategoryRepository();
		cr.deleteCategory(101);
		
	}

}
