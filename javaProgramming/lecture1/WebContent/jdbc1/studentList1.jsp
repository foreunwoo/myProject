<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.util.List, lecture1.jdbc1.*" %> //이 패키지에 들어있는 모든 클래스를 참조한다
<% List<Student> list = StudentDAO.findAll(); %> //ArrayList 리턴 자식 개념을 부모 개념으로 불러도 됨
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
<h1>학생목록</h1> 
<table class="table table-bordered table-condensed"> //부트 스트랩 서식 지정(style 서식을 따로 지정하지 않아도 됨)   
<thead>         
<tr>             
<th>학번</th>             
<th>이름</th>             
<th>학과</th>             
<th>학년</th>         
</tr>     
</thead>     
<tbody>         
<% for (Student student : list) { %> //그 목록에 들어있는 스튜던트 객체를 하나씩 꺼낸다            
<tr>                 
<td><%= student.getStudentNumber() %></td>                 
<td><%= student.getName() %></td>                 
<td><%= student.getDepartmentName() %></td>                 
<td><%= student.getYear() %></td>             
</tr>         
<% } %>    
</tbody> 
</table> 
</div> 
</body> 
</html>
