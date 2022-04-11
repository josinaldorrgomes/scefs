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
			PreparedStatement stmt = connection.prepareStatement("SELECT l.local_id, l.nome FROM public.local l ORDER BY l.local_id;");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Local local = new Local();
				local.setLocal_id(rs.getInt("local_id"));
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
			PreparedStatement stmt = connection.prepareStatement("UPDATE public.local l SET l.nome=? ON (l.local_id=?);");
			stmt.setInt(2, local.getLocal_id());
			stmt.setString(1, local.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar atualizar as informações do Local ID: " + local.getLocal_id() + ", Nome: " + local.getNome(), e);
		}
	}

	public void deleteLocal(Local local) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM public.local ON (local_id=?);");
			stmt.setInt(1, local.getLocal_id());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu uma Exception ao tentar deletar um local.", e);
		}
	}

	public Local getLocalById(Local local) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT l.local_id, l.nome FROM local l WHERE l.local_id=?;");
			stmt.setInt(1, local.getLocal_id());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				local.setLocal_id(rs.getInt("local_id"));
				local.setNome(rs.getString("nome"));
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar atualizar as informações do Local ID: " + local.getLocal_id(), e);
		}
		return local;
	}

	public Local getLocalByNome(String local) {
		Local localSgbd = new Local();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT l.local_id, l.nome FROM local l ON (l.nome=?);");
			stmt.setString(1, local);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				localSgbd.setLocal_id(rs.getInt("local_id"));
				localSgbd.setNome(rs.getString("nome"));
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar atualizar as informações do Local NOME: " + localSgbd.getNome(), e);
		}
		return localSgbd;
	}

}
