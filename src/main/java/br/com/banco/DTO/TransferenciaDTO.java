package br.com.banco.DTO;

import java.time.LocalDateTime;

import br.com.banco.entity.Transferencia;
import com.fasterxml.jackson.annotation.JsonFormat;


public class TransferenciaDTO {

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime dt;
    private Double valor;
    private String tipo;
    private String nomeOperador;

    public TransferenciaDTO() {}

    public TransferenciaDTO(LocalDateTime dt, Double valor, String tipo, String nomeOperador) {
        this.dt = dt;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperador = nomeOperador;
    }

    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(LocalDateTime dt) {
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

    public TransferenciaDTO(Transferencia transferencia) {
        this.dt = transferencia.getDt();
        this.valor = transferencia.getValor();
        this.tipo = transferencia.getTipo();
        this.nomeOperador = transferencia.getNomeOperador();
    }

}
