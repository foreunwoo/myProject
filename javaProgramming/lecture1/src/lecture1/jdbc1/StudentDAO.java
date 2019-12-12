package lecture1.jdbc1; 

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.util.ArrayList; 
import java.util.List; 
import lecture1.DB; 

public class StudentDAO {     
	public static List<Student> findAll() throws Exception {         
		String sql = "SELECT s.*, d.departmentName " +  //+ 앞에 공백 필수                    
	"FROM student s LEFT JOIN department d ON s.departmentId = d.id";   
		
		try (Connection connection = DB.getConnection("student1");	
				PreparedStatement statement = connection.prepareStatement(sql);
				 

				ResultSet resultSet = statement.executeQuery())           
					ArrayList<Student> list = new ArrayList<Student>();
       
			
			while (resultSet.next()) {  //resultSet 메소드로 목록을 하나씩 꺼냄               
				Student student = new Student();                 
				student.setId(resultSet.getInt("id"));                
				student.setStudentNumber(resultSet.getString("studentNumber"));                
				student.setName(resultSet.getString("name"));                
				student.setDepartmentId(resultSet.getInt("departmentId"));       
				student.setYear(resultSet.getInt("year"));              
				student.setDepartmentName(resultSet.getString("departmentName"));        
				list.add(student);             
				}             
			return list;         
			}    
		} 
	
	public static List<Student> findByName(String name) throws Exception {         
		String sql = "SELECT s.*, d.departmentName " +  //+ 앞에 공백 필수                    
	"FROM student s LEFT JOIN department d ON s.departmentId = d.id " +
				"where s.name like ?";   
        try (Connection connection = DB.getConnection("student1"); 
        PreparedStatement statement = connection.prepareStatement(sql)) {
        	statement.setString(1, name + "%");
        	 try (ResultSet resultSet = statement.executeQuery()) {   
        		 ArrayList<Student> list = new ArrayList<Student>();   
        		 while (resultSet.next()) {                  
        			 Student student = new Student();               
        			 student.setId(resultSet.getInt("id"));    
        			 student.setStudentNumber(resultSet.getString("studentNumber"));    
        			 student.setName(resultSet.getString("name"));            
        			 student.setDepartmentId(resultSet.getInt("departmentId"));   
        			 student.setYear(resultSet.getInt("year"));                 
        			 student.setDepartmentName(resultSet.getString("departmentName"));   
        			 list.add(student);                 
        			 }            
        		 return list;            
        		 }        
        	 }  
        }
	 public static void insert(Student student) throws Exception {       
		 String sql = "INSERT student (name, studentNumber, departmentId, year) VALUES (?, ?, ?, ?)";        
		 try (Connection connection = DB.getConnection("student1");           
				 PreparedStatement statement = connection.prepareStatement(sql)) {        
			 statement.setString(1, student.getName());        
			 statement.setString(2, student.getStudentNumber());      
			 statement.setInt(3, student.getDepartmentId());          
			 statement.setInt(4, student.getYear());            
			 statement.executeUpdate();       
			 }
	 }

	} 

