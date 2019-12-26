package report1_201814011.jdbc1;

import java.sql.Connection; 

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List;

import report1_201814011.DB; 

public class UserDAO {
	 private static User getUserFrom(ResultSet resultSet) throws SQLException { //��ġ�� �κ��� �޼ҵ�� ����
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

	public static List<User> findByName(String name) throws Exception {         
		String sql = "SELECT u.*, d.departmentName " +  //+ �տ� ���� �ʼ�                    
	"FROM user u LEFT JOIN department d ON u.departmentId = d.id " +
				"WHERE name LIKE ?";         
		
		try (Connection connection = DB.getConnection("student1");              
				PreparedStatement statement = connection.prepareStatement(sql)){   
				 statement.setString(1, name + "%");
				 try (ResultSet resultSet = statement.executeQuery()) {                 
					 ArrayList<User> list = new ArrayList<User>();
    
			
			while (resultSet.next()) {  //resultSet �޼ҵ�� ����� �ϳ��� ����  ���ڵ� ������ ������             
				list.add(getUserFrom(resultSet));             
				}             
			return list;         
			}    
		} 
}
	public static User findById(int id) throws Exception {         
		String sql = "SELECT u.*, d.departmentName " +  //+ �տ� ���� �ʼ�                    
	"FROM user u LEFT JOIN department d ON u.departmentId = d.id " +
				"WHERE u.id = ?";         
		
		try (Connection connection = DB.getConnection("student1");              
				PreparedStatement statement = connection.prepareStatement(sql)){   
				 statement.setInt(1, id);
			 try (ResultSet resultSet = statement.executeQuery()) {                 
			if (resultSet.next())   //resultSet �޼ҵ�� ����� �ϳ��� ���� ���ڵ� �ϳ��� ������              
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

}