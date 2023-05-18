package br.com.xbrain.desafio.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExcecaoHandler {
    HttpStatus status = HttpStatus.I_AM_A_TEAPOT;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadrao> handlerArgumentoInvalido(MethodArgumentNotValidException ex, HttpServletRequest request){
        status = HttpStatus.BAD_REQUEST;

        ErroPadrao error = new ErroPadrao();
        error.setTimeStamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Campos obrigatórios incompletos!");
        error.setMessage(ex.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}
