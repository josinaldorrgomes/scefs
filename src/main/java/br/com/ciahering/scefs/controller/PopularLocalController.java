package br.com.ciahering.scefs.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ciahering.scefs.model.Local;
import br.com.ciahering.scefs.repository.LocalRepository;

@WebServlet("/popularLocal")
public class PopularLocalController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	LocalRepository repository = new LocalRepository();

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection connection = (Connection) request.getAttribute("connection");
			Local local = new LocalRepository(connection)
					.getLocalById(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("local", local);
			request.getRequestDispatcher("alterar-local.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			new RuntimeException(
					"Verificar a comunicação e passagem de parâmetros. O ID foi: " + request.getParameter("id"),
					e);
		}
	}

}
