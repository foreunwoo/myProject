package p.jdbc1;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List;

import p.DB;

public class BookDAO {
	private static Book getBookFrom(ResultSet resultSet) throws SQLException { //겹치는 부분을 메소드로 만듦
		Book book = new Book(); 
		book.setId(resultSet.getInt("id")); 
		book.setTitle(resultSet.getString("title"));                  
		book.setAuthor(resultSet.getString("author"));
		book.setCategoryId(resultSet.getInt("categoryId"));  
		book.setPrice(resultSet.getInt("price"));
		book.setCategoryName(resultSet.getString("categoryName"));
			return book;
	 }
	 
	 public static List<Book> findAll() throws Exception {        
		 String sql = "SELECT b.*, c.categoryName " +           
	 "FROM book b LEFT JOIN category c ON b.categoryId = c.id";    
		 try (Connection connection = DB.getConnection("book3");          
				 PreparedStatement statement = connection.prepareStatement(sql);     
				 ResultSet resultSet = statement.executeQuery()) {         
			 ArrayList<Book> list = new ArrayList<Book>();       
			 while (resultSet.next())            
				 list.add(getBookFrom(resultSet));     
			 return list;     
			 }
	 }
		 
	 public static void insert(Book book) throws Exception {       
		 String sql = "INSERT book (title, author, categoryId, price) VALUES (?, ?, ?, ?)";        
		 try (Connection connection = DB.getConnection("book3");           
				 PreparedStatement statement = connection.prepareStatement(sql)) {        
			        
			 statement.setString(1, book.getTitle());      
			 statement.setString(2, book.getAuthor());      
			 statement.setInt(3, book.getCategoryId());
			 statement.setInt(4, book.getPrice());
			             
			 statement.executeUpdate();       
			 }
	 }

}
