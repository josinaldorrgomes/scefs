package br.com.ciahering.scefs.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na classe LogoutUsuarioLogica...", e);
		}
	}
}
