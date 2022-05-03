package br.com.ciahering.scefs.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private LocalDate data_de_aquisicao;
	private LocalDate data_de_cadastro;
	private String marca;
	private String modelo;
	private Integer patrimonio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
