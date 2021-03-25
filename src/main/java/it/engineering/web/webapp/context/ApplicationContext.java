package it.engineering.web.webapp.context;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import it.engineering.web.webapp.model.City;
import it.engineering.web.webapp.model.User;

/**
 * Application Lifecycle Listener implementation class ApplicationContext
 *
 */
@WebListener
public class ApplicationContext implements ServletContextListener {

	public ApplicationContext() {
		System.out.println("SERVER: Application context constructed.");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		System.out.println("SERVER: Application context initialized.");

		// lista korisnika
		List<User> users = new ArrayList<>();
		users.add(new User("Admin", "admin@gmail.com", "admin123"));
		users.add(new User("Petar", "petar@gmail.com", "petar123"));
		users.add(new User("Zorana", "zorana@gmail.com", "zorana123"));

		List<City> cities = new ArrayList<>();
		cities.add(new City(11000, "Beograd"));
		cities.add(new City(21000, "Novi Sad"));
		cities.add(new City(21000, "Sabac"));
		
		sce.getServletContext().setAttribute("cities", cities);
		sce.getServletContext().setAttribute("users", users);
	}

}
