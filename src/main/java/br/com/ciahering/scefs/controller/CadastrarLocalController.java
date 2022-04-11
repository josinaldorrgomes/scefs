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

@WebServlet("/cadastrarLocal")
public class CadastrarLocalController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			Local local = new Local();
			local.setNome(request.getParameter("nome"));
			Connection connection = (Connection) request.getAttribute("connection");
			LocalRepository repository = new LocalRepository(connection);
			repository.addLocal(local);
			request.getRequestDispatcher("cadastrar-local.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			new RuntimeException("Ocorreu um erro ao tentar cadastrar o novo local.", e);
		}
	}
}
