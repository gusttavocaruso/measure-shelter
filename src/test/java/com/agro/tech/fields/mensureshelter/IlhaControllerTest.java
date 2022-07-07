package com.agro.tech.fields.mensureshelter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.agro.tech.fields.mensureshelter.model.Ilha;
import com.agro.tech.fields.mensureshelter.repository.IlhaRepository;
import com.agro.tech.fields.mensureshelter.service.IlhaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IlhaControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private IlhaRepository ilhaRepository;

  @MockBean
  private IlhaService ilhaService;

  @BeforeEach
  public void setup() {
    ilhaRepository.deleteAll();
  }

  @Test
  void deveRetornarStatusOk() throws Exception {

    mockMvc.perform(get("/ilha"))
        .andExpect(content().contentType("application/json"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("[]")));
  }

  @Test
  public void deveAdicionarNovaIlha() throws Exception {

    // Map<String, String> mockIlha = Map.of("nome", "Ilha da magia", "status", "Online");
    Ilha ilhaMock = new Ilha("Ilha do Gov", "Off");

    mockMvc.perform(post("/ilha/criar")
        .contentType("application/json")
        .content(new ObjectMapper().writeValueAsString(ilhaMock)))
          // .andExpect(content().contentType("application/json"))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.nome").value("Ilha da magia"));
  }

}

// doReturn(List.of()).when(ilhaService).searchIlhas();
// mockMvc.perform(get("/ilha/criar"));

