<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>Test Servlet</h2>
	
	<p>${message}</p>
		
	<div>
		<form action="test" method="post">
			<input type="text" name="test"/>
			<button type=submit>Submit</button>
		</form>
	</div>
</body>
</html>