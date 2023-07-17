package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.DTO.TransferenciaDTO;
import br.com.banco.service.TransferenciaService;
import lombok.RequiredArgsConstructor;

@RestController
public class TransferenciaController {
	
	@Autowired private TransferenciaService service;
	
	@GetMapping(value = "/transferencias")
	private ResponseEntity<List<TransferenciaDTO>> findAll(){
		return ResponseEntity.ok().body(this.service.findAll());
				
	}

}
