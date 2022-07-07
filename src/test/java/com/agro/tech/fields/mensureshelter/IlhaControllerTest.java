package com.agro.tech.fields.mensureshelter;

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
  @DisplayName("Teste de Persistir Ilhas")
  void testSaveIlha() {

    var novaIlha = new Ilha("teste nome", "teste status");
    var test = ilhaRepo.save(novaIlha);

    assertThat(test.getNome(), equalTo("teste nome"));

  }

  @Test
  @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
  @DisplayName("Teste de Persistir Lista Ilhas")
  void testListarIlhas() {

    var novaIlha = new Ilha("teste nome", "teste status");
    var novaIlha2 = new Ilha("teste nome", "teste status");

    ilhaRepo.save(novaIlha);
    ilhaRepo.save(novaIlha2);

    var tamanho = ilhaRepo.findAll().size();

    assertThat(tamanho, equalTo(2));
  }

  @Test
  @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
  @DisplayName("Teste Deletar Ilha")
  void testDeleteIlha() {

    var novaIlha = new Ilha("teste nome", "teste status");
    var novaIlha2 = new Ilha("teste nome", "teste status");

    ilhaRepo.save(novaIlha);
    ilhaRepo.save(novaIlha2);

    ilhaRepo.delete(novaIlha);

    var tamanho = ilhaRepo.findAll().size();

    assertThat(tamanho, equalTo(1));
  }

  @Test
  @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
  @DisplayName("Teste Editar Ilha")
  void testEditarIlha() {

    var novaIlha = new Ilha("teste nome", "teste status");
    Ilha ilhaSalva = ilhaRepo.save(novaIlha);

    ilhaSalva.setNome("novo nome");
    ilhaRepo.save(ilhaSalva);
    
    var ilhaMod = ilhaRepo.findById(ilhaSalva.getId()).orElseThrow();

    assertThat(ilhaMod.getNome(), equalTo("novo nome"));
  }

}
