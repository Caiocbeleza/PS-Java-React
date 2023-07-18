package br.com.banco.controller;


import br.com.banco.DTO.TransferenciaDTO;
import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

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
    TransferenciaRepository repository;

    @Test
    void buscarTransacoes() throws Exception{
        var transferencia = new TransferenciaDTO();
        transferencia.setNomeOperador("Fulano");
        Mockito.when(repository.pegarTodosRegistros()).thenReturn(List.of(transferencia));
        this.mockMvc.perform(get("/transferencias"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{'dt': null, 'valor': null, 'tipo':null, 'nomeOperador':'Fulano'}]"));
    }

}
