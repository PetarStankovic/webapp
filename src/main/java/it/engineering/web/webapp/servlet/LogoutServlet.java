package it.engineering.web.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.web.webapp.model.User;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("engineering_user");
		System.out.println("SERVER: User " + user.getUsername() + " logged out.");
		session.removeAttribute("engineering_user");
		session.invalidate();		
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
		
	}

}
