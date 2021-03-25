package it.engineering.web.webapp.servlet;

import java.io.IOException;
import java.util.List;

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
			default:
				request.setAttribute("message", "Wrong link!");
			}
		} else {
			request.setAttribute("message", "Nije prosledjen parametar link...");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}
}
