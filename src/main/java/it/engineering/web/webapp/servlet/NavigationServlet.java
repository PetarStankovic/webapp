package it.engineering.web.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/navigation", "/nav" })
public class NavigationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String link = request.getParameter("link");
		String page = "index.jsp";

		if (link != null) {
			switch (link) {
			case "home":
				page = "index.jsp";
				break;
			case "login":
				page = "login.jsp";
				break;
			case "cities":
				page = "cities.jsp";
				break;
			case "cityadd":
				page = "cityadd.jsp";
				break;
			default:
				page="error.jsp";
				System.out.println("SERVER: User tried to navigate to wrong link.");
				request.setAttribute("message", "Wrong link!");
				break;
			}
		} else {
			page="error.jsp";
			System.out.println("SERVER: No link parameter found.");
			request.setAttribute("message", "No link parameter found!");
		}
		
		System.out.println("SERVER: User navigated to " + page + " successfully.");
		request.getRequestDispatcher(page).forward(request, response);
	}
}
