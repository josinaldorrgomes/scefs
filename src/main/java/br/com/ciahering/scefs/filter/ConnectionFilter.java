package br.com.ciahering.scefs.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.ciahering.scefs.jdbc.ConnectionFactory;

@WebFilter("/*")
public class ConnectionFilter implements Filter {

	public ConnectionFilter() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			Connection connection = new ConnectionFactory().getConnection();
			request.setAttribute("connection", connection);
			chain.doFilter(request, response);
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("O filtro de conexão apresentou um erro. Verificar!", e);
		}
	}

}
