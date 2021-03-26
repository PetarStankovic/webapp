package it.engineering.web.webapp.servlet;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.webapp.model.City;

@SuppressWarnings("unchecked")
@WebServlet(urlPatterns = { "/cityadd" })
public class CityAdd extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String pc = req.getParameter("postCode");
			if (pc.length() != 5) {
				throw new InputMismatchException("Postcode in Serbia has 5 digits!");
			}
			int postcode = Integer.parseInt(pc);

			String name = req.getParameter("name");

			List<City> cities = (List<City>) req.getServletContext().getAttribute("cities");
			if (cities == null) {
				cities = new CopyOnWriteArrayList<>();
			}

			City city = new City(postcode, name);

			boolean validation = true;

			for (City c : cities) {
				if (city.getPostCode() == c.getPostCode()) {
					validation = false;
				}
			}

			if (validation) {
				cities.add(city);
				System.out.println("SERVER: User added: " + city);
				req.setAttribute("cities", cities);
				req.setAttribute("city", city);
				req.getRequestDispatcher("/cities.jsp").forward(req, resp);
			} else {
				System.out.println("SERVER: User tried to add existing city");
				throw new InputMismatchException("You tried to add city that already exists!");
			}

		} catch (Exception e) {
			req.setAttribute("message", e.getMessage());
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}

	}
}
