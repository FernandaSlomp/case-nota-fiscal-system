package br.com.fernandaslomp.casenotafiscalsystem.exception.handler;

import br.com.fernandaslomp.casenotafiscalsystem.exception.ClientNotFoundException;
import br.com.fernandaslomp.casenotafiscalsystem.exception.InvalidNotaFiscalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler(InvalidNotaFiscalException.class)
  public ResponseEntity<Object> invalidNotaFiscalException(InvalidNotaFiscalException exception) {
    return ResponseEntity.badRequest().body(exception.getMessage());
  }
  @org.springframework.web.bind.annotation.ExceptionHandler(ClientNotFoundException.class)
  public ResponseEntity<Object> clientNotFoundException(ClientNotFoundException exception) {
    return ResponseEntity.badRequest().body(exception.getMessage());
  }

}
