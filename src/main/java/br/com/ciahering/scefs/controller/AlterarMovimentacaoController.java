package br.com.ciahering.scefs.controller;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ciahering.scefs.model.Item;
import br.com.ciahering.scefs.model.Local;
import br.com.ciahering.scefs.model.Movimentacao;
import br.com.ciahering.scefs.repository.MovimentacaoRepository;

@WebServlet("/alterarMovimentacao")
public class AlterarMovimentacaoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			Movimentacao movimentacao = new Movimentacao();
			movimentacao.setId(Integer.valueOf(request.getParameter("id")));
			movimentacao.setData(LocalDate.parse(request.getParameter("data")));
			movimentacao.setTipo(request.getParameter("tipo"));
			Local local = new Local();
			local.setId(Integer.valueOf(request.getParameter("local_id")));
			movimentacao.setLocal(local);
			Item item = new Item();
			item.setId(Integer.valueOf(request.getParameter("item_id")));
			movimentacao.setItem(item);
			Connection connection = (Connection) request.getAttribute("connection");
			MovimentacaoRepository movimentacaoDao = new MovimentacaoRepository(connection);
			movimentacaoDao.updateMovimentacao(movimentacao);
			response.sendRedirect("listar-movimentacoes-por-item.jsp");
		} catch (IOException e) {
			new RuntimeException("Ocorreu um erro ao tentar alterar a movimentação de id: " + request.getParameter("id"), e);
		}
	}
}
