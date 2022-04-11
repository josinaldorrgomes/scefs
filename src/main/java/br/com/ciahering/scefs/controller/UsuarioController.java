package br.com.ciahering.scefs.controller;

import java.sql.Connection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ciahering.scefs.model.Usuario;
import br.com.ciahering.scefs.repository.UsuarioRepository;

@WebServlet("/login")
public class UsuarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			Usuario usuario = new Usuario(request.getParameter("login"), request.getParameter("senha"));
			Connection connection = (Connection) request.getAttribute("connection");
			Boolean autenticacao = new UsuarioRepository(connection).login(usuario);
			if (autenticacao) {
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuario", usuario);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			new RuntimeException("Ocorreu um erro no método login. Verificar se os parâmetros do Frontend vieram corretos!", e);
		}
	}

}
