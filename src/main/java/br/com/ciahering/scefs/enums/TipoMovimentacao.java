package br.com.ciahering.scefs.enums;

public enum TipoMovimentacao {

	DEVOLUCAO(1, "Devolu��o ao fornecedor"),
	CONSERTO(2, "Remessa para conserto"),
	EMPRESTIMO(3, "Remessa para empr�stimo"),
	TRANSFERENCIA(4, "Transfer�ncia de patrim�nio");

	private int cod;
	private String descricao;

	private TipoMovimentacao(int cod, String descricao) {
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
