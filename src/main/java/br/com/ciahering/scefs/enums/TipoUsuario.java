package br.com.ciahering.scefs.enums;

public enum TipoUsuario {

	GERENTE(1, "GERENTE"), COORDENADOR(2, "COORDENADOR"), LIDER(3, "L�DER"), TECNICO(4, "T�CNICO");

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
