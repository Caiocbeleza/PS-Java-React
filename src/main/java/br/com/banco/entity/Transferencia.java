package br.com.banco.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Table(name = "TRANSFERENCIA")
public class Transferencia {
	
	@Id
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "DATA_TRANSFERENCIA")
	private LocalDate dt;
	
	@Column(name = "VALOR")
	private Double valor;
	
	@Column(name = "TIPO")
	private String tipo;
	
	@Column(name = "NOME_OPERADOR_TRANSACAO")
	private String nomeOperador;
	
	@ManyToOne
	private Conta contaId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDt() {
		return dt;
	}

	public void setDt(LocalDate dt) {
		this.dt = dt;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNomeOperador() {
		return nomeOperador;
	}

	public void setNomeOperador(String nomeOperador) {
		this.nomeOperador = nomeOperador;
	}

	public Conta getContaId() {
		return contaId;
	}

	public void setContaId(Conta contaId) {
		this.contaId = contaId;
	}
	
	public Transferencia() {
	}
	
	@Builder
	public Transferencia(LocalDate dt, Double valor, String tipo, String nomeOperador) {
		this.dt = dt;
		this.valor = valor;
		this.tipo = tipo;
		this.nomeOperador = nomeOperador;
		
	}
}