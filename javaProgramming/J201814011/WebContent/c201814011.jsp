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
<tr>
<% for(int i=2; i<=3; ++i) {%>
<td> 
<% for(int j=2; j<=9; j++) {%>
<% out.println(i + "x" + j + "=" + i*j); %>
</br>
<% } %>
</td>
<%} %>
</tr>
<tr>
<% for(int i=4; i<=5; ++i) {%>
<td> 
<% for(int j=2; j<=9; j++) {%>
<% out.println(i + "x" + j + "=" + i*j); %>
</br>
<% } %>
</td>
<%} %>
</tr>
<tr>
<% for(int i=6; i<=7; ++i) {%>
<td> 
<% for(int j=2; j<=9; j++) {%>
<% out.println(i + "x" + j + "=" + i*j); %>
</br>
<% } %>
</td>
<%} %>
</tr>
<tr>
<% for(int i=8; i<=9; ++i) {%>
<td> 
<% for(int j=2; j<=9; j++) {%>
<% out.println(i + "x" + j + "=" + i*j); %>
</br>
<% } %>
</td>
<%} %>
</tr>
</table>
</body>
</html>