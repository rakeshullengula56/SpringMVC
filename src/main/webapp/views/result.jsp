<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="result.css">
<title>SpringMVC calculator</title>
</head>
<body>
<!-- <h2>Result is: <%= session.getAttribute("result") %> </h2> using session -->
<!-- <h2>Result is: ${result} </h2>  using jstl -->
<% if (request.getAttribute("error") != null) { %>
    <h2 style="color:red;">Error: <%= request.getAttribute("error") %></h2>
<% } else { %>
    <h2>
        Result for <b><%= request.getAttribute("expression") %></b> is:
        <span style="color:green;"><%= request.getAttribute("result") %></span>
    </h2>
<% } %>
<br/>
<a href="<%= request.getContextPath() %>/">Go Back</a>
</form>
</body>
</html>