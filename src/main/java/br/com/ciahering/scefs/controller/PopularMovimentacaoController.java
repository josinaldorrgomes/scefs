package br.com.ciahering.scefs.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/popularMovimentacao")
public class PopularMovimentacaoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection connection = (Connection) request.getAttribute("connection");
			Integer item_id = Integer.valueOf(request.getParameter("item_id"));
			request.setAttribute("item_id", item_id);
			request.getRequestDispatcher("cadastrar-movimentacao.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			new RuntimeException(
					"Verificar a comunicação e passagem de parâmetros. O ID foi: " + request.getParameter("item_id"),
					e);
		}
	}

}
