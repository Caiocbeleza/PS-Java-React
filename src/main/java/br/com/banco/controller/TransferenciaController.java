package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.DTO.TransferenciaDTO;
import br.com.banco.service.TransferenciaService;
import lombok.RequiredArgsConstructor;

@RestController
public class TransferenciaController {

    private final TransferenciaService service;

    public TransferenciaController(TransferenciaService service) {
        this.service = service;
    }

    @GetMapping(value = "/transferencias")
    private ResponseEntity<List<TransferenciaDTO>> findAll(){
        return ResponseEntity.ok().body(this.service.findAll());

    }

    @GetMapping(value = "/filtrar")
    public ResponseEntity<List<TransferenciaDTO>> search(@Param("nomeOperador") String nomeOperador){
        return ResponseEntity.ok().body(this.service.search(nomeOperador));
    }

}