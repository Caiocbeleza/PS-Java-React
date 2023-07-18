package br.com.banco.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.com.banco.DTO.TransferenciaDTO;

public interface TransferenciaService {

    List<TransferenciaDTO> findAll();

    List<TransferenciaDTO> search(String nomeOperador);

    List<TransferenciaDTO> procurarPorData(LocalDate inicio, LocalDate fim);

}
