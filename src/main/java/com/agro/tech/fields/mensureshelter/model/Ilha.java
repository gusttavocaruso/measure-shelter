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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<Medidas> getMedidas() {
    return medidas;
  }

  public void adicionarMedida(Medidas medidas) {
    this.medidas.add(medidas);
  }

}
