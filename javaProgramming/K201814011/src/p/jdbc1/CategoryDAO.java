package p.jdbc1;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.util.ArrayList; 
import java.util.List; 
import p.DB;
import p.jdbc1.Category; 

public class CategoryDAO {
	public static List<Category> findAll() throws Exception {       
		String sql = "SELECT * FROM category";      
		try (Connection connection = DB.getConnection("book3");         
				PreparedStatement statement = connection.prepareStatement(sql);    
				ResultSet resultSet = statement.executeQuery()) {      
			ArrayList<Category> list = new ArrayList<Category>();  
			
			while (resultSet.next()) {         
				Category category = new Category();        
				category.setId(resultSet.getInt("id"));               
				category.setCategoryName(resultSet.getString("categoryName"));  
				list.add(category);            
				}            
			return list;       
			}    
		}
	public static void insert(Category category) throws Exception {        
		String sql = "INSERT Category (categoryName) VALUES (?)";        
		try (Connection connection = DB.getConnection("book3");            
				PreparedStatement statement = connection.prepareStatement(sql)) {        
			statement.setString(1, category.getCategoryName());          
			statement.executeUpdate();      
			}   
		}

}
