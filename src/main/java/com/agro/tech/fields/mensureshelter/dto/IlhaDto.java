package com.agro.tech.fields.mensureshelter.dto;

import java.util.List;

import com.agro.tech.fields.mensureshelter.model.Medidas;

public class IlhaDto {

  public String nome;
  public String status;
  public List<Medidas> medidas;

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

  public void setMedidas(List<Medidas> medidas) {
    this.medidas = medidas;
  }

}
