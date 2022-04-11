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
import br.com.ciahering.scefs.model.dto.ItemDTO;

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
			stmt.setInt(6, item.getLocal().getLocal_id());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar adicionar um novo item. "
					+ "Segue as informações enviadas pela View. Data de aquisição: " + item.getData_de_aquisicao() + ", "
							+ "data de cadastro: " + item.getData_de_cadastro() + ", "
							+ "marca: " + item.getMarca() + ", "
							+ "modelo: " + item.getModelo() + ", "
							+ "patrimônio: " + item.getPatrimonio() + ", "
							+ "local: " + item.getLocal(), e);
		}
	}

	public List<Item> getItens() {
		try {
			List<Item> itens = new ArrayList<>();
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT i.item_id, i.data_de_aquisicao, i.data_de_cadastro, i.marca, i.modelo, i.patrimonio, l.nome FROM public.item i INNER JOIN public.local l ON (i.local_id = l.local_id);");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Item item = new Item();
				item.setItem_id(rs.getInt("item_id"));
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
					"UPDATE public.item i SET i.dataDeAquisicao=?, i.data_de_cadastro=?, i.marca=?, i.modelo=?, i.patrimonio=?, l.local_id=? INNER JOIN public.local l ON (l.nome=? AND i.item_id=?);");
			stmt.setInt(8, item.getItem_id());
			stmt.setDate(1, Date.valueOf(item.getData_de_aquisicao()));
			stmt.setDate(2, Date.valueOf(item.getData_de_cadastro()));
			stmt.setString(3, item.getMarca());
			stmt.setString(4, item.getModelo());
			stmt.setInt(5, item.getPatrimonio());
			stmt.setString(6, item.getLocal().getNome());
			stmt.setInt(7, item.getLocal().getLocal_id());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro na alteração de item do método alterarItem. Verificar se os parâmetros vieram corretos.", e);
		}
	}

	public void deleteItem(Item item) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM public.item WHERE item_id=?;");
			stmt.setInt(1, item.getItem_id());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu uma Exception no removerItem.", e);
		}
	}

	public Item getItemById(Item item) {
		Item itemSgbd = new Item();
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT i.item_id, i.data_de_aquisicao, i.data_de_cadastro, i.patrimonio, i.marca, i.modelo, l.local_id, l.nome FROM public.item i INNER JOIN public.local l ON (i.local_id = l.local_id AND i.item_id=?);");
			stmt.setInt(1, item.getItem_id());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				itemSgbd.setItem_id(rs.getInt("item_id"));
				itemSgbd.setData_de_aquisicao(rs.getDate("data_de_aquisicao").toLocalDate());
				itemSgbd.setData_de_cadastro(rs.getDate("data_de_cadastro").toLocalDate());
				itemSgbd.setMarca(rs.getString("marca"));
				itemSgbd.setModelo(rs.getString("modelo"));
				itemSgbd.setPatrimonio(rs.getInt("patrimonio"));
				Local local = new Local();
				local.setLocal_id(rs.getInt("local_id"));
				local.setNome(rs.getString("nome"));
				itemSgbd.setLocal(local);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar o item " + item.getItem_id() + ". Verificar!", e);
		}
		return itemSgbd;
	}
	
	public Item getItemByPatrimonio(Item i) {
		Item item = new Item();
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT i.patrimonio FROM public.item i ON (i.patrimonio=?);");
			stmt.setInt(1, item.getPatrimonio());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				item.setPatrimonio(rs.getInt("patrimonio"));
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao buscar o patrimônio.", e);
		}
		return item;
	}

	public List<ItemDTO> getItensByLocal() {
		try {
			List<ItemDTO> itensPorLocal = new ArrayList<ItemDTO>();
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT l.nome AS local, COUNT(i.patrimonio) AS quantidade FROM (public.item i INNER JOIN public.local l ON ((l.local_id = i.local_id))) GROUP BY l.nome;");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ItemDTO itemDto = new ItemDTO();
				itemDto.setLocal(rs.getString("local"));
				itemDto.setQuantidade(rs.getInt("quantidade"));
				itensPorLocal.add(itemDto);
			}
			stmt.close();
			return itensPorLocal;
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu uma Exception ao tentar buscar os itens por local.", e);
		}
	}

}
