<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page isELIgnored="false"%>


<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>Home Page</title>
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
			
			<h1>Welcome ${engineering_user.username}</h1>
			
			<form name="formlogout" action="logout">
							
				<button><a href="/webapp/navigation?link=cities">Cities</a></button>
				<button><a href="/webapp/navigation?link=manufacturers">Manufacturers</a></button>
				<button><a href="/webapp/navigation?link=products">Products</a></button>
				<br/>
				<button type="submit" value="logout" name="logout">Log Out</button>	
			</form>
		
			
			
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