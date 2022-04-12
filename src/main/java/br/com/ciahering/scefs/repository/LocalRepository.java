package br.com.ciahering.scefs.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ciahering.scefs.model.Local;

public class LocalRepository {

	private Connection connection;

	public LocalRepository() {
	}

	public LocalRepository(Connection connection) {
		this.connection = connection;
	}

	public void addLocal(Local local) {
		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO public.local(nome) VALUES (?);");
			stmt.setString(1, local.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar adicionar o local: " + local.getNome(), e);
		}
	}

	public List<Local> getLocais() {
		try {
			List<Local> locais = new ArrayList<Local>();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT l.id, l.nome FROM public.local l ORDER BY l.id;");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Local local = new Local();
				local.setId(rs.getInt("id"));
				local.setNome(rs.getString("nome"));
				locais.add(local);
			}
			stmt.close();
			return locais;
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu uma Exception ao tentar listar os locais do banco de dados.", e);
		}
	}

	public void updateLocal(Local local) {
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE public.local SET nome=? WHERE id=?;");
			stmt.setInt(2, local.getId());
			stmt.setString(1, local.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar atualizar as informações do Local ID: "
					+ local.getId() + ", Nome: " + local.getNome(), e);
		}
	}

	public void deleteLocal(Local local) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM public.local l ON (l.id=?);");
			stmt.setInt(1, local.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu uma Exception ao tentar deletar o local de id = " + local.getId(), e);
		}
	}

	public Local getLocalById(Integer id) {
		Local local = new Local();
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT l.id, l.nome FROM public.local l WHERE l.id=?;");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				local.setId(rs.getInt("id"));
				local.setNome(rs.getString("nome"));
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(
					"Ocorreu um erro ao buscar o Local de id: " + local.getId(), e);
		}
		return local;
	}

	public Local getLocalByNome(String nome) {
		Local localSgbd = new Local();
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT l.id, l.nome FROM local l ON (l.nome=?);");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				localSgbd.setId(rs.getInt("id"));
				localSgbd.setNome(rs.getString("nome"));
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(
					"Ocorreu um erro ao buscar o Local de nome: " + localSgbd.getNome(), e);
		}
		return localSgbd;
	}

}
