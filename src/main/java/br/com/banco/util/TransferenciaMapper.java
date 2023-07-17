package br.com.banco.util;

import java.util.List;
import java.util.stream.Collectors;

import br.com.banco.DTO.TransferenciaDTO;
import br.com.banco.entity.Transferencia;
import org.springframework.stereotype.Component;

@Component
public class TransferenciaMapper {

    public List<TransferenciaDTO> toTransferenciaDTO(List<Transferencia> transferencias){

        return transferencias.stream().map(TransferenciaDTO::new).collect(Collectors.toList());

    }

}
