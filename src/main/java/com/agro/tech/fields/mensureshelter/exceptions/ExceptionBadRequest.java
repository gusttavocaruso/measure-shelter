package com.agro.tech.fields.mensureshelter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ExceptionBadRequest extends RuntimeException {

  public ExceptionBadRequest(String msg) {
    super(msg);
  }

}
