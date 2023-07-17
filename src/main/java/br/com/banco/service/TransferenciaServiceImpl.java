package br.com.banco.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import br.com.banco.DTO.TransferenciaDTO;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.util.TransferenciaMapper;
import br.com.banco.entity.Transferencia;

@Service
@Primary
public class TransferenciaServiceImpl implements TransferenciaService {
	
    @Autowired
    private TransferenciaRepository repository;
	
    @Autowired
	private TransferenciaMapper mapper;
	
	@Override
	public List<TransferenciaDTO> findAll(){	
		return mapper.toTransferenciaDTO(repository.findAll());
		
	}

}
