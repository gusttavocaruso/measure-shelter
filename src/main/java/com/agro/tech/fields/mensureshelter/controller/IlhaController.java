package com.agro.tech.fields.mensureshelter.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agro.tech.fields.mensureshelter.model.Ilha;
import com.agro.tech.fields.mensureshelter.model.Medidas;
import com.agro.tech.fields.mensureshelter.service.IlhaService;

@RestController
@RequestMapping("/ilha")
public class IlhaController {

  @Autowired
  IlhaService ilhaService;

  @PostMapping("/criar")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<Ilha> criarIlha(@RequestBody Ilha ilha) {
    return ResponseEntity.ok(ilhaService.criarIlha(ilha));
  }

  @GetMapping
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<List<Ilha>> searchIlha() {
    return ResponseEntity.ok(ilhaService.searchIlhas());
  }

  @PutMapping("/atualizar/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<Ilha> updateIlha(@PathVariable String id, @RequestBody Ilha ilha) {
    return ResponseEntity.ok(ilhaService.updateIlha(id, ilha));
  }

  @DeleteMapping("/remover/{id}")
  public ResponseEntity<String> removerIlha(@PathVariable String id) {
    return ResponseEntity.ok(ilhaService.deleteIlha(id));
  }

  // Criar medidas por ilha
  @PostMapping("/{id}/medidas/adicionar")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<Ilha> adicionarMedidas(
      @PathVariable String id,
      @RequestBody Medidas medidas) {
    return ResponseEntity.ok(ilhaService.adicionarMedidas(id, medidas));
  }

  @GetMapping("/{id}/medidas")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<List<Medidas>> searchMedidas(@PathVariable String id) {
    return ResponseEntity.ok(ilhaService.searchMedidas(id));
  }

  @PutMapping("/{idIlha}/medidas/atualizar/{idMedida}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<Medidas> updateMedida(
      @PathVariable String idIlha,
      @PathVariable Integer idMedida,
      @RequestBody Medidas medida) {
    return ResponseEntity.ok(ilhaService.updateMedida(idIlha, idMedida, medida));
  }

  @DeleteMapping("/{idIlha}/medidas/remover/{idMedida}")
  public ResponseEntity<String> removerIlha(
      @PathVariable String idIlha,
      @PathVariable Integer idMedida) {
    return ResponseEntity.ok(ilhaService.deleteMedida(idIlha, idMedida));
  }

}
