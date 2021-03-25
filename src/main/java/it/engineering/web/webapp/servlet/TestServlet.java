package it.engineering.web.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/test"})
public class TestServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String testString = req.getParameter("test");
		System.out.println(testString);
		req.setAttribute("message", "Test message");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
