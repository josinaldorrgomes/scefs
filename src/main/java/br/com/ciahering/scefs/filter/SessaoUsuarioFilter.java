package br.com.ciahering.scefs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "*.jsp" })
public class SessaoUsuarioFilter implements Filter {

	public SessaoUsuarioFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length())
					.replaceAll("[/]+$", "");
			if (httpRequest.getSession().getAttribute("usuario") == null) {
				if (!(path.equalsIgnoreCase("/login.jsp"))) {
					httpResponse.sendRedirect("login.jsp");
				}
			}
			chain.doFilter(httpRequest, httpResponse);
		} catch (IOException e) {
			throw new RuntimeException("Ocorreu um erro de IOException....", e);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
