package br.com.ciahering.scefs.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ciahering.scefs.model.Movimentacao;
import br.com.ciahering.scefs.repository.MovimentacaoRepository;

@WebServlet("/movimentacoes")
public class ListarMovimentacoesController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	MovimentacaoRepository repository;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection connection = (Connection) request.getAttribute("connection");
			repository = new MovimentacaoRepository(connection);
			List<Movimentacao> movimentacoes = repository.getMovimentacoes();
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("movimentacoes", movimentacoes);
			request.getRequestDispatcher("listar-movimentacoes.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao tentar listar as movimentações do Item", e);
		}
	}

}
