package it.engineering.web.webapp.context;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import it.engineering.web.webapp.model.City;
import it.engineering.web.webapp.model.Manufacturer;
import it.engineering.web.webapp.model.Product;
import it.engineering.web.webapp.model.User;

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
		City city1 = new City(11000, "Beograd");
		City city2 = new City(21000, "Novi Sad");
		City city3 = new City(15000, "Sabac");
		City city4 = new City(36000, "Kraljevo");
		List<City> cities = new CopyOnWriteArrayList<>();
		cities.add(city1);
		cities.add(city2);
		cities.add(city3);
		cities.add(city4);
		System.out.println("SERVER: Initial cities added.");

		Manufacturer manufacturer1 = new Manufacturer(5500, 2908978710063L, "Burmeister", "Cara Dusana 67", city1);
		Manufacturer manufacturer2 = new Manufacturer(6600, 1311978710062L, "Marantz", "Cara Urosa 67", city1);
		Manufacturer manufacturer3 = new Manufacturer(7700, 1709978510064L, "Sonus Faber", "Despota Stefana 67", city2);
		Manufacturer manufacturer4 = new Manufacturer(7700, 1709978510064L, "Cambridge Audio", "Svetog Save 32", city2);
		List<Manufacturer> manufacturers = new CopyOnWriteArrayList<>();
		manufacturers.add(manufacturer1);
		manufacturers.add(manufacturer2);
		manufacturers.add(manufacturer3);
		manufacturers.add(manufacturer4);
		System.out.println("SERVER: Initial manufacturers added.");

		Product product1 = new Product(100, "Speakers1", 1200.0, "pair", "euro", manufacturer1);
		Product product2 = new Product(100, "Headphones1", 600.0, "pair", "dollar", manufacturer2);
		Product product3 = new Product(100, "Amplifier1", 1400.0, "unit", "euro", manufacturer3);
		Product product4 = new Product(100, "Amplifier2", 2100.0, "unit", "euro", manufacturer1);
		List<Product> products = new CopyOnWriteArrayList<>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		System.out.println("SERVER: Initial products added.");

		sce.getServletContext().setAttribute("users", users);
		sce.getServletContext().setAttribute("cities", cities);
		sce.getServletContext().setAttribute("manufacturers", manufacturers);
		sce.getServletContext().setAttribute("products", products);

	}

}
