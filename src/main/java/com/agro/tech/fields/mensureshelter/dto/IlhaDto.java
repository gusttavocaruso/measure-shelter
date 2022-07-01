package com.agro.tech.fields.mensureshelter.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.agro.tech.fields.mensureshelter.model.Medidas;

public class IlhaDto {

  @NotEmpty
  public String nome;

  @NotEmpty
  public String status;

  public List<Medidas> medidas;

}
