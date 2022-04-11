package br.com.ciahering.scefs.controller;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ciahering.scefs.model.Item;
import br.com.ciahering.scefs.model.Local;
import br.com.ciahering.scefs.repository.ItemRepository;

@WebServlet("/alterarItem")
public class AlterarItemController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ItemRepository repository;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			Item item = new Item();
			item.setItem_id(Integer.valueOf(request.getParameter("item_id")));
			item.setData_de_aquisicao(LocalDate.parse(request.getParameter("data_de_aquisicao")));
			item.setData_de_cadastro(LocalDate.parse(request.getParameter("data_de_cadastro")));
			item.setMarca(request.getParameter("marca"));
			item.setModelo(request.getParameter("modelo"));
			item.setPatrimonio(Integer.valueOf(request.getParameter("patrimonio")));
			Local local = new Local();
			local.setLocal_id(Integer.valueOf(request.getParameter("local_id")));
			item.setLocal(local);
			Connection connection = (Connection) request.getAttribute("connection");
			repository = new ItemRepository(connection);
			repository.updateItem(item);
			request.getRequestDispatcher("listar-itens.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			new RuntimeException("Erro na alteração do item. Verificar se os dados do Front-end estão corretos.", e);
		}
	}

}
