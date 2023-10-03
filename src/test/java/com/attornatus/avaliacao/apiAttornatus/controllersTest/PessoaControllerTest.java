package com.attornatus.avaliacao.apiAttornatus.controllersTest;

import com.attornatus.avaliacao.apiAttornatus.controllers.PessoaController;
import com.attornatus.avaliacao.apiAttornatus.dtos.PessoaDTO;
import com.attornatus.avaliacao.apiAttornatus.entities.Endereco;
import com.attornatus.avaliacao.apiAttornatus.entities.Pessoa;
import com.attornatus.avaliacao.apiAttornatus.services.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PessoaController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class PessoaControllerTest {

    @Autowired
    private MockMvc mock;

    @MockBean
    private PessoaService service;

    @Autowired
    private ObjectMapper mapper;

    private PessoaDTO pessoa;
    private Endereco endereco;

    @BeforeEach
    public void init(){
        pessoa = new PessoaDTO("nome","12/12/2022");
    }

    @Test
    @DisplayName("Verificando se a API responde com 201 created em requisições de criar pessoas bem sucedidas")
    public void PessoaController_criar_pessoa_retorna_201Created() throws Exception{
        ResultActions result = mock.perform(post("/pessoa").
                contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(pessoa)));
        result.andExpect(MockMvcResultMatchers.status().isCreated());
    }
    @Test
    @DisplayName("Verficar se Api responde com 400BadRequest para requisições com nome nulos")
    public void PessoaController_criar_pessoa_com_nomenulo_retorna_400BadRequest() throws Exception{
        PessoaDTO dto = new PessoaDTO(null,"12/12/2023");
        ResultActions result = mock.perform(post("/pessoa").
                contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(dto)));
        result.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
