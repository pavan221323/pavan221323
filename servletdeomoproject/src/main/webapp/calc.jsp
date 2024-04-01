<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
    function setAction(operation) {
        document.getElementById("operation").value = operation; // Set the operation value
        document.getElementById("calcForm").submit(); // Submit the form after setting the operation
    }
</script>
</head>
<body>
    
<%-- Java code to parse parameters --%>
<% 
    int a = 0;
    int b = 0;
    int c = 0; // Variable to hold the sum
    int d = 0; // Variable to hold the subtraction result
    String aValue = request.getParameter("a");
    String bValue = request.getParameter("b");
    String operation = request.getParameter("operation");
    if (aValue != null && bValue != null) {
        try {
            a = Integer.parseInt(aValue);
            b = Integer.parseInt(bValue);
            if ("add".equals(operation)) {
                c = a + b; // Calculate the sum if 'add' operation selected
            } else if ("subtract".equals(operation)) {
                d = a - b; // Calculate the subtraction result if 'subtract' operation selected
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Handle invalid input
        }
    }
%>

<form id="calcForm" method="get">
    <input type="hidden" name="operation" id="operation" value="">
    a<input type="number" name="a"><br><br>
    b<input type="number" name="b"><br><br>
    <input type="button" value="Add" onclick="setAction('add')"><br><br>
    <input type="button" value="Subtract" onclick="setAction('subtract')">
</form>

<%-- Display the sum if 'add' operation is selected, otherwise display the subtraction result --%>
<% if ("add".equals(operation)) { %>
    <h1>The sum is <%= c %></h1>
<% } else if ("subtract".equals(operation)) { %>
    <h1>The sub is <%= d %></h1>
<% } %>

</body>
</html>




