package com.agro.tech.fields.mensureshelter.exceptions;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleInterceptor {

  @ExceptionHandler(IOException.class)
  public ResponseEntity<String> ioExcep(IOException e) {
    return ResponseEntity.status(403).body(e.getMessage());
  }

  @ExceptionHandler(ExceptionBadRequest.class)
  public ResponseEntity<String> badRequestExcept(ExceptionBadRequest e) {
    return ResponseEntity.status(400).body((e.getMessage()));
  }

  @ExceptionHandler(ExceptionNotFound.class)
  public ResponseEntity<String> notFoundExcept(ExceptionNotFound e) {
    return ResponseEntity.status(404).body((e.getMessage()));
  }

}
