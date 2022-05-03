package br.com.ciahering.scefs.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.ciahering.scefs.model.Item;
import br.com.ciahering.scefs.model.Local;

public class ItemRepository {

	private Connection connection;

	public ItemRepository() {
	}

	public ItemRepository(Connection connection) {
		this.connection = connection;
	}

	public void addItem(Item item) {
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO public.item(data_de_aquisicao, data_de_cadastro, marca, modelo, patrimonio, local_id) "
					+ "VALUES (?, ?, ?, ?, ?, ?);");
			stmt.setDate(1, Date.valueOf(item.getData_de_aquisicao()));
			stmt.setDate(2, Date.valueOf(LocalDate.now()));
			stmt.setString(3, item.getMarca());
			stmt.setString(4, item.getModelo());
			stmt.setInt(5, item.getPatrimonio());
			stmt.setInt(6, item.getLocal().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar adicionar um novo item. "
					+ "Segue as informações enviadas pelo front-end. Data de aquisição: " + item.getData_de_aquisicao() + ", "
							+ "data de cadastro: " + item.getData_de_cadastro() + ", "
							+ "marca: " + item.getMarca() + ", "
							+ "modelo: " + item.getModelo() + ", "
							+ "patrimônio: " + item.getPatrimonio() + ", "
							+ "local: " + item.getLocal().getId(), e);
		}
	}

	public List<Item> getItens() {
		try {
			List<Item> itens = new ArrayList<>();
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT i.id, i.data_de_aquisicao, i.data_de_cadastro, i.marca, i.modelo, i.patrimonio, l.nome FROM public.item i INNER JOIN public.local l ON (i.local_id = l.id) ORDER BY i.id;");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setData_de_aquisicao(rs.getDate("data_de_cadastro").toLocalDate());
				item.setData_de_cadastro(rs.getDate("data_de_cadastro").toLocalDate());
				item.setMarca(rs.getString("marca"));
				item.setModelo(rs.getString("modelo"));
				item.setPatrimonio(rs.getInt("patrimonio"));				
				Local local = new Local();
				local.setNome(rs.getString("nome"));				
				item.setLocal(local);
				itens.add(item);
			}
			stmt.close();
			return itens;
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro na listagems de itens. Verifique se a Query está correta e se a rota do Front-end está correta.", e);
		}
	}

	public void updateItem(Item item) {
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE public.item SET data_de_aquisicao=?, data_de_cadastro=?, marca=?, modelo=?, patrimonio=? WHERE id=?;");
			stmt.setInt(6, item.getId());
			stmt.setDate(1, Date.valueOf(item.getData_de_aquisicao()));
			stmt.setDate(2, Date.valueOf(item.getData_de_cadastro()));
			stmt.setString(3, item.getMarca());
			stmt.setString(4, item.getModelo());
			stmt.setInt(5, item.getPatrimonio());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro na alteração do item. Patrimônio: " + item.getPatrimonio(), e);
		}
	}

	public void deleteItem(Item item) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM public.item i WHERE i.id=?;");
			stmt.setInt(1, item.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar deletar o item de id: " + item.getId(), e);
		}
	}

	public Item getItemById(Integer id) {
		Item item = new Item();
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT i.id, i.data_de_aquisicao, i.data_de_cadastro, i.patrimonio, i.marca, i.modelo, l.id, l.nome FROM public.item i INNER JOIN public.local l ON (i.local_id = l.id AND i.id=?);");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				item.setId(rs.getInt("id"));
				item.setData_de_aquisicao(rs.getDate("data_de_aquisicao").toLocalDate());
				item.setData_de_cadastro(rs.getDate("data_de_cadastro").toLocalDate());
				item.setMarca(rs.getString("marca"));
				item.setModelo(rs.getString("modelo"));
				item.setPatrimonio(rs.getInt("patrimonio"));
				Local local = new Local();
				local.setId(rs.getInt("id"));
				local.setNome(rs.getString("nome"));
				item.setLocal(local);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar o item de id " + item.getId() + ". Verificar!", e);
		}
		return item;
	}
	
	public Item getItemByPatrimonio(Integer patrimonio) {
		Item item = new Item();
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT i.patrimonio FROM public.item i WHERE i.patrimonio=?;");
			stmt.setInt(1, patrimonio);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				item.setPatrimonio(rs.getInt("patrimonio"));
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao buscar o patrimônio " + patrimonio, e);
		}
		return item;
	}

}
