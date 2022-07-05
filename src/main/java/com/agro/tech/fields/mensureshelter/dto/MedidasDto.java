package com.agro.tech.fields.mensureshelter.dto;

import javax.validation.constraints.NotEmpty;

public class MedidasDto {

  @NotEmpty(message = "Campo obrigatório. Não pode ficar vazio")
  public String descricao;

  @NotEmpty(message = "Campo obrigatório. Não pode ficar vazio")
  public String valor;

  @NotEmpty(message = "Campo obrigatório. Não pode ficar vazio")
  public String unidadeDeMedida;

}

