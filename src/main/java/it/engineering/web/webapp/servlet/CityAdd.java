package it.engineering.web.webapp.servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.webapp.model.City;

@WebServlet(urlPatterns = { "/cityadd" })
public class CityAdd extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int postcode = Integer.parseInt(req.getParameter("postCode"));
		String name = req.getParameter("name");		
		

		List<City> cities = (List<City>) req.getServletContext().getAttribute("cities");
		if (cities == null) {
			cities = new CopyOnWriteArrayList<>();
		}
		

		City city = new City(postcode, name);
		cities.add(city);		
		System.out.println("SERVER: User added a new city: " + postcode + " " +  name);
		
		
		req.setAttribute("cities", cities);		
		req.setAttribute("city", city);		
		req.getRequestDispatcher("/cities.jsp").forward(req, resp);
	}
}
