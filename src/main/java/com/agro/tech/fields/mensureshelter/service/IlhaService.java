package com.agro.tech.fields.mensureshelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agro.tech.fields.mensureshelter.model.Ilha;
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

}
