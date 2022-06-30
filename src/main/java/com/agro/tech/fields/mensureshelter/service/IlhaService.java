package com.agro.tech.fields.mensureshelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agro.tech.fields.mensureshelter.model.Ilha;
import com.agro.tech.fields.mensureshelter.model.Medidas;
import com.agro.tech.fields.mensureshelter.repository.IlhaRepository;

@Service
public class IlhaService {

  @Autowired
  IlhaRepository ilhaRepository;

  // C
  public Ilha criarIlha(Ilha ilha) {
    return ilhaRepository.save(ilha);
  }

  // R
  public List<Ilha> searchIlhas() {
    return ilhaRepository.findAll();
  }

  // U
  public Ilha updateIlha(String id, Ilha ilha) {
    Ilha ilhaUpdate = ilhaRepository.findById(id).orElseThrow();

    ilhaUpdate.setNome(ilha.getNome());
    ilhaUpdate.setStatus(ilha.getStatus());

    return ilhaRepository.save(ilhaUpdate);
  }

  // D
  public String deleteIlha(String id) {
    ilhaRepository.deleteById(id);
    return "Ilha removida com sucesso";
  }

  // C - Medidas
  public Ilha adicionarMedidas(String id, Medidas medidas) {
    Ilha ilha = ilhaRepository.findById(id).orElseThrow();

    Integer idMedidas = ilha.getMedidas().size() + 1;
    medidas.setId(idMedidas);

    ilha.adicionarMedida(medidas);
    return ilhaRepository.save(ilha);
  }

  // R - Medidas
  public List<Medidas> searchMedidas(String id) {
    Ilha ilha = ilhaRepository.findById(id).orElseThrow();
    return ilha.getMedidas();
  }

  // U - Medidas
  public Medidas updateMedida(String idIlha, Integer idMedida, Medidas medida) {
    Ilha ilha = ilhaRepository.findById(idIlha).orElseThrow();

    Medidas medidaUpdate = ilha.getMedidas().stream()
      .filter((med) -> med.getId().equals(idMedida)).findFirst().get();

    // Medidas medidaUpdate = searchMedidaById(medidas, idMedida);

    // if (medidaUpdate == null) {
    //   return medida;
    // } else {
      // medidaUpdate.setDescricao(medida.getDescricao());
      // medidaUpdate.setValor(medida.getValor());
      // medidaUpdate.setUnidadeDeMedida(medida.getUnidadeDeMedida());
      // ilha.adicionarMedida(medidaUpdate);
    // }

    // ilhaRepository.save(ilha);
    return medidaUpdate;
  }

  // função para encontrar medida especificada no parametro da rota
  public Medidas searchMedidaById(List<Medidas> medidas, Integer idMedida) {
    for (Medidas med : medidas) {
      if (med.getId().equals(idMedida)) {
        return med;
      }
    }
    return null;
  }

}
