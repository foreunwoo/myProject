<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.util.List, lecture1.jdbc1.*" %> 
<% String s = request.getParameter("departmentId");
if (s == null) s = "1"; 
int departmentId = Integer.parseInt(s); 
List<User> users = UserDAO.findByDepartmentId(departmentId); 
List<Department> departments = DepartmentDAO.findAll(); %> 
<!DOCTYPE html> 
<html> 
<head>  
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">   
 <meta name="viewport" content="width=device-width, initial-scale=1">   
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
 </script>  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
  </script>   
  <style>      
   thead th { background-color: #eee; }     
     table.table { width: 700px; margin-top: 10px; }  
      </style> 
      </head> 
      <body> 
      <div class="container"> 
      <h1>사용자 목록</h1> 
      <form class="form-inline">   
      <div class="form-group">     
      <label>학과</label>     
      <select name="departmentId" class="form-control">       
      <% for (Department department : departments) { %>         
      <% int id = department.getId(); %>         
      <% String name = department.getDepartmentName(); %>         
      <option value="<%= id %>" 
      <%= (departmentId == id) ? "selected" : "" %> >           
      <%= name %>         
      </option>       
      <% } %>     
      </select>   
      </div>   
      <button type="submit" class="btn btn-primary">조회</button> 
      </form> 
      <table class="table table-bordered table-condensed">     
      <thead>         
      <tr>             
      <th>학번</th>            
       <th>이름</th>             
       <th>학과</th>             
       <th>사용자유형</th>         
       </tr>     
       </thead>     
       <tbody>         
       <% for (User user : users) { %>             
       <tr>                 
       <td><%= user.getUserid() %></td>                 
       <td><a href="user1.jsp?id=<%= user.getId() %>">
       <%= user.getName() %></a>
       </td>                 
       <td><%= user.getDepartmentName() %></td>                 
       <td><%= user.getUserType() %></td>            
        </tr>         
        <% } %>     
        </tbody> 
        </table> 
        </div>
