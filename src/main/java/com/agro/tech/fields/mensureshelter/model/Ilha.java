package com.agro.tech.fields.mensureshelter.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ilha {

  @Id
  private String id;

  private String nome;
  private String status;
  private List<Medidas> medidas;

  public Ilha(String nome, String status) {
    this.nome = nome;
    this.status = status;
    this.medidas = new ArrayList<>();
  }

}
