package lecture1.jdbc1;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List;

import lecture1.DB; 

public class UserDAO {
	 private static User getUserFrom(ResultSet resultSet) throws SQLException { //겹치는 부분을 메소드로 만듦
		 User user = new User(); 
		   user.setId(resultSet.getInt("id")); 
			user.setUserid(resultSet.getString("userid"));                  
			user.setName(resultSet.getString("name"));                
			user.setEmail(resultSet.getString("email"));      
			user.setDepartmentName(resultSet.getString("departmentName"));   
			user.setEnabled(resultSet.getBoolean("enabled"));
			user.setUserType(resultSet.getString("userType"));
			return user;
	 }
	 
	 public static List<User> findAll() throws Exception {        
		 String sql = "SELECT u.*, d.departmentName " +           
	 "FROM user u LEFT JOIN department d ON u.departmentId = d.id";    
		 try (Connection connection = DB.getConnection("student1");          
				 PreparedStatement statement = connection.prepareStatement(sql);     
				 ResultSet resultSet = statement.executeQuery()) {         
			 ArrayList<User> list = new ArrayList<User>();       
			 while (resultSet.next())            
				 list.add(getUserFrom(resultSet));     
			 return list;     
			 }  
		 }
	 
	 public static List<User> findAll(int currentPage, int pageSize) throws Exception {
		 String sql = "SELECT u.*, d.departmentName" +                     
	 " FROM user u LEFT JOIN department d ON u.departmentId = d.id" +   
				 " LIMIT ?, ?";        
		 try (Connection connection = DB.getConnection("student1");             
				 PreparedStatement statement = connection.prepareStatement(sql)) {      
			 statement.setInt(1, (currentPage - 1) * pageSize);            
			 statement.setInt(2, pageSize);             
			 
			 try (ResultSet resultSet = statement.executeQuery()) {                 
				 ArrayList<User> list = new ArrayList<User>();                
while (resultSet.next()) {                    
	list.add(getUserFrom(resultSet));              
	}               
return list;           
}       
			 }  
		 }

	 public static int count() throws Exception {       
		 String sql = "SELECT COUNT(*) FROM user";      
		 try (Connection connection = DB.getConnection("student1");     
				 PreparedStatement statement = connection.prepareStatement(sql);   
				 ResultSet resultSet = statement.executeQuery()) {          
			 if (resultSet.next())                  
				 return resultSet.getInt(1);         }      
		 return 0;   
		 }

	public static List<User> findByName(String name) throws Exception {         
		String sql = "SELECT u.*, d.departmentName " +  //+ 앞에 공백 필수                    
	"FROM user u LEFT JOIN department d ON u.departmentId = d.id " +
				"WHERE name LIKE ?";         
		
		try (Connection connection = DB.getConnection("student1");              
				PreparedStatement statement = connection.prepareStatement(sql)){   
				 statement.setString(1, name + "%");
				 try (ResultSet resultSet = statement.executeQuery()) {                 
					 ArrayList<User> list = new ArrayList<User>();
			while (resultSet.next()) {  //resultSet 메소드로 목록을 하나씩 꺼냄  레코드 여러개 꺼내기             
				list.add(getUserFrom(resultSet));             
				}             
			return list;         
			}    
		} 
}
	
	public static List<User> findByName(String name, int currentPage, int pageSize) throws Exception {     
		String sql = "SELECT u.*, d.departmentName" +                     
	" FROM user u LEFT JOIN department d ON u.departmentId = d.id" +                     
				" WHERE name LIKE ?" +                      
	" LIMIT ?, ?";         
		try (Connection connection = DB.getConnection("student1");              
				PreparedStatement statement = connection.prepareStatement(sql)) {            
			statement.setString(1, name + "%");             
			statement.setInt(2, (currentPage - 1) * pageSize);             
			statement.setInt(3, pageSize);             
			try (ResultSet resultSet = statement.executeQuery()) {                 
				ArrayList<User> list = new ArrayList<User>();                 
				while (resultSet.next()) {                     
					list.add(getUserFrom(resultSet));            
					 }                 
				return list;            
				}         
			}    
		}    
	
	public static int count(String name) throws Exception {        
		String sql = "SELECT COUNT(*) FROM user WHERE name LIKE ?";      
		
		try (Connection connection = DB.getConnection("student1");             
				PreparedStatement statement = connection.prepareStatement(sql)) {       
			statement.setString(1, name + "%");            
			try (ResultSet resultSet = statement.executeQuery()) {           
				if (resultSet.next())                   
					return resultSet.getInt(1);           
				}       
			}        
		return 0;    
		}


	public static User findById(int id) throws Exception {         
		String sql = "SELECT u.*, d.departmentName " +  //+ 앞에 공백 필수                    
	"FROM user u LEFT JOIN department d ON u.departmentId = d.id " +
				"WHERE u.id = ?";         
		
		try (Connection connection = DB.getConnection("student1");              
				PreparedStatement statement = connection.prepareStatement(sql)){   
				 statement.setInt(1, id);
			 try (ResultSet resultSet = statement.executeQuery()) {                 
			if (resultSet.next())   //resultSet 메소드로 목록을 하나씩 꺼냄 레코드 하나만 꺼내기              
				return getUserFrom(resultSet);             
		      else           
			         return null;   
				
			}    
		} 
   }
	 public static List<User> findByDepartmentId(int departmentId) throws Exception {         
		 String sql = "SELECT u.*, d.departmentName " +                    
	 "FROM user u LEFT JOIN department d ON u.departmentId = d.id " +        
				 "WHERE u.departmentId = ?";        
		 try (Connection connection = DB.getConnection("student1");             
				 PreparedStatement statement = connection.prepareStatement(sql)) { 
			 statement.setInt(1, departmentId);           
			 
			 try (ResultSet resultSet = statement.executeQuery()) {          
				 ArrayList<User> list = new ArrayList<User>();              
				 while (resultSet.next())                   
					 list.add(getUserFrom(resultSet));           
				 return list;           
				 }       
			 }    
		 }
	 public static void insert(User user) throws Exception {       
		 String sql = "INSERT user (name, userId, departmentId) VALUES (?, ?, ?)";        
		 try (Connection connection = DB.getConnection("student1");           
				 PreparedStatement statement = connection.prepareStatement(sql)) {        
			 statement.setString(1, user.getName());        
			 statement.setString(2, user.getUserid());      
			 statement.setInt(3, user.getDepartmentId());          
			             
			 statement.executeUpdate();       
			 }
	 }

}