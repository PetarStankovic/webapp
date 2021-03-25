package it.engineering.web.webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.engineering.web.webapp.model.User;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = { "/*" })
public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI().substring(req.getContextPath().length());
		if (path.equals("/login.jsp") || path.equals("/login")) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("engineering_user");
			if (user == null) {
				req.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		}

	}

	@Override
	public void destroy() {
	}

}
