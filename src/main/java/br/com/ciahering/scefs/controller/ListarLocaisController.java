package br.com.ciahering.scefs.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ciahering.scefs.model.Local;
import br.com.ciahering.scefs.repository.LocalRepository;

@WebServlet("/locais")
public class ListarLocaisController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	LocalRepository repository;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection connection = (Connection) request.getAttribute("connection");
			repository = new LocalRepository(connection);
			List<Local> locais = repository.getLocais();
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("locais", locais);
			request.getRequestDispatcher("listar-locais.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um problema ao listar os locais.", e);
		}
	}

}
