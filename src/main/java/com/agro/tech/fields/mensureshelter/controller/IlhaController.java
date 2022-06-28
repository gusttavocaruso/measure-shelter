package com.agro.tech.fields.mensureshelter.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agro.tech.fields.mensureshelter.model.Ilha;
import com.agro.tech.fields.mensureshelter.service.IlhaService;

@RestController
@RequestMapping("/ilha")
public class IlhaController {

  @Autowired
  IlhaService ilhaService;

  @PostMapping("/criar")
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<Ilha> criarIlha(
      @RequestBody String nome,
      @RequestBody String status) {
    return ResponseEntity.ok(ilhaService.criarIlha(nome, status));
  }

}
