package br.com.ciahering.scefs.controller;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ciahering.scefs.model.Movimentacao;
import br.com.ciahering.scefs.repository.MovimentacaoRepository;

public class AlterarMovimentacaoController implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			if (request.getParameter("metodo").equalsIgnoreCase("alterarMovimentacao")) {
				this.alterarMovimentacao(request, response);
			} else if (request.getParameter("metodo").equalsIgnoreCase("popularMovimentacao")) {
				this.popularMovimentacao(request, response);
			}
		} catch (Exception e) {
			new RuntimeException("Ocorreu uma Exception no executa do AlterarMovimentacaoLogica...", e);
		}
	}
	
	public void alterarMovimentacao(HttpServletRequest request, HttpServletResponse response) {
			try {
				Movimentacao movimentacao = new Movimentacao();
				movimentacao.setMovimentacao_id(Integer.valueOf(request.getParameter("id")));
				movimentacao.setData(LocalDate.parse(request.getParameter("data")));

				movimentacao.setTipo(request.getParameter("tipo"));
				movimentacao.setOrigem(request.getParameter("origem"));
				movimentacao.setDestino(request.getParameter("destino"));
				
				Connection connection = (Connection) request.getAttribute("connection");
				MovimentacaoRepository movimentacaoDao = new MovimentacaoRepository(connection);
				movimentacaoDao.updateMovimentacao(movimentacao);
				
				response.sendRedirect("listar-movimentacoes-por-item.jsp");
				
			} catch (IOException e) {
				new RuntimeException("Ocorreu uma Exception no alterarMovimentacao do AlterarMovimentacaoLogica...", e);
			}
	}
	
	public void popularMovimentacao(HttpServletRequest request, HttpServletResponse response) {
		try {
			Movimentacao movimentacao = new Movimentacao();
			movimentacao.setMovimentacao_id(Integer.valueOf(request.getParameter("id")));
			Connection connection = (Connection) request.getAttribute("connection");
			movimentacao = new MovimentacaoRepository(connection).getMovimentacaoById(movimentacao);
			request.setAttribute("movimentacao", movimentacao);
			request.getRequestDispatcher("alterar-movimentacao.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			new RuntimeException("Ocorreu uma Exception no popularMovimentacao...", e);
		}
	}
}
