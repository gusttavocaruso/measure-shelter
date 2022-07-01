package com.agro.tech.fields.mensureshelter.controller;

import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

import com.agro.tech.fields.mensureshelter.dto.IlhaDto;
import com.agro.tech.fields.mensureshelter.dto.MedidasDto;
import com.agro.tech.fields.mensureshelter.model.Ilha;
import com.agro.tech.fields.mensureshelter.model.Medidas;
import com.agro.tech.fields.mensureshelter.service.IlhaService;

import javax.validation.Valid;

@RestController
@RequestMapping("/ilha")
public class IlhaController {

  @Autowired
  IlhaService ilhaService;

  // C - Ilha
  @PostMapping("/criar")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<Ilha> criarIlha(
      @RequestBody @Valid IlhaDto ilhaDto) {
    return ResponseEntity.ok(ilhaService.criarIlha(ilhaDto));
  }

  // R - Ilha
  @GetMapping
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<List<Ilha>> searchIlha() {
    return ResponseEntity.ok(ilhaService.searchIlhas());
  }

  // U - Ilha
  @PutMapping("/atualizar/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<Ilha> updateIlha(@PathVariable String id, @RequestBody IlhaDto ilhaDto) {
    return ResponseEntity.ok(ilhaService.updateIlha(id, ilhaDto));
  }

  // D - Ilha
  @DeleteMapping("/remover/{id}")
  public ResponseEntity<String> removerIlha(@PathVariable String id) {
    return ResponseEntity.ok(ilhaService.deleteIlha(id));
  }

  // C - Medidas
  @PostMapping("/{id}/medidas/adicionar")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<Ilha> adicionarMedidas(
      @PathVariable String id,
      @RequestBody MedidasDto medidasDto) {
    return ResponseEntity.ok(ilhaService.adicionarMedidas(id, medidasDto));
  }

  // R - Medidas
  @GetMapping("/{id}/medidas")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<List<Medidas>> searchMedidas(@PathVariable String id) {
    return ResponseEntity.ok(ilhaService.searchMedidas(id));
  }

  // U - Medidas
  @PutMapping("/{idIlha}/medidas/atualizar/{idMedida}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<Medidas> updateMedida(
      @PathVariable String idIlha,
      @PathVariable Integer idMedida,
      @RequestBody MedidasDto medidasDto) {
    return ResponseEntity.ok(ilhaService.updateMedida(idIlha, idMedida, medidasDto));
  }

  // D - Medidas
  @DeleteMapping("/{idIlha}/medidas/remover/{idMedida}")
  public ResponseEntity<String> removerIlha(
      @PathVariable String idIlha,
      @PathVariable Integer idMedida) {
    return ResponseEntity.ok(ilhaService.deleteMedida(idIlha, idMedida));
  }

}
