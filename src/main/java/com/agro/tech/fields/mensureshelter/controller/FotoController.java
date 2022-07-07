package com.agro.tech.fields.mensureshelter.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.agro.tech.fields.mensureshelter.model.Foto;
import com.agro.tech.fields.mensureshelter.service.FotoService;

@RestController
@RequestMapping("/foto")
public class FotoController {

  @Autowired
  FotoService fotoService;

  @PostMapping("/inserir")
  public ResponseEntity<Foto> inserirFoto(@RequestParam(value = "imagem") MultipartFile imagem)
      throws IOException {
    return ResponseEntity.status(201).body(fotoService.inserirFoto(imagem));
  }

  @GetMapping("/listar")
  public ResponseEntity<List<Foto>> listarFotos() {
    return ResponseEntity.ok(fotoService.listarFotos());
  }

  @GetMapping(value = "/baixar/{id}",
      produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
  public ResponseEntity<byte[]> baixarFoto(@PathVariable String id) {
    return ResponseEntity.ok(fotoService.baixarFoto(id));
  }

  @DeleteMapping("/deletar")
  public ResponseEntity<String> deletarFotos() {
    return ResponseEntity.ok(fotoService.deletarFotos());
  }

}
