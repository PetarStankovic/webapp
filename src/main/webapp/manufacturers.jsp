<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>Manufacturers Page</title>
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

		<main class="main-login"> <c:if test="${cities.size() > 0}">
			<h1>${engineering_user.username}, here is the list of manufacturers:</h1>
				<div id="manufacturers">
					<table>
						<tr>
							<td style="display: none;">Index</td>
							<td>PIB</td>
							<td>JMBG</td>
							<td>Name</td>
							<td>Address</td>
							<td>City</td>
							<td>Delete</td>
							<td>Update</td>
						</tr>
						<c:forEach items="${manufacturers}" var="manufacturer" varStatus="loop">
							<tr>
								<td style="display: none;">${loop.index}</td>
								<td>${manufacturer.pib}</td>
								<td>${manufacturer.jmbg}</td>
								<td>${manufacturer.name}</td>
								<td>${manufacturer.address}</td>
								<td>${manufacturer.city.name}</td>


								<c:url value="/manufacturerDelete" var="urlDelete">
									<c:param name="index" value="${loop.index}"></c:param>
								</c:url>
								<td><a href="${urlDelete}">Delete</a href></td>

								<c:url value="/manufacturerDelete" var="urlUpdate">
									<c:param name="index" value="${loop.index}"></c:param>
								</c:url>
								<td><a href="${urlUpdate}">Update</a href></td>
							</tr>
						</c:forEach>
					</table>


				</div>
				
		</c:if>
				
				<form name="manufactureradd-form">
					<br/>
					<button type="submit" value="add" name="add">
						<a href="/webapp/navigation?link=manufactureradd">Add Manufacturer</a>
					</button>
				</form>

		<form name="back">
			<button type="submit" value="back" name="back">
				<a href="/webapp/navigation?link=home">Back to Home Page</a>
			</button>
		</form>
		</main>

		<footer>
			<div class="footer-icon-div">
				<a href="https://www.facebook.com"><img
					src="resources/img/facebook.png" alt="Facebook" height="50px"
					width="50px" /></a> <a href="https://www.twitter.com"><img
					src="resources/img/twitter.png" alt="Twitter" height="50px"
					width="50px" /></a> <a href="https://www.instagram.com"><img
					src="resources/img/instagram.png" alt="Instagram" height="50px"
					width="50px" /></a>
			</div>
			<div class="footer-paragraph-div">
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam.</p>
			</div>
		</footer>

	</div>

</body>

</html>