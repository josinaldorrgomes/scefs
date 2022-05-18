package br.com.ciahering.scefs.enums;

public enum TipoMovimentacao {

	DEVOLUCAO_AO_FORNECEDOR("DEVOLUÇÃO AO FORNECEDOR"),
	REMESSA_PARA_CONSERTO("REMESSA PARA CONSERTO"),
	REMESSA_PARA_EMPRESTIMO("REMESSA PARA EMPRÉSTIMO"),
	TRANSFERENCIA_DE_PATRIMONIO("TRANSFERÊNCIA DE PATRIMÔNIO");

	private String descricao;

	private TipoMovimentacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
