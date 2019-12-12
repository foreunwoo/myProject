package lecture1.jdbc1;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List;

import lecture1.DB; 

public class ProfessorDAO {
	private static Professor getProfessorFrom(ResultSet resultSet) throws SQLException { //겹치는 부분을 메소드로 만듦
		Professor professor = new Professor(); 
		professor.setId(resultSet.getInt("id")); 
		professor.setProfessorName(resultSet.getString("professorName"));                  
		professor.setDepartmentId(resultSet.getString("departmentId"));
		professor.setDepartmentName(resultSet.getString("departmentName"));  
			
			return professor;
	 }
	 
	 public static List<Professor> findAll() throws Exception {        
		 String sql = "SELECT p.*, d.departmentName " +           
	 "FROM professor p LEFT JOIN department d ON p.departmentId = d.id";    
		 try (Connection connection = DB.getConnection("student1");          
				 PreparedStatement statement = connection.prepareStatement(sql);     
				 ResultSet resultSet = statement.executeQuery()) {         
			 ArrayList<Professor> list = new ArrayList<Professor>();       
			 while (resultSet.next())            
				 list.add(getProfessorFrom(resultSet));     
			 return list;     
			 }
	 }
		 
		 public static void insert(Professor professor) throws Exception {       
			 String sql = "INSERT professor (id, professorName, departmentId) VALUES (?, ?, ?)";        
			 try (Connection connection = DB.getConnection("student1");           
					 PreparedStatement statement = connection.prepareStatement(sql)) {        
				 statement.setInt(1, professor.getId());        
				 statement.setString(2, professor.getProfessorName());      
				 statement.setString(3, professor.getDepartmentId());          
				             
				 statement.executeUpdate();       
				 }
		 }

	}

