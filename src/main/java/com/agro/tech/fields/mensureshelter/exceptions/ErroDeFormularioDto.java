package com.agro.tech.fields.mensureshelter.exceptions;

public class ErroDeFormularioDto {

  private String campo;
  private String erro;

  public ErroDeFormularioDto(String campo, String erro) {
    this.campo = campo;
    this.erro = erro;
  }

  public String getCampo() {
    return campo;
  }

  public String getErro() {
    return erro;
  }

}
