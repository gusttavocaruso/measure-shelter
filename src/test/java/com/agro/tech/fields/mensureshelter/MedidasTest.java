package com.agro.tech.fields.mensureshelter;

import com.agro.tech.fields.mensureshelter.dto.MedidasDto;
import com.agro.tech.fields.mensureshelter.model.Ilha;
import com.agro.tech.fields.mensureshelter.model.Medidas;
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
public class MedidasTest {

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
  @DisplayName("Teste de Persistir Medidas")
  void testSaveMedidas() {

    var novaIlha = new Ilha("teste nome", "teste status");
    var ilhaSalva = ilhaRepo.save(novaIlha);
    Ilha ilhaEncontrada = ilhaRepo.findById(ilhaSalva.getId()).orElseThrow();

    MedidasDto dto = new MedidasDto();
    dto.descricao = "temperatura";
    dto.valor = "30";
    dto.unidadeDeMedida = "graus";

    Medidas medidas = new Medidas();
    medidas.setId(ilhaEncontrada.getMedidas().size() + 1);
    medidas.setDescricao(dto.descricao);
    medidas.setValor(dto.valor);
    medidas.setUnidadeDeMedida(dto.unidadeDeMedida);

    ilhaEncontrada.adicionarMedida(medidas);
    
    Medidas medidaSalva = ilhaEncontrada.getMedidas().get(0);

    assertThat(medidaSalva.getDescricao(), equalTo("temperatura"));
    assertThat(medidaSalva.getValor(), equalTo("30"));
    assertThat(medidaSalva.getUnidadeDeMedida(), equalTo("graus"));
  }

  @Test
  @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
  @DisplayName("Teste de Persistir Lista Medidas")
  void testListarMedidas() {

    var novaIlha = new Ilha("teste nome", "teste status");
    var ilhaSalva = ilhaRepo.save(novaIlha);
    Ilha ilhaEncontrada = ilhaRepo.findById(ilhaSalva.getId()).orElseThrow();

    MedidasDto dto = new MedidasDto();
    dto.descricao = "temperatura";
    dto.valor = "30";
    dto.unidadeDeMedida = "graus";

    Medidas medidas = new Medidas();
    medidas.setId(ilhaEncontrada.getMedidas().size() + 1);
    medidas.setDescricao(dto.descricao);
    medidas.setValor(dto.valor);
    medidas.setUnidadeDeMedida(dto.unidadeDeMedida);

    ilhaEncontrada.adicionarMedida(medidas);
    ilhaEncontrada.adicionarMedida(medidas);
    
    int tamanho = ilhaEncontrada.getMedidas().size();

    assertThat(tamanho, equalTo(2));
  }

}
