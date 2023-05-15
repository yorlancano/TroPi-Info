package com.RegistroTropiInfo.Validaciones.Exepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final Long serialVersionId = 1L;

    public ResourceNotFoundException(String messenger){
        super(messenger);
    }
}
