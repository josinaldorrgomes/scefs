package br.com.ciahering.scefs.enums;

public enum TipoUsuario {

	DIRETOR(1, "DIRETOR"),
	GERENTE(2, "GERENTE"),
	COORDENADOR(3, "COORDENADOR"),
	LIDER(4, "L�DER"),
	ANALISTA(5, "ANALISTA"),
	TECNICO(6, "T�CNICO");

	private int cod;
	private String descricao;

	private TipoUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
