package br.com.banco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTA")
public class Conta {
	
	@Id
	@Column(name = "ID_CONTA", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "NOME_RESPONSAVEL")
	private String nomeResp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeResp() {
		return nomeResp;
	}

	public void setNomeResp(String nomeResp) {
		this.nomeResp = nomeResp;
	}

}
