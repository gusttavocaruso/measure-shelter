package com.agro.tech.fields.mensureshelter.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.agro.tech.fields.mensureshelter.model.Medidas;

public class IlhaDto {

  @NotNull
  public String nome;

  @NotBlank
  public String status;

  public List<Medidas> medidas;

}
