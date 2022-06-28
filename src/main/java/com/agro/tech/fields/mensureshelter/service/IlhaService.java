package com.agro.tech.fields.mensureshelter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agro.tech.fields.mensureshelter.model.Ilha;
import com.agro.tech.fields.mensureshelter.repository.IlhaRepository;

@Service
public class IlhaService {

  @Autowired
  IlhaRepository ilhaRepository;

  public Ilha criarIlha(String nome, String status) {
    return ilhaRepository.save(new Ilha(nome, status));
  }

}
