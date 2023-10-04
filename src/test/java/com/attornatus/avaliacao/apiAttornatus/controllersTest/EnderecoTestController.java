package com.attornatus.avaliacao.apiAttornatus.controllersTest;

import com.attornatus.avaliacao.apiAttornatus.controllers.EnderecoController;
import com.attornatus.avaliacao.apiAttornatus.controllers.PessoaController;
import com.attornatus.avaliacao.apiAttornatus.dtos.EnderecoDTO;
import com.attornatus.avaliacao.apiAttornatus.dtos.PessoaDTO;
import com.attornatus.avaliacao.apiAttornatus.entities.Endereco;
import com.attornatus.avaliacao.apiAttornatus.services.EnderecoService;
import com.attornatus.avaliacao.apiAttornatus.services.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = EnderecoController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class EnderecoTestController {
    @Autowired
    private MockMvc mock;

    @MockBean
    private EnderecoService service;

    @Autowired
    private ObjectMapper mapper;

    private PessoaDTO pessoa;
    private EnderecoDTO endereco;

    @BeforeEach
    public void init(){
        endereco = new EnderecoDTO("Rua de Marte",null,98,null);
    }
    @Test
    @DisplayName("Verificando se a API responde com 400 Bad Request para requisição sem campos requeridos")
    public void EnderecoController_criar_endereco_retorna_400BadRequest() throws Exception{
        ResultActions result = mock.perform(post("/pessoa/1/endereco").
                contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(endereco)));
        result.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
