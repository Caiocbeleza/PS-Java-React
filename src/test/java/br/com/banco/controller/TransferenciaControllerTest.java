package br.com.banco.controller;


import br.com.banco.DTO.TransferenciaDTO;
import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.service.TransferenciaService;
import br.com.banco.service.TransferenciaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransferenciaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TransferenciaServiceImpl service;


    @Test
    void buscarTransacoes() throws Exception{
        var transferencia = new TransferenciaDTO();
        transferencia.setNomeOperador("Fulano");
        Mockito.when(service.findAll()).thenReturn(List.of(transferencia));
        this.mockMvc.perform(get("/transferencias"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{'dt': null, 'valor': null, 'tipo':null, 'nomeOperador':'Fulano'}]"));
    }

    @Test
    void buscarComFiltro() throws Exception{
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("nomeOperador", "Beltrano");

        this.mockMvc.perform(get("/procurar-filtros").params(requestParams)).andExpect(status().isOk());

    }

}
