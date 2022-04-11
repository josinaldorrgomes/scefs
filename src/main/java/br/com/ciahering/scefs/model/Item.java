package br.com.ciahering.scefs.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer item_id;
	private LocalDate data_de_aquisicao;
	private LocalDate data_de_cadastro;
	private String marca;
	private String modelo;
	private Integer patrimonio;
	private Local local;
	private List<Movimentacao> movimentacoes = new ArrayList<>();

	public Item() {
	}

	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	public LocalDate getData_de_aquisicao() {
		return data_de_aquisicao;
	}

	public void setData_de_aquisicao(LocalDate data_de_aquisicao) {
		this.data_de_aquisicao = data_de_aquisicao;
	}

	public LocalDate getData_de_cadastro() {
		return data_de_cadastro;
	}

	public void setData_de_cadastro(LocalDate data_de_cadastro) {
		this.data_de_cadastro = data_de_cadastro;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(Integer patrimonio) {
		this.patrimonio = patrimonio;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		return true;
	}

}
