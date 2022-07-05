package com.agro.tech.fields.mensureshelter.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.agro.tech.fields.mensureshelter.model.Medidas;

public class IlhaDto {

  @NotEmpty(message = "Campo obrigatório. Não pode ficar vazio")
  public String nome;

  @NotEmpty(message = "Campo obrigatório. Não pode ficar vazio")
  public String status;

  public List<Medidas> medidas;

}
