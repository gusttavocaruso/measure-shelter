package com.agro.tech.fields.mensureshelter.model;

public class Medidas {

  private String descricao;
  private String valor;
  private String unidadeDeMedida;

  public Medidas(String descricao, String valor, String unidadeDeMedida) {
    this.descricao = descricao;
    this.valor = valor;
    this.unidadeDeMedida = unidadeDeMedida;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public String getUnidadeDeMedida() {
    return unidadeDeMedida;
  }

  public void setUnidadeDeMedida(String unidadeDeMedida) {
    this.unidadeDeMedida = unidadeDeMedida;
  }

}
