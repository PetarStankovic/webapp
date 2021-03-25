<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>Cities Page</title>
	<link type="text/css" rel="stylesheet" href="resources/css/style.css" />
</head>

<body>

	<div class="site-container-div">			
		<header>
				<nav>
					<ul id="nav-list">
						<li><a href="/webapp/navigation?link=home">Home</a></li>
						<li><a href="#">Contact</a></li>
						<li><a href="#">About</a></li>
						<li><a href="/webapp/navigation?link=login">Log In</a></li>
					</ul>
				</nav>			
		</header>	
		
		<main class="main-login">	
			
			<h1>${engineering_user.username}, here is the list of cities:</h2>
			
			
			<c:if test ="${cities.size() > 0}">			
			<div id="cities"> 
				<table>
					<tr> 
						<td>Index</td> 	
    					<td>Postal Code</td> 
  						<td>Name</td>
  						<td>Add City</td>
  						<td>Delete City</td>
  						<td>Update City</td>
  					</tr> 
					<c:forEach items="${cities}" var="city" varStatus="loop">  
 					<tr> 
 						<td>${loop.index}</td>
    					<td>${city.postCode}</td> 
  						<td>${city.name}</td>
  						
  						<c:url value="/city" var="urlAdd">
							<c:param name="index" value="${loop.index}"></c:param>
						</c:url>
						<td>
							<a href="${urlAdd}">Add</a href>
						</td>  						
  						
  						<c:url value="/city" var="urlDelete">
							<c:param name="index" value="${loop.index}"></c:param>
						</c:url>
						<td>
							<a href="${urlDelete}">Delete</a href>
						</td>
						
						<c:url value="/city" var="urlUpdate">
							<c:param name="index" value="${loop.index}"></c:param>
						</c:url>
						<td>
							<a href="${urlUpdate}">Update</a href>
						</td>
  					</tr> 
					</c:forEach> 	
				</table>
			
			</div>
			</c:if>			
		</main>	
		
		<footer>
			<div class="footer-icon-div">
				<a href="https://www.facebook.com"><img src="resources/img/facebook.png" alt="Facebook" height="50px" width="50px"/></a>
				<a href="https://www.twitter.com"><img src="resources/img/twitter.png" alt="Twitter" height="50px" width="50px"/></a>
				<a href="https://www.instagram.com"><img src="resources/img/instagram.png" alt="Instagram" height="50px" width="50px"/></a>
			</div>
			<div class="footer-paragraph-div">
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam.
				</p>
			</div>
		</footer>
		
	</div>	

</body>

</html>