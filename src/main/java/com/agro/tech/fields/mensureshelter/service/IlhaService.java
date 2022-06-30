package com.agro.tech.fields.mensureshelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agro.tech.fields.mensureshelter.dto.IlhaDto;
import com.agro.tech.fields.mensureshelter.dto.MedidasDto;
import com.agro.tech.fields.mensureshelter.model.Ilha;
import com.agro.tech.fields.mensureshelter.model.Medidas;
import com.agro.tech.fields.mensureshelter.repository.IlhaRepository;

@Service
public class IlhaService {

  @Autowired
  IlhaRepository ilhaRepository;

  @Autowired
  Ilha ilha;

  @Autowired
  Medidas medidas;

  // C
  public Ilha criarIlha(IlhaDto ilhaDto) {
    ilha.setNome(ilhaDto.getNome());
    ilha.setStatus(ilhaDto.getStatus());

    return ilhaRepository.save(ilha);
  }

  // R
  public List<Ilha> searchIlhas() {
    return ilhaRepository.findAll();
  }

  // U
  public Ilha updateIlha(String id, IlhaDto ilhaDto) {
    Ilha ilhaUpdate = ilhaRepository.findById(id).orElseThrow();

    ilhaUpdate.setNome(ilhaDto.getNome());
    ilhaUpdate.setStatus(ilhaDto.getStatus());

    return ilhaRepository.save(ilhaUpdate);
  }

  // D
  public String deleteIlha(String id) {
    ilhaRepository.deleteById(id);
    return "Ilha removida com sucesso";
  }

  // C - Medidas
  public Ilha adicionarMedidas(String id, MedidasDto medidasDto) {
    Ilha ilhaById = ilhaRepository.findById(id).orElseThrow();

    medidas.setId(ilhaById.getMedidas().size() + 1);
    medidas.setDescricao(medidasDto.descricao);
    medidas.setValor(medidasDto.valor);
    medidas.setUnidadeDeMedida(medidasDto.unidadeDeMedida);

    ilhaById.adicionarMedida(medidas);
    return ilhaRepository.save(ilhaById);
  }

  // R - Medidas
  public List<Medidas> searchMedidas(String id) {
    Ilha ilhaById = ilhaRepository.findById(id).orElseThrow();
    return ilhaById.getMedidas();
  }

  // U - Medidas
  public Medidas updateMedida(String idIlha, Integer idMedida, MedidasDto medidasDto) {
    Ilha ilhaById = ilhaRepository.findById(idIlha).orElseThrow();

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
    Ilha ilhaById = ilhaRepository.findById(idIlha).orElseThrow();

    Medidas medidaDelete = ilhaById.getMedidas().stream()
    .filter((med) -> med.getId().equals(idMedida)).findFirst().get();

    ilhaById.getMedidas().remove(medidaDelete);
    ilhaRepository.save(ilhaById);

    return "Medida removida com sucesso";
  }

}
