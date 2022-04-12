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

@WebServlet("/cadastrarItem")
public class CadastrarItemController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection connection = (Connection) request.getAttribute("connection");
			Item item = new Item();
			item.setData_de_aquisicao(LocalDate.parse(request.getParameter("data_de_aquisicao")));
			item.setData_de_cadastro(LocalDate.now());
			item.setMarca(request.getParameter("marca"));
			item.setModelo(request.getParameter("modelo"));
			item.setPatrimonio(Integer.valueOf(request.getParameter("patrimonio")));
			Local local = new Local();
			local.setId(Integer.valueOf(request.getParameter("local_id")));
			item.setLocal(local);
			ItemRepository repository = new ItemRepository(connection);
			repository.addItem(item);
			request.getRequestDispatcher("cadastrar-item.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			new RuntimeException("Ocorreu um erro ao tentar cadastrar um novo item.", e);
		}
	}

}
