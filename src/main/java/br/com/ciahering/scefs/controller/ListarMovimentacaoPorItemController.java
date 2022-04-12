package br.com.ciahering.scefs.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ciahering.scefs.model.Item;
import br.com.ciahering.scefs.model.Movimentacao;
import br.com.ciahering.scefs.repository.MovimentacaoRepository;

@WebServlet("/movimentacoesPorItem")
public class ListarMovimentacaoPorItemController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			Item item = new Item();
			item.setId(Integer.parseInt(request.getParameter("id")));
			Connection connection = (Connection) request.getAttribute("connection");
			MovimentacaoRepository repository = new MovimentacaoRepository(connection);
			List<Movimentacao> movimentacoes = repository.getMovimentacoesByItem(item);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("movimentacoes", movimentacoes);
			request.getRequestDispatcher("listar-movimentacoes-por-item.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao tentar listar as movimentações do Item", e);
		}
	}

}
