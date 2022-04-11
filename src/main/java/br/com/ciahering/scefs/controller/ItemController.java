package br.com.ciahering.scefs.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ciahering.scefs.model.Item;
import br.com.ciahering.scefs.repository.ItemRepository;

@WebServlet
public class ItemController extends HttpServlet {

	private static final long serialVersionUID = 1L;	

	public void getItens(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection connection = (Connection) request.getAttribute("connection");
			List<Item> itens = new ItemRepository(connection).getItens();
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("itens", itens);
			request.getRequestDispatcher("listar-itens.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu uma Exception no listarItens do ListarItensLogica...", e);
		}
	}
	
}
