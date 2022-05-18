package br.com.ciahering.scefs.model.dto;

import java.io.Serializable;

public class ItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String local;
	private Integer quantidade;

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
