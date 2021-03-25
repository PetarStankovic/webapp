package it.engineering.web.webapp.context;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import it.engineering.web.webapp.model.City;
import it.engineering.web.webapp.model.User;

/**
 * Application Lifecycle Listener implementation class ApplicationContext
 *
 */
@WebListener("Configuration")
public class ApplicationContext implements ServletContextListener {

	public ApplicationContext() {
		System.out.println("SERVER: Application context constructed.");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("SERVER: Application context destroyed.");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		System.out.println("SERVER: Application context initialized.");

		List<User> users = new ArrayList<>();
		users.add(new User("Admin", "admin@gmail.com", "admin123"));
		users.add(new User("Petar", "petar@gmail.com", "petar123"));
		users.add(new User("Zorana", "zorana@gmail.com", "zorana123"));
		System.out.println("SERVER: Initial users added.");

		// copyonwritearraylist - multithreading mag petar stankovic, salim se, blam
		List<City> cities = new CopyOnWriteArrayList<>();
		cities.add(new City(11000, "Beograd"));
		cities.add(new City(21000, "Novi Sad"));
		cities.add(new City(21000, "Sabac"));
		System.out.println("SERVER: Initial cities added.");

		sce.getServletContext().setAttribute("cities", cities);
		sce.getServletContext().setAttribute("users", users);
	}

}
