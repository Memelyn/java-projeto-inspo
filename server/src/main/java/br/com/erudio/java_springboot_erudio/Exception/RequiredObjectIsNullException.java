package br.com.erudio.java_springboot_erudio.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException {

  public RequiredObjectIsNullException() {
    super("Required object is null");
  }

  public RequiredObjectIsNullException(String message) {
    super(message);
  }
}
