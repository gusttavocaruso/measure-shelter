package com.agro.tech.fields.mensureshelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agro.tech.fields.mensureshelter.dto.IlhaDto;
import com.agro.tech.fields.mensureshelter.dto.MedidasDto;
import com.agro.tech.fields.mensureshelter.exceptions.ExceptionBadRequest;
import com.agro.tech.fields.mensureshelter.exceptions.ExceptionNotFound;
import com.agro.tech.fields.mensureshelter.model.Ilha;
import com.agro.tech.fields.mensureshelter.model.Medidas;
import com.agro.tech.fields.mensureshelter.repository.IlhaRepository;

@Service
public class IlhaService {

  @Autowired
  Ilha ilha;
  @Autowired
  Medidas medidas;
  @Autowired
  IlhaRepository ilhaRepository;

  // C - Ilha
  public Ilha criarIlha(IlhaDto ilhaDto) {
    List<Ilha> ilhas = ilhaRepository.findAll();

    for (Ilha i : ilhas) {
      if (i.getNome().equals(ilhaDto.nome)) {
        throw new ExceptionBadRequest("Nome de ilha já usado. Escolha outro");
      }
    }

    ilha.setNome(ilhaDto.nome);
    ilha.setStatus(ilhaDto.status);

    return ilhaRepository.save(ilha);
  }

  // R - Ilha
  public List<Ilha> searchIlhas() {
    return ilhaRepository.findAll();
  }

  // U - Ilha
  public Ilha updateIlha(String id, IlhaDto ilhaDto) {
    Ilha ilhaUpdate = ilhaRepository.findById(id)
        .orElseThrow(() -> new ExceptionNotFound("Ilha não encontrada."));

    ilhaUpdate.setNome(ilhaDto.nome);
    ilhaUpdate.setStatus(ilhaDto.status);

    return ilhaRepository.save(ilhaUpdate);
  }

  // D - Ilha
  public String deleteIlha(String id) {
    Ilha ilhaDelete = ilhaRepository.findById(id)
        .orElseThrow(() -> new ExceptionNotFound("Não é possível remover. Ilha não encontrada."));

    ilhaRepository.deleteById(ilhaDelete.getId());
    return "Ilha removida com sucesso";
  }

  // C - Medidas
  public Ilha adicionarMedidas(String id, MedidasDto medidasDto) {
    Ilha ilhaById = ilhaRepository.findById(id)
        .orElseThrow(() -> new ExceptionNotFound("Ilha não encontrada."));

    for (Medidas meds : ilhaById.getMedidas()) {
      if (meds.getDescricao().equals(medidasDto.descricao)) {
        throw new ExceptionBadRequest("Medida já existe para essa ilha. Gentileza atualize-a");
      }
    }

    if (ilhaById.getStatus().equals("Inoperante")) {
      throw new ExceptionBadRequest(
          "Não é possível adicionar novas medidas à esta Ilha. Ilha inoperante");
    }

    medidas.setId(ilhaById.getMedidas().size() + 1);
    medidas.setDescricao(medidasDto.descricao);
    medidas.setValor(medidasDto.valor);
    medidas.setUnidadeDeMedida(medidasDto.unidadeDeMedida);

    ilhaById.adicionarMedida(medidas);
    return ilhaRepository.save(ilhaById);
  }

  // R - Medidas
  public List<Medidas> searchMedidas(String id) {
    Ilha ilhaById = ilhaRepository.findById(id)
        .orElseThrow(() -> new ExceptionNotFound("Ilha não encontrada."));
    return ilhaById.getMedidas();
  }

  // U - Medidas
  public Medidas updateMedida(String idIlha, Integer idMedida, MedidasDto medidasDto) {
    Ilha ilhaById = ilhaRepository.findById(idIlha)
        .orElseThrow(() -> new ExceptionNotFound("Ilha não encontrada."));

    if (ilhaById.getStatus().equals("Inoperante")) {
      throw new ExceptionBadRequest(
          "Não é possível adicionar novas medidas à esta Ilha. Ilha inoperante");
    }

    Medidas medidaUpdate = ilhaById.getMedidas().stream()
        .filter((med) -> med.getId().equals(idMedida)).findFirst().get();

    medidaUpdate.setDescricao(medidasDto.descricao);
    medidaUpdate.setValor(medidasDto.valor);
    medidaUpdate.setUnidadeDeMedida(medidasDto.unidadeDeMedida);

    ilhaRepository.save(ilhaById);
    return medidaUpdate;
  }

  // D - Medidas
  public String deleteMedida(String idIlha, Integer idMedida) {
    Ilha ilhaById = ilhaRepository.findById(idIlha)
        .orElseThrow(() -> new ExceptionNotFound("Ilha não encontrada."));

    Medidas medidaDelete = ilhaById.getMedidas().stream()
        .filter((med) -> med.getId().equals(idMedida)).findFirst().get();

    ilhaById.getMedidas().remove(medidaDelete);
    ilhaRepository.save(ilhaById);

    return "Medida removida com sucesso";
  }

}
