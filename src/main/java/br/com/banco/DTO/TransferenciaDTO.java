package br.com.banco.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import br.com.banco.entity.Transferencia;
import org.springframework.format.annotation.DateTimeFormat;


public class TransferenciaDTO {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dt;
    private Double valor;
    private String tipo;
    private String nomeOperador;

    public TransferenciaDTO() {}

    public TransferenciaDTO(LocalDate dt, Double valor, String tipo, String nomeOperador) {
        this.dt = dt;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperador = nomeOperador;
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

    public TransferenciaDTO(Transferencia transferencia) {
        this.dt = transferencia.getDt();
        this.valor = transferencia.getValor();
        this.tipo = transferencia.getTipo();
        this.nomeOperador = transferencia.getNomeOperador();
    }

}
