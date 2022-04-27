package br.com.ciahering.scefs.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ciahering.scefs.model.Item;
import br.com.ciahering.scefs.model.Local;
import br.com.ciahering.scefs.model.Movimentacao;

public class MovimentacaoRepository {

	private Connection connection;

	public MovimentacaoRepository() {
	}

	public MovimentacaoRepository(Connection connection) {
		this.connection = connection;
	}

	public void addMovimentacao(Movimentacao movimentacao) {
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO public.movimentacao(data, tipo, local_id, item_id) VALUES (?, ?, ?, ?);");
			stmt.setDate(1, Date.valueOf(movimentacao.getData()));
			stmt.setString(2, movimentacao.getTipo());
			stmt.setInt(3, movimentacao.getLocal().getId());
			stmt.setInt(4, movimentacao.getItem().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu uma Exception no adicionar a nova movimentação. Data: " 
					+ movimentacao.getData() 
					+ ", Tipo: " + movimentacao.getTipo() 
					+ ", Local_id: " + movimentacao.getLocal().getId() 
					+ ", Item_id: " + movimentacao.getItem().getId(), e);
		}
	}

	public List<Movimentacao> getMovimentacoesByItem(Item item) {
		try {
			List<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT * FROM public.movimentacao INNER JOIN public.item i ON (i.id=?);");
			stmt.setInt(1, item.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Movimentacao movimentacao = new Movimentacao();
				movimentacao.setId(rs.getInt("id"));
				movimentacao.setData(rs.getDate("data").toLocalDate());
				movimentacao.setTipo(rs.getString("tipo"));
				Local local = new Local();
				local.setId(Integer.valueOf(rs.getString("local_id")));
				movimentacao.setLocal(local);
				Item itemSgbd = new Item();
				itemSgbd.setId(rs.getInt("id"));
				movimentacao.setItem(itemSgbd);
				movimentacoes.add(movimentacao);
			}
			stmt.close();
			return movimentacoes;
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro ao listar as movimentações do item de id: " + item.getId(), e);
		}
	}

	public void updateMovimentacao(Movimentacao movimentacao) {
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE public.movimentacao m SET m.data=?, m.tipo=?, m.local_id=?, m.item_id=? ON (m.id=?);");
			stmt.setInt(5, movimentacao.getId());
			stmt.setDate(1, Date.valueOf(movimentacao.getData()));
			stmt.setString(2, movimentacao.getTipo());
			stmt.setInt(3, movimentacao.getLocal().getId());
			stmt.setInt(4, movimentacao.getItem().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu uma Exception no alterarMovimentacao.", e);
		}
	}

	public void deleteMovimentacao(Movimentacao movimentacao) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM public.movimentacao ON (id =?);");
			stmt.setInt(1, movimentacao.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu uma Exception no deleteMovimentacao.", e);
		}
	}

	public Movimentacao getMovimentacaoById(Movimentacao movimentacao) {
		Movimentacao movimentacaoSgbd = new Movimentacao();
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT m.id, m.data, m.tipo, m.local_id, m.item_id FROM public.movimentacao m INNER JOIN public.item i ON (m.id=? AND m.item_id=i.id);");
			stmt.setInt(1, movimentacao.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				movimentacaoSgbd.setId(rs.getInt("id"));
				movimentacaoSgbd.setData(rs.getDate("data").toLocalDate());
				Local local = new Local();
				local.setId(Integer.valueOf(rs.getString("local_id")));
				movimentacao.setLocal(local);
				movimentacaoSgbd.setTipo(rs.getString("tipo"));
				Item item = new Item();
				item.setId(rs.getInt("id"));
				movimentacaoSgbd.setItem(item);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu uma Exception no getMovimentacaoById.", e);
		}
		return movimentacaoSgbd;
	}

}
