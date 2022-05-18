package br.com.ciahering.scefs.enums;

public enum TipoMovimentacao {

	DEVOLUCAO_AO_FORNECEDOR("DEVOLU��O AO FORNECEDOR"),
	REMESSA_PARA_CONSERTO("REMESSA PARA CONSERTO"),
	REMESSA_PARA_EMPRESTIMO("REMESSA PARA EMPR�STIMO"),
	TRANSFERENCIA_DE_PATRIMONIO("TRANSFER�NCIA DE PATRIM�NIO");

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
