package main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryRepository;
import db.ReadSQLFile;
import entities.Category;

public class Application {

	public static void main(String[] args) throws SQLException, IOException {
		
		// CREATE
//		Category testCat = new Category(105, "Test category", 0);
//		CategoryRepository cr = new CategoryRepository();
//		cr.create(testCat);
		
		// READ
//		CategoryRepository cr = new CategoryRepository();
//		cr.findAll();
		
//		CategoryRepository cr = new CategoryRepository();
//		Category cat = new Category(0,"", 1);
//		cr.findAllByParent(cat);
		
		// UPDATE 
//		CategoryRepository cr = new CategoryRepository();
//		Category cat = new Category(103,"Test", 0);
//		cr.update(cat);
		
		// DELETE
		CategoryRepository cr = new CategoryRepository();
		Category cat = new Category(102,"", 0);
		Category cat2 = new Category(105,"", 0);
		cr.delete(cat);
		cr.delete(cat2);
		
	}

}
