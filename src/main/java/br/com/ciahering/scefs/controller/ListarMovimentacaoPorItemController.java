package br.com.ciahering.scefs.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ciahering.scefs.model.Item;
import br.com.ciahering.scefs.model.Movimentacao;
import br.com.ciahering.scefs.repository.MovimentacaoRepository;

public class ListarMovimentacaoPorItemController implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			Item item = new Item();
			item.setItem_id(Integer.parseInt(request.getParameter("item_id")));
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
