<%@page import="java.util.Base64"%>
<%@page import="dto.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% HttpSession session1=request.getSession(); %>
<%user user=(user)session.getAttribute("user"); %>
<% String username=user.getUsername(); %>

<h2>welcome<%= username %></h2>
<h4>email:<%= user.getUseremail() %></h4>

<% String image=new String(Base64.getEncoder().encode(user.getUserimage())); %>
<img alt="" src="data:image/jpeg;base64,<%=image %>" width="150"  heigth="100"%>


</body>
</html>