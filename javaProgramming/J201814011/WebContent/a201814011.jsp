<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>     
table { border-collapse: collapse; }     
td { padding: 5px; border: solid 1px gray; } 
</style>
</head>
<body>
<table>
<% for(int i=2; i<=9; ++i) {%>
<tr>
<% for(int j=2; j<=9; ++j) {%>
<td><% out.print(i + "x" + j + "=" + i*j); %></td>
<% } %>
</tr>
<% } %>
</table>
</body>
</html>