package br.com.ciahering.scefs.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ciahering.scefs.model.dto.ItemDTO;
import br.com.ciahering.scefs.repository.ItemRepository;

@WebServlet("/itensPorlocal")
public class ListarItensPorLocaisController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ItemRepository repository;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection connection = (Connection) request.getAttribute("connection");
			repository = new ItemRepository(connection);
			List<ItemDTO> itensPorlocal = repository.getItensByLocal();
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("itensPorlocal", itensPorlocal);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um problema ao listar os dados do dashboard.", e);
		}
	}

}
