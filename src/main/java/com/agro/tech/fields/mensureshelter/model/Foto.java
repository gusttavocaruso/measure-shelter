package com.agro.tech.fields.mensureshelter.model;

import java.time.LocalDate;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Foto {

  @Id
  private String id;
  private String nome;
  private LocalDate dataDeCriacao;
  private Binary conteudo;
  private String tipoDeConteudo;
  private long tamanho;


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

  public LocalDate getDataDeCriacao() {
    return dataDeCriacao;
  }

  public void setDataDeCriacao(LocalDate dataDeCriacao) {
    this.dataDeCriacao = dataDeCriacao;
  }

  public Binary getConteudo() {
    return conteudo;
  }

  public void setConteudo(Binary conteudo) {
    this.conteudo = conteudo;
  }

  public String getTipoDeConteudo() {
    return tipoDeConteudo;
  }

  public void setTipoDeConteudo(String tipoDeConteudo) {
    this.tipoDeConteudo = tipoDeConteudo;
  }

  public long getTamanho() {
    return tamanho;
  }

  public void setTamanho(long tamanho) {
    this.tamanho = tamanho;
  }

}
