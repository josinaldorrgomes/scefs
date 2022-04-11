package br.com.ciahering.scefs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Local implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer local_id;
	private String nome;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Item> itens = new ArrayList<Item>();

	public Local() {
	}

	public Integer getLocal_id() {
		return local_id;
	}

	public void setLocal_id(Integer local_id) {
		this.local_id = local_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((local_id == null) ? 0 : local_id.hashCode());
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
		Local other = (Local) obj;
		if (local_id == null) {
			if (other.local_id != null)
				return false;
		} else if (!local_id.equals(other.local_id))
			return false;
		return true;
	}

}
