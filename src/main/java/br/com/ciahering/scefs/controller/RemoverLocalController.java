package br.com.ciahering.scefs.controller;

import java.sql.Connection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ciahering.scefs.model.Local;
import br.com.ciahering.scefs.repository.LocalRepository;

@WebServlet("/removerLocal")
public class RemoverLocalController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			Local local = new Local();
			local.setLocal_id(Integer.valueOf(request.getParameter("local_id")));
			Connection connection = (Connection) request.getAttribute("connection");
			LocalRepository repository = new LocalRepository(connection);
			repository.deleteLocal(local);
			response.sendRedirect("listar-locais.jsp");
		} catch (Exception e) {
			new RuntimeException("Ocorreu um erro ao tentar deletar o local.", e);
		}
	}

}
