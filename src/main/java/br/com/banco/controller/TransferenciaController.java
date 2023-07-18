package br.com.banco.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

//    @GetMapping(value = "/filtrar")
//    public ResponseEntity<List<TransferenciaDTO>> search(@Param("nomeOperador") String nomeOperador){
//        return ResponseEntity.ok().body(this.service.search(nomeOperador));
//    }
//
//    @GetMapping(value = "/filtrar-data")
//    public ResponseEntity<List<TransferenciaDTO>> buscarPorData(@RequestParam("inicio") @DateTimeFormat(pattern= "yyyy-MM-dd") LocalDate inicio, @RequestParam("fim") @DateTimeFormat(pattern= "yyyy-MM-dd") LocalDate fim){
//        return ResponseEntity.ok().body(this.service.procurarPorData(inicio, fim));
//    }

    @GetMapping(value = "/procurar-filtros")
    public ResponseEntity<List<TransferenciaDTO>> procurar(@Param("nomeOperador") String nomeOperador, @Param("inicio") @DateTimeFormat(pattern= "yyyy-MM-dd") LocalDate inicio, @Param("fim") @DateTimeFormat(pattern= "yyyy-MM-dd") LocalDate fim){
        return ResponseEntity.ok().body(this.service.procurar(nomeOperador, inicio, fim));
    }

}