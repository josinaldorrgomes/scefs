package br.com.ciahering.scefs.controller;

import java.sql.Connection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ciahering.scefs.model.Item;
import br.com.ciahering.scefs.repository.ItemRepository;

@WebServlet("/removerItem")
public class RemoverItemController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			Item item = new Item();
			item.setItem_id(Integer.valueOf(request.getParameter("item_id")));
			Connection connection = (Connection) request.getAttribute("connection");
			ItemRepository itemDao = new ItemRepository(connection);
			itemDao.deleteItem(item);
			response.sendRedirect("listar-itens.jsp");
		} catch (Exception e) {
			new RuntimeException("Ocorreu um erro ao tentar deletar o item.", e);
		}
	}

}
