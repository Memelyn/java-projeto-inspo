package br.com.erudio.java_springboot_erudio.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// vamos atribuir a excessão a um status code específico
@ResponseStatus(HttpStatus.NOT_FOUND) //
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {

        super(message);
    }
}
