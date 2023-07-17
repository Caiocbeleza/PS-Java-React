package br.com.banco.service;

import java.util.List;

import br.com.banco.DTO.TransferenciaDTO;

public interface TransferenciaService {

    List<TransferenciaDTO> findAll();

}
