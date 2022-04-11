package br.com.ciahering.scefs.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ciahering.scefs.model.Local;
import br.com.ciahering.scefs.repository.LocalRepository;

public class AlterarLocalController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			if (request.getParameter("metodo").equalsIgnoreCase("alterarLocal")) {
				this.alterarLocal(request, response);
			} else if (request.getParameter("metodo").equalsIgnoreCase("popularLocal")) {
				this.popularLocal(request, response);
			}
		} catch (Exception e) {
			new RuntimeException("Ocorreu uma Exception no executa do AlterarItemLogica...", e);
		}
	}

	public void alterarLocal(HttpServletRequest request, HttpServletResponse response) {
		try {
			Local local = new Local();
			local.setLocal_id(Integer.valueOf(request.getParameter("id")));
			local.setNome(request.getParameter("nome"));

			Connection connection = (Connection) request.getAttribute("connection");
			LocalRepository repository = new LocalRepository(connection);
			repository.updateLocal(local);

			response.sendRedirect("listar-locais.jsp");

		} catch (IOException e) {
			new RuntimeException("Ocorreu uma Exception no alterarItem do AlterarLocalLogica...", e);
		}
	}

	public void popularLocal(HttpServletRequest request, HttpServletResponse response) {
		try {
			Local local = new Local();
			local.setLocal_id(Integer.valueOf(request.getParameter("id")));
			Connection connection = (Connection) request.getAttribute("connection");
			local = new LocalRepository(connection).getLocalById(local);
			request.setAttribute("local", local);
			request.getRequestDispatcher("alterar-local.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			new RuntimeException("Ocorreu uma Exception no popularItem...", e);
		}
	}
}
