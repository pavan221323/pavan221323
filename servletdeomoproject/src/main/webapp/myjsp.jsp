<%@page import="java.sql.ResultSet"%>
<%@ page import="myproject.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
th{
            border:1px solid black;
        }
        td{
            border:1px solid black;
        }
        th,td{
            padding: 10px;
        }
        table,th,td{
            text-align: center;
           
            border-collapse: collapse;
        }

</style>
</head>
<body>

<% ResultSet rs=(ResultSet)request.getAttribute("resultset"); %>
<table>
<thead>
<tr>
<th>id</th>
<th>name</th>
<th>age</th>
<th>salary</th>

</tr>
</thead>
<% while(rs.next()){ %>

<tr>
<td><%= rs.getInt(1) %></td>
<td><%= rs.getString(2) %></td>
<td><%= rs.getInt(3) %></td>
<td><%= rs.getDouble(4) %></td>
</tr>

<% } %>
</table>


</body>
</html>