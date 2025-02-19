package com.salesianos.data.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EntityNotFoundException;
import lombok.Builder;
import lombok.extern.java.Log;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.List;

@Log
@RestControllerAdvice
public class GlobalErrorController
    extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ProblemDetail handleProductNotFound(EntityNotFoundException ex) {
        ProblemDetail result = ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND,
                        ex.getMessage());
        result.setTitle("Entidad no encontrada");
        result.setType(URI.create("https://www.salesianos-triana.edu/errors/entity-not-found"));
        result.setProperty("author", "Luismi");

        return result;

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ProblemDetail result = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Error de validación");

        List<ApiValidationSubError> subErrors =
                ex.getAllErrors().stream()
                        .map(ApiValidationSubError::fromError)
                        .toList();

        result.setProperty("invalid-params", subErrors);


        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(result);
    }

    @Builder
    record ApiValidationSubError(
            String object,
            String message,
            @JsonInclude(JsonInclude.Include.NON_NULL)
            String field,
            @JsonInclude(JsonInclude.Include.NON_NULL)
            Object rejectedValue
    ){

        public ApiValidationSubError(String object, String message) {
            this(object, message, null, null);
        }

        public static ApiValidationSubError fromError(ObjectError error) {

            ApiValidationSubError result = null;

            if (error instanceof FieldError fieldError) {
                result = ApiValidationSubError.builder()
                        .object(fieldError.getObjectName())
                        .message(fieldError.getDefaultMessage())
                        .field(fieldError.getField())
                        .rejectedValue(fieldError.getRejectedValue())
                        .build();
            } else  {
                result = ApiValidationSubError.builder()
                        .object(error.getObjectName())
                        .message(error.getDefaultMessage())
                        .build();
            }

            return result;


        }


    }
}
