package br.com.ciahering.scefs.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ciahering.scefs.model.Usuario;

public class UsuarioRepository {

	private Connection connection;

	public UsuarioRepository() {
	}

	public UsuarioRepository(Connection connection) {
		this.connection = connection;
	}
	
	public void addUsuario(Usuario usuario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO public.usuario(login, senha, tipo, local_id) VALUES (?, ?, ?, ?);");
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setInt(3, usuario.getTipo().getCod());
			stmt.setInt(4, usuario.getLocal().getLocal_id());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao adicionar o usuário. Verificar se os dados do Front-end vieram corretos! [ Dados fornecidos: "
					+ "Login: " + usuario.getLogin() + ", Senha: " + usuario.getSenha() + " ]", e);
		}
	}

	public boolean login(Usuario usuario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM public.usuario WHERE login=? and senha=?");
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("login").equals(usuario.getLogin())) {
					if (rs.getString("senha").equals(usuario.getSenha())) {
						return true;
					}
				}
			}
			stmt.close();
		} catch (SQLException e) {
			new RuntimeException("Erro no método de login. Verificar se os dados do Frontend foram repassados corretamente!", e);
		}
		return false;
	}
}
