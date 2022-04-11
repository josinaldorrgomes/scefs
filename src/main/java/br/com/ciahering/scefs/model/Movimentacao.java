package br.com.ciahering.scefs.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Movimentacao implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer movimentacao_id;
	private LocalDate data;
	private String tipo;
	private String origem;
	private String destino;
	private Item item;

	public Movimentacao() {
	}

	public Integer getMovimentacao_id() {
		return movimentacao_id;
	}

	public void setMovimentacao_id(Integer movimentacao_id) {
		this.movimentacao_id = movimentacao_id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movimentacao_id == null) ? 0 : movimentacao_id.hashCode());
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
		Movimentacao other = (Movimentacao) obj;
		if (movimentacao_id == null) {
			if (other.movimentacao_id != null)
				return false;
		} else if (!movimentacao_id.equals(other.movimentacao_id))
			return false;
		return true;
	}

}
