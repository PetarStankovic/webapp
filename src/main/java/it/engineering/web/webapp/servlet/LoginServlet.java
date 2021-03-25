package it.engineering.web.webapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.web.webapp.model.User;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println("SERVER: User trying to log in with Email: " + email + " Password: " + password);

		boolean found = false;
		List<User> users = (List<User>) getServletContext().getAttribute("users");
		for (User user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				found = true;
				HttpSession session = req.getSession(true);
				session.setAttribute("engineering_user", new User(user.getUsername(), user.getEmail(), ""));
				break;
			}
		}

		if (found == true) {
			System.out.println("SERVER: Log in success.");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else {
			System.out.println("SERVER: Log in failed.");
			req.setAttribute("message", "Wrong username or password!");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}

	}

}
