package it.engineering.web.webapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.webapp.model.City;

@WebServlet(urlPatterns = { "/cityDelete" })
public class CityDelete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String indexParam = request.getParameter("indexCityDelete");
		int index = Integer.parseInt(indexParam);

		List<City> list = (List<City>) request.getServletContext().getAttribute("cities");

		System.out.println("SERVER: Deleted " + list.get(index));
		list.remove(index);

		request.getRequestDispatcher("/navigation?link=cities").forward(request, response);
	}

}
