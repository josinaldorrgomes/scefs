package br.com.ciahering.scefs.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ciahering.scefs.model.Usuario;
import br.com.ciahering.scefs.model.dto.ItemDTO;
import br.com.ciahering.scefs.repository.ItemRepository;
import br.com.ciahering.scefs.repository.UsuarioRepository;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			Usuario usuario = new Usuario(request.getParameter("login"), request.getParameter("senha"));
			Connection connection = (Connection) request.getAttribute("connection");
			Boolean autenticacao = new UsuarioRepository(connection).login(usuario);
			List<ItemDTO> itensPorLocal = new ItemRepository(connection).getItensByLocal();
			if (autenticacao) {
				session.setAttribute("usuario", usuario);
				session.setAttribute("itensPorLocal", itensPorLocal);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			new RuntimeException("Ocorreu um erro no método login. Verificar se os parâmetros do Frontend vieram corretos!", e);
		}
	}

}
