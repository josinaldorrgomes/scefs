package br.com.ciahering.scefs.controller;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			movimentacao.setOrigem(request.getParameter("origem"));
			movimentacao.setDestino(request.getParameter("destino"));
			Connection connection = (Connection) request.getAttribute("connection");
			MovimentacaoRepository movimentacaoDao = new MovimentacaoRepository(connection);
			movimentacaoDao.updateMovimentacao(movimentacao);
			response.sendRedirect("listar-movimentacoes-por-item.jsp");
		} catch (IOException e) {
			new RuntimeException("Ocorreu um erro ao tentar alterar o item de id: " + request.getParameter("id"), e);
		}
	}
}
