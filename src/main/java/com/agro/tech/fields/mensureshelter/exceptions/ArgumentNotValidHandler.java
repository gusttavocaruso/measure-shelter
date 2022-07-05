package com.agro.tech.fields.mensureshelter.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ArgumentNotValidHandler {

  @Autowired
  private MessageSource messageSource;

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<ErrorFormatter> catchErrors(MethodArgumentNotValidException errors) {

    List<ErrorFormatter> errorList = new ArrayList<>();
    List<FieldError> fieldErrors = errors.getBindingResult().getFieldErrors();

    fieldErrors.forEach(err -> {
      String message = messageSource
          .getMessage(err, LocaleContextHolder.getLocale());

      ErrorFormatter erro = new ErrorFormatter(err.getField(), message);
      errorList.add(erro);
    });

    return errorList;
  }

}