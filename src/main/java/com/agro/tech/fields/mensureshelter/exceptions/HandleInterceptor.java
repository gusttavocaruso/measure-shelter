package com.agro.tech.fields.mensureshelter.exceptions;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleInterceptor {

  @ExceptionHandler(IOException.class)
  public ResponseEntity<String> eException(IOException e) {
    return ResponseEntity.status(403).body(e.getMessage());
  }

  @ExceptionHandler(CampoObrigatorioException.class)
  public ResponseEntity<String> campoObrigatorio(CampoObrigatorioException e) {
    return ResponseEntity.status(404).body((e.getMessage()));
  }
}
