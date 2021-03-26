package it.engineering.web.webapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.webapp.model.City;
import it.engineering.web.webapp.model.Manufacturer;

@SuppressWarnings("unchecked")
@WebServlet(urlPatterns = { "/cityDelete" })
public class CityDelete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {
			String indexParam = req.getParameter("indexCityDelete");
			int index = Integer.parseInt(indexParam);

			List<Manufacturer> mList = (List<Manufacturer>) req.getServletContext().getAttribute("manufacturers");
			List<City> cList = (List<City>) req.getServletContext().getAttribute("cities");

			City tempCity = cList.get(index);

			for (Manufacturer m : mList) {
				if (m.getCity().getPostCode() == tempCity.getPostCode()) {
					throw new Exception("There are manufacturers in that city. Cannot be deleted!");
				}
			}

			System.out.println("SERVER: User deleted " + cList.get(index));
			cList.remove(index);
			req.getRequestDispatcher("/navigation?link=cities").forward(req, res);

		} catch (Exception e) {
			req.setAttribute("message", e.getMessage());
			req.getRequestDispatcher("/error.jsp").forward(req, res);
		}
	}

}
