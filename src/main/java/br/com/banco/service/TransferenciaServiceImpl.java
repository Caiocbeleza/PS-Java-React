package br.com.banco.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import br.com.banco.DTO.TransferenciaDTO;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.util.TransferenciaMapper;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {
    private final TransferenciaRepository repository;

    private final TransferenciaMapper mapper;

    public TransferenciaServiceImpl(TransferenciaRepository repository, TransferenciaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TransferenciaDTO> findAll(){
        return mapper.toTransferenciaDTO(repository.findAll());

    }

    @Override
    public List<TransferenciaDTO> search(String nomeOperador) {
        if (nomeOperador != null){
            return repository.search(nomeOperador);
        }
        return mapper.toTransferenciaDTO(repository.findAll());
    }


}
