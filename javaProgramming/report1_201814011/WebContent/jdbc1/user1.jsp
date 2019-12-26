<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.util.List, report1_201814011.jdbc1.*" %> 
<% 
String s = request.getParameter("id"); 
int id = Integer.parseInt(s);
User user = UserDAO.findById(id);
%> 
<!DOCTYPE html> 
<html> 
<head>   
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">   
<meta name="viewport" content="width=device-width, initial-scale=1">   
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>   
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>   
<style>       
body { font-family: 굴림체; }       
thead th { background-color: #eee; }       
table.table { width: 700px; }   
</style> 
</head> 
<body> 

<div class="container"> 
<h1>사용자</h1> 

<table class="table table-bordered table-condensed"> 
<thead>         
  
</thead>     
<tbody>         
<tr>                 
<td>ID</td>
<td><%= user.getId() %></td>
</tr>                 
<tr>
<td>이름</td>
<td><%= user.getName() %></td>    
</tr>
<tr>
<td>Email</td>
<td><%= user.getEmail() %></td>      
</tr>        
<tr>
<td>학과</td>
<td><%= user.getDepartmentName() %></td> 
</tr>
<tr>     
<td>활성화</td>           
<td><%= user.isEnabled() %></td>
</tr>
<tr>
<td>사용자유형</td> 
<td><%= user.getUserType() %></td>            
</tr>         

</tbody> 
</table> 
</div> 
</body> 
</html>
