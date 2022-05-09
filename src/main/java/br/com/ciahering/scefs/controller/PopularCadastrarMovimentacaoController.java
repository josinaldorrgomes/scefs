package br.com.ciahering.scefs.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ciahering.scefs.model.Local;
import br.com.ciahering.scefs.repository.LocalRepository;

@WebServlet("/popularCadastrarMovimentacao")
public class PopularCadastrarMovimentacaoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection connection = (Connection) request.getAttribute("connection");
			//List<Movimentaca> locais = new LocalRepository(connection).getLocais();
			List<Local> locais = new LocalRepository(connection).getLocais();
			request.setAttribute("locais", locais);
			request.getRequestDispatcher("cadastrar-movimentacao.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			new RuntimeException("Ocorreu um erro ao popular os dados do item. Id = " + request.getParameter("id"), e);
		}
	}

}
