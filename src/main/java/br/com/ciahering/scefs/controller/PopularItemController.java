package br.com.ciahering.scefs.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ciahering.scefs.model.Item;
import br.com.ciahering.scefs.repository.ItemRepository;

@WebServlet("/popularItem")
public class PopularItemController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ItemRepository repository = new ItemRepository();

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection connection = (Connection) request.getAttribute("connection");
			Item item = new ItemRepository(connection).getItemById(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("item", item);
			request.getRequestDispatcher("alterar-item.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			new RuntimeException("Ocorreu um erro ao popular os dados do item. Id = " + request.getParameter("id"), e);
		}
	}

}
