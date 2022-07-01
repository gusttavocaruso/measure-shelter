package com.agro.tech.fields.mensureshelter.dto;

import javax.validation.constraints.NotEmpty;

public class MedidasDto {

  @NotEmpty
  public String descricao;

  @NotEmpty
  public String valor;

  @NotEmpty
  public String unidadeDeMedida;

}

