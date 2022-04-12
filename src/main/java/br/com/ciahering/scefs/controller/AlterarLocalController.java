package br.com.ciahering.scefs.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ciahering.scefs.model.Local;
import br.com.ciahering.scefs.repository.LocalRepository;

@WebServlet("/alterarLocal")
public class AlterarLocalController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			Local local = new Local();
			local.setId(Integer.valueOf(request.getParameter("id")));
			local.setNome(request.getParameter("nome"));
			Connection connection = (Connection) request.getAttribute("connection");
			LocalRepository repository = new LocalRepository(connection);
			repository.updateLocal(local);
			response.sendRedirect("listar-locais.jsp");

		} catch (IOException e) {
			new RuntimeException("Ocorreu um erro ao tentar alterar o item. Os dados da requisição foram ID = "
					+ request.getParameter("id") + " Nome = " + request.getParameter("nome"), e);
		}
	}
}
