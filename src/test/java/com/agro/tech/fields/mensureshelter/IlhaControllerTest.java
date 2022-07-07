package com.agro.tech.fields.mensureshelter;

/* import org.junit.jupiter.api.BeforeEach;
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

} */

// doReturn(List.of()).when(ilhaService).searchIlhas();
// mockMvc.perform(get("/ilha/criar"));


import com.agro.tech.fields.mensureshelter.model.Ilha;
import com.agro.tech.fields.mensureshelter.repository.IlhaRepository;

import de.flapdoodle.embed.mongo.MongodExecutable;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Import(MongoConfig.class)
@ActiveProfiles("test")
@SpringBootTest(classes = Ilha.class)
@EnableMongoRepositories(basePackageClasses = IlhaRepository.class)
public class IlhaControllerTest {
    @Autowired
    private MongodExecutable mongodExecutable;

    @SpyBean
    private IlhaRepository ilhaRepo;

    @BeforeEach
    public void tearUp() throws IOException {
        mongodExecutable.start();
    }

    @AfterEach
    public void tearDown() {
        mongodExecutable.stop();
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @DisplayName("Teste de Persistir Pessoas")
    void testSavePessoa() {
        var novaIlha = new Ilha("teste nome", "teste status");
        var test = ilhaRepo.save(novaIlha);
        assertThat(test.getNome(), equalTo("teste nome"));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @DisplayName("Teste de Persistir Pessoas 2")
    void testSavePessoa2() {

        var novaIlha = new Ilha("teste nome", "teste status");
        var novaIlha2 = new Ilha("teste nome", "teste status");
        ilhaRepo.save(novaIlha);
        ilhaRepo.save(novaIlha2);
        var tamanho = ilhaRepo.findAll().size();
        assertThat(tamanho, equalTo(2));
    }

}

