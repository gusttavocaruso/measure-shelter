package com.agro.tech.fields.mensureshelter.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agro.tech.fields.mensureshelter.dto.IlhaDto;
import com.agro.tech.fields.mensureshelter.service.IlhaService;

@RestController
public class IlhaController {

  @Autowired
  IlhaDto ilhaDto;

  @Autowired
  IlhaService ilhaService;

  @PostMapping
  public Response criarIlha(@RequestBody String nome) {
    ilhaDto.setNome(nome);

    return Response.ok().build();
  }


}
